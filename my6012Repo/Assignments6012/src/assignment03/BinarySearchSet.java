package assignment03;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.util.Arrays.sort;

/*
    Rules:
    1. data in BinarySearchSet<E> must be backed by a basic array (do not use a Java List)
    2. Start with a modestly-size array and grow the capacity as needed.
 */

public class BinarySearchSet<E> implements SortedSet<E>, Iterable<E> {
    private E[] array_;
    private final int initialCapacity_ = 2097152;
    protected int capacity_;
    private int size_ = 0;
    private Comparator<? super E> comparator_ = null;

    // constructor without comparator
    public BinarySearchSet(){
        array_ = (E[]) new Object[initialCapacity_];
        capacity_ = initialCapacity_;
    }
    // constructor with comparator
    public BinarySearchSet(Comparator<? super E> comparator){
        // Think for a bit about why we're using the "super" generic constraint.
        array_ = (E[]) new Object[initialCapacity_];
        capacity_ = initialCapacity_;
        comparator_ = comparator;
    }
    /**
     * @return The comparator used to order the elements in this set, or null if
     *         this set uses the natural ordering of its elements (i.e., uses
     *         Comparable).
     */
    @Override
    public Comparator comparator() {
        return comparator_;
    }

    /**
     * @return the first (lowest, smallest) element currently in this set
     * @throws NoSuchElementException if the set is empty
     */
    @Override
    public E first() throws NoSuchElementException {
        if( size() == 0 )
            throw new NoSuchElementException("Empty array.");
        return array_[0];
    }

    /**
     * @return the last (highest, largest) element currently in this set
     * @throws NoSuchElementException if the set is empty
     */
    @Override
    public E last() throws NoSuchElementException {
        if( size() == 0 )
            throw new NoSuchElementException("Empty array!");
        return array_[size()-1];
    }

    /**
     * Adds the specified element to this set if it is not already present and
     * not set to null.
     *
     * @param  element to be added to this set
     * @return true if this set did not already contain the specified element
     */
    @Override
    public boolean add(E element) {

        if( element == null ){
            return false;
        }

        // if array is empty, inserts element at position 0
        if( size() == 0 ){
            array_[0] = element;
            size_ += 1;
            return true;
        }

        // if the element already exists, return false
//        if( contains(element) ){
//            return false;
//        }

        // check array length if it needs growing
        if( size() == capacity_){
            array_ = doubleArray();
        }

        // move other elements
        int binaryInsertPosition = binarySearchInsertPosition(element);
        for( int i = size(); i > binaryInsertPosition; i--){
            array_[i] = array_[i-1];
        }

        // insert element at specific position
        array_[binaryInsertPosition] = element;
        size_ += 1;

        return true;


    }


    /**
     * Adds all of the elements in the specified collection to this set if they
     * are not already present and not set to null.
     *
     * @param elements collection containing elements to be added to this set
     * @return true if this set changed as a result of the call
     */
    @Override
    public boolean addAll(Collection<? extends E> elements) {
        if( elements == null ){
            return false;
        }
        boolean setChanged = false;

        for( E el: elements ){
            if( add(el) ){
                setChanged = true;
            }
        }
        return setChanged;
    }

    /**
     * Removes all of the elements from this set. The set will be empty after
     * this call returns.
     */
    @Override
    public void clear() {
        array_ = (E[]) new Object[initialCapacity_];
        capacity_ = initialCapacity_;
        size_ = 0;
    }

    /**
     * @param element whose presence in this set is to be tested
     * @return true if this set contains the specified element
     */
    @Override
    public boolean contains(E element) {
        return ( binarySearchContainPosition(element) != -1 );
    }

    /**
     * @param elements collection to be checked for containment in this set
     * @return true if this set contains all of the elements of the specified
     *         collection
     */
    @Override
    public boolean containsAll(Collection<? extends E> elements) {
        if( elements == null ){
            return false;
        }
        for( E el: elements ){
            if( !contains(el) ){
                return false;
            }
        }
        return true;
    }

