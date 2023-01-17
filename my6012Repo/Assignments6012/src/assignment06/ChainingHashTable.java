package assignment06;

import java.util.Collection;
import java.util.LinkedList;

public class ChainingHashTable implements Set<String>{
    public int capacity_; // capacity of the table array
    private int size_; // number of strings in the table
    private LinkedList<String>[] storage_; // represent the table
    private HashFunctor functor_; // save the hash method to be use (bad, mediocre or good)

    //constructor
    @SuppressWarnings("unchecked") // ???
    public ChainingHashTable(int capacity, HashFunctor functor){
        capacity_ = capacity;
        size_ = 0;
        functor_ = functor;
        storage_ = (LinkedList<String>[]) new LinkedList[capacity];
        // create LinkedLists in each position of the array
        for( int i = 0; i < capacity; i++ ){
            storage_[i] = new LinkedList<>();
        }
    }

    /**
     * Ensures that this set contains the specified item.
     *
     * @param item - the item whose presence is ensured in this set
     * @return true if this set changed as a result of this method call (that is, if
     * the input item was actually inserted); otherwise, returns false
     */
    @Override
    public boolean add(String item) {
        if( item == null || contains(item) ){
            return false;
        }

        int index = Math.abs(functor_.hash(item) % capacity_);
        storage_[index].add(item);
        size_++;
        return true;
    }

    /**
     * Ensures that this set contains all items in the specified collection.
     *
     * @param items - the collection of items whose presence is ensured in this set
     * @return true if this set changed as a result of this method call (that is, if
     * any item in the input collection was actually inserted); otherwise,
     * returns false
     */
    @Override
    public boolean addAll(Collection<? extends String> items) {
        if( items == null ){
            return false;
        }
        boolean isChanged = false;
        for( String str: items ){
            if( add(str) ){
                isChanged = true;
            }
        }
        return isChanged;
    }

    /**
     * Removes all items from this set. The set will be empty after this method
     * call.
     */
    @Override
    public void clear() {
        for (LinkedList<String> strings : storage_) { // hash table array
            strings.clear();
        }
        size_ = 0;
    }

    /**
     * Determines if there is an item in this set that is equal to the specified
     * item.
     *
     * @param item - the item sought in this set
     * @return true if there is an item in this set that is equal to the input item;
     * otherwise, returns false
     */
    @Override
    public boolean contains(String item) {
        if( item == null || size_ == 0 ){
            return false;
        }
        // find the hash index of the item
        int index = Math.abs(functor_.hash(item) % capacity_);
        // return if the LinkedList in this bucket contains the item
        return storage_[index].contains(item);
    }

    /**
     * Determines if for each item in the specified collection, there is an item in
     * this set that is equal to it.
     *
     * @param items - the collection of items sought in this set
     * @return true if for each item in the specified collection, there is an item
     * in this set that is equal to it; otherwise, returns false
     */
    @Override
    public boolean containsAll(Collection<? extends String> items) {
        for( String str: items ){
            if( !contains(str) ){
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if this set contains no items.
     */
    @Override
    public boolean isEmpty() {
        return( size_ == 0 );
    }

    /**
     * Ensures that this set does not contain the specified item.
     *
     * @param item - the item whose absence is ensured in this set
     * @return true if this set changed as a result of this method call (that is, if
     * the input item was actually removed); otherwise, returns false
     */
    @Override
    public boolean remove(String item) {
        if( item == null || !contains(item) ){
            return false;
        }
        // find item's hash code
        int index = functor_.hash(item) % capacity_;
        // return if remove the item from the LinkedList in this bucket
        storage_[index].remove(item);
        size_--;
        return true;
    }

    /**
     * Ensures that this set does not contain any of the items in the specified
     * collection.
     *
     * @param items - the collection of items whose absence is ensured in this set
     * @return true if this set changed as a result of this method call (that is, if
     * any item in the input collection was actually removed); otherwise,
     * returns false
     */
    @Override
    public boolean removeAll(Collection<? extends String> items) {
        if( items == null || size_ == 0 ){
            return false;
        }
        boolean isChanged = false;
        for( String str: items ){
            if( remove(str) ){
                isChanged = true;
            }
        }
        return isChanged;
    }

    /**
     * Returns the number of items in this set.
     */
    @Override
    public int size() {
        return size_;
    }

    /**
     * Calculate collision time
     * @return collision time
     */
    public int collisionTime() {
        int collision = 0;
        for (int i = 0; i < capacity_; i++) { // hash table array
//            System.out.println("index " + i + ": " + storage_[i].size());
            if( storage_[i].size() > 1 ){
                collision += storage_[i].size() - 1;
            }
        }
        return collision;
    }
}
