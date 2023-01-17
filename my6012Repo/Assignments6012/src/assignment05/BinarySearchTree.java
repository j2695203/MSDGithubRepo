package assignment05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable<? super T>> implements SortedSet<T>{
    // member variables
    class Node{
        T data_;
        Node left_, right_;
        // constructor for leaf node
        public Node(T data){
            data_ = data;
            left_ = null;
            right_ = null;
        }
    }
    Node root_;
    // constructor for empty tree
    public BinarySearchTree(){
        root_ = null;
    }

    /**
     * Ensures that this set contains the specified item.
     *
     * @param item - the item whose presence is ensured in this set
     * @return true if this set changed as a result of this method call (that is, if
     * the input item was actually inserted); otherwise, returns false
     * @throws NullPointerException if the item is null
     */
    @Override
    public boolean add(T item) throws NullPointerException {
        if( item == null ){  // throw an exception if the item is null
            throw new NullPointerException();
        }
        if( contains(item) ){  // item can't be added to the set if it's already in the set
            return false;
        }
        root_ = addRecursive(root_, item); // traverse from root, and add this item

        return true;
    }
    /**
     * Recursively find the correct position to add the item
     *
     * @param node - the node which the search starts from
     * @param data - the data to be added to the tree
     * @return return the new node added to the tree, or updated node
     */
    private Node addRecursive(Node node, T data){
        // if the node is empty, create a new node and return it to its parent
        if( node == null ){
            node = new Node(data);
            return node;
        }
        // if the data < node, keep searching inserted position in predecessor
        if( node.data_.compareTo(data) > 0 ){
            node.left_ = addRecursive(node.left_, data);

        // if the data > node, keep searching inserted position in successor
        }else{
            node.right_ = addRecursive(node.right_, data);
        }
        // return the node which updates its children
        return node;
    }

    /**
     * Ensures that this set contains all items in the specified collection.
     *
     * @param items - the collection of items whose presence is ensured in this set
     * @return true if this set changed as a result of this method call (that is, if
     * any item in the input collection was actually inserted); otherwise,
     * returns false
     * @throws NullPointerException if any of the items is null
     */
    @Override
    public boolean addAll(Collection<? extends T> items) throws NullPointerException {
        boolean isChanged = false;
        // if the tree already contains all items in the collection, return false
        if( containsAll(items) ){
            return false;
        }
        // add items to the tree, and record the tree is changed
        for(T data: items){
            if( data == null ){  // throw an exception if the item is null
                throw new NullPointerException();
            }
            if( add(data) ){
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
        root_ = null;
    }

    /**
     * Determines if there is an item in this set that is equal to the specified
     * item.
     *
     * @param item - the item sought in this set
     * @return true if there is an item in this set that is equal to the input item;
     * otherwise, returns false
     * @throws NullPointerException if the item is null
     */
    @Override
    public boolean contains(T item) throws NullPointerException {
        if( item == null ){  // throw an exception if the item is null
            throw new NullPointerException();
        }
        // if the tree contains the item, return true
        if( containsRecursive(root_, item) != null ){
            return true;
        }
        return false;
    }

    /**
     * Recursively search the position of specific item
     *
     * @param node - the node which the search starts from
     * @param data - the data to be searched in this set
     * @return return the node which data equals to input data
     */
    private Node containsRecursive(Node node, T data){
        // if the data can't be found in the tree, return null
        if( node == null ){
            return null;
        }
        // if the input data = node's data
        if( node.data_.equals(data) ){
            return node;
        }
        // keep searching data
        if( node.data_.compareTo(data) > 0 ){
            return containsRecursive(node.left_, data);
        }else{
            return containsRecursive(node.right_, data);
        }
    }

    /**
     * Determines if for each item in the specified collection, there is an item in
     * this set that is equal to it.
     *
     * @param items - the collection of items sought in this set
     * @return true if for each item in the specified collection, there is an item
     * in this set that is equal to it; otherwise, returns false
     * @throws NullPointerException if any of the items is null
     */
    @Override
    public boolean containsAll(Collection<? extends T> items) {
        for( T data: items){
            if( !contains(data) ){
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the first (i.e., smallest) item in this set.
     *
     * @throws NoSuchElementException if the set is empty
     */
    @Override
    public T first() throws NoSuchElementException {
        if( isEmpty() ){
            throw new NoSuchElementException();
        }
        Node root = root_;
        // keep searching from the left child node
        while( root.left_ != null){
            root = root.left_;
        }
        return root.data_;
    }

    /**
     * Returns true if this set contains no items.
     */
    @Override
    public boolean isEmpty() {
        if( root_ == null ){
            return true;
        }
        return false;
    }

    /**
     * Returns the last (i.e., largest) item in this set.
     *
     * @throws NoSuchElementException if the set is empty
     */
    @Override
    public T last() throws NoSuchElementException {
        if( isEmpty() ){
            throw new NoSuchElementException();
        }
        Node root = root_;
        // keep searching from the right child node
        while( root.right_ != null){
            root = root.right_;
        }
        return root.data_;
    }

    /**
     * Ensures that this set does not contain the specified item.
     *
     * @param item - the item whose absence is ensured in this set
     * @return true if this set changed as a result of this method call (that is, if
     * the input item was actually removed); otherwise, returns false
     * @throws NullPointerException if the item is null
     */
    @Override
    public boolean remove(T item) throws NullPointerException {

        if( item == null ){
            throw new NullPointerException();
        }
        // if the set doesn't contain this item, return false
        if( !contains(item) ){
            return false;
        }else{
            root_ = removeRecursive(root_, item);
        }
        return true;
    }

    /**
     * Recursively find the node to be removed
     *
     * @param node - the node which the search starts from
     * @param data - the data to be added to the tree
     * @return return the new node added to the tree, or updated node
     */
    private Node removeRecursive(Node node, T data){
        // tree is empty
        if( node == null ){
            return null;
        }
        // keep searching the data
        if( node.data_.compareTo(data) > 0 ){
            node.left_ = removeRecursive( node.left_, data );
        }else if( node.data_.compareTo(data) < 0 ){
            node.right_ = removeRecursive( node.right_, data );
        // if node's data = input data
        }else{
            // node is leaf node or has only one child
            if( node.left_ == null ){
                return node.right_;
            }else if( node.right_ == null ){
                return node.left_;
            }
            // node has two children
            // get inorder successor (min value in the right subtree)
            node.data_ = minValue(node.right_);
            // delete the inorder successor
            node.right_ = removeRecursive(node.right_, node.data_);
        }
        return node;
    }

    /**
     * Find the minimum value from the input node
     *
     * @param node - the node which the search starts from
     * @return the minimum value from the predecessor of input node
     */
    private T minValue( Node node ){
        T minVal = node.data_;
        // keep searching for the min value until the node doesn't have left child
        while( node.left_ != null ){
            minVal = node.left_.data_;
            node = node.left_;
        }
        return minVal;
    }

    /**
     * Ensures that this set does not contain any of the items in the specified
     * collection.
     *
     * @param items - the collection of items whose absence is ensured in this set
     * @return true if this set changed as a result of this method call (that is, if
     * any item in the input collection was actually removed); otherwise,
     * returns false
     * @throws NullPointerException if any of the items is null
     */
    @Override
    public boolean removeAll(Collection<? extends T> items) {
        boolean isChanged = false;
        // remove items in this set, and record the set is changed
        for( T data: items ){
            if( remove(data) ){
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
        if( isEmpty() ){
            return 0;
        }
        return toArrayList().size();
    }

    /**
     * Returns an ArrayList containing all of the items in this set, in sorted
     * order.
     */
    @Override
    public ArrayList<T> toArrayList() {
        ArrayList<T> allItems = new ArrayList<>();
        inorderRecursive(root_, allItems);
        return allItems;
    }

    /**
     * inorder traversal of BST, and set all of the items into an ArrayList in sorted order.
     *
     * @param node - the node which the search starts from
     * @param allItems - ArrayList to be set
     *
     */
    private void inorderRecursive(Node node, ArrayList<T> allItems){
        // if there's a node
        if( node != null ){
            // keep searching for the leftest child of this node
            inorderRecursive(node.left_, allItems);
            // add the leftest node in the ArrayList
            allItems.add(node.data_);
            // keep searching for the rightest child of this node
            inorderRecursive(node.right_, allItems);
        }
    }

    /**
     * Generate a dot file from BST
     * @param filename
     */
    void writeDot(String filename){

    }

}