    /**
     * @return true if this set contains no elements
     */
    @Override
    public boolean isEmpty() {
        return( size() == 0 );
    }

    /**
     * @return an iterator over the elements in this set, where the elements are
     *         returned in sorted (ascending) order
     */
    @Override
    public Iterator iterator() {
        return new BinaryIterator();
    }

    private class BinaryIterator implements Iterator<E>{
        int cursor;
        int lastReturn;

        // constructor
        BinaryIterator(){
            cursor = 0;
            lastReturn = -1;
        }

        @Override
        public boolean hasNext() {
            return ( cursor < size() );
        }

        @Override
        public E next() {
            if( hasNext() ){
                lastReturn = cursor;
                cursor += 1;
                return array_[lastReturn];
            }
            return null;
        }
    }

    /**
     * Removes the specified element from this set if it is present.
     *
     * @param element to be removed from this set, if present
     * @return true if this set contained the specified element
     */
    @Override
    public boolean remove(E element) {
        if( !contains(element) ){
            return false;
        }else{
            int low = binarySearchContainPosition(element);
            for( int i = low; i < size()-1; i++ ){
                array_[i] = array_[i+1];
            }
            size_ -= 1;
            return true;
        }
    }

    /**
     * Removes from this set all of its elements that are contained in the
     * specified collection.
     *
     * @param elements collection containing elements to be removed from this set
     * @return true if this set changed as a result of the call
     */
    @Override
    public boolean removeAll(Collection<? extends E> elements) {
        if( elements == null ){
            return false;
        }
        boolean setChanged = false;
        for( E el: elements ){
            if( remove(el) ){
                setChanged = true;
            }
        }
        return setChanged;
    }

    /**
     * @return the number of elements in this set
     */
    @Override
    public int size() {
        return size_;
    }

    /**
     * @return an array containing all of the elements in this set, in sorted
     *         (ascending) order.
     */
    @Override
    public E[] toArray() {
        E[] arrayCopy = (E[]) new Object[size_]; // to resize the array
        System.arraycopy(array_,0,arrayCopy,0,size_);
        return arrayCopy;
    }

    /**
     * @param element to search
     * @return If the array contains the element, return the position of the element.
     *         Return -1 if the array doesn't contain the element.
     */
    public int binarySearchContainPosition( E element ){

        int low = 0;
        int high = size() - 1;
        int mid = 0;

        while( low <= high ){
            mid = ( low + high ) / 2;
            if( element.equals(array_[mid]) ){
                return mid;
            }
            // use comparator or comparable
            if( comparator_ != null ){
                if ( comparator_.compare(element, array_[mid]) < 0 ){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if( ((Comparable<E>) element).compareTo(array_[mid]) < 0 ){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * @param element to search
     * @return If the array contains the element, return -1.
     *         Return the index of high if the array doesn't contain the element.
     */
    // binary search, return -1 if the element existed, and return index of low if not existed
    public int binarySearchInsertPosition(E element ){

        int low = 0;
        int high = size() - 1;
        int mid = 0;

        while( low <= high ){
            mid = ( low + high ) / 2;
            if( element.equals(array_[mid]) ){
                return -1;
            }
            // use comparator or comparable
            if( comparator_ != null ){
                if ( comparator_.compare(element, array_[mid]) < 0 ){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if( ((Comparable<E>) element).compareTo(array_[mid]) < 0 ){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
        }
        return low;
    }

    /**
     * Double the length of array by 2 times
     *
     * @return double-sized array with original value
     */
    public E[] doubleArray(){
        E[] temp = (E[]) new Object[size() * 2];
        capacity_ *= 2;
        for( int i = 0; i < size(); i++ ){
            temp[i] = array_[i];
        }
        return temp;
    }

}
