package assignment06;

import java.util.Collection;
import java.util.LinkedList;

public class QuadProbeHashTable implements Set<String>{
    public int capacity_;
    public int initialCapacity_;
    private int size_;
    private String[] storage_;
//    private boolean[] deleteStorage_; // record a string was deleted in the storage
    private HashFunctor functor_;

    /** Constructs a hash table of the given capacity that uses the hashing function
     * specified by the given functor.
     */
    public QuadProbeHashTable(int capacity, HashFunctor functor){
        capacity_ = findNextPrime(capacity);
        initialCapacity_ = capacity_;
        size_ = 0;
        functor_ = functor;
        storage_ = new String[capacity_];
//        deleteStorage_ = new boolean[capacity_];
    }

    private int findNextPrime(int input){
        boolean isPrime = true;

        // if input can be divided by i, input is not a prime number
        for( int i = 2; i < input; i++){
            if( input % i == 0 ){
                isPrime = false;
                break;
            }
        }
        // return input if it is a prime number
        if( isPrime ){
            return input;
        }
        // else keep finding the next prime number
        return findNextPrime(input+1);
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

        // resize and rehash if load factor >= 0.5
        if( size_ * 1.0 / capacity_ >= 0.5 ){
            // resize
            capacity_ = findNextPrime(capacity_*2);
            // rehash
            String[] old = storage_;
//            boolean[] oldDelete = deleteStorage_;
            storage_ = new String[capacity_];
//            deleteStorage_ = new boolean[capacity_];
            size_ = 0;
            for( String str: old){
                add(str);
            }
        }
        // add new item
        int index = quadraticHash(item) ;
        storage_[index] = item;
        size_++;
        return true;
    }

    private int quadraticHash(String item){
        int index = functor_.hash(item) % capacity_ ;
        int times = 0;
        // keep finding empty position to add item
        while(true){
            // add if there's no item in this position
            if( storage_[index] == null ){
               return index;
            }else{
                times++;
                index = Math.floorMod(index + (int) Math.pow(times,2) , capacity_);
            }
        }
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
        capacity_ = initialCapacity_;
        storage_ = new String[capacity_];
//        deleteStorage_ = new boolean[capacity_];
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
        for( String str: storage_){
            if( str != null && str.equals(item) ){
                return true;
            }
        }
        return false;
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
        if( items == null ){
            return false;
        }

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
        return size_ == 0;
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
        for( int i = 0; i < storage_.length; i++ ){
            if( storage_[i] != null && storage_[i].equals(item) ){
                storage_[i] = null;
                size_--;
                return true;
            }
        }
        return false;
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

    public int getCapacity_(){
        return capacity_;
    }
}
