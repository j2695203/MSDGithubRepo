package assignment04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import static java.util.Collections.swap;

public class SortUtil<T> {

    private static int threshold_ = 30;
    private static String pivotSelect_ = "median";// set up pivot: right, random, middle, median
    static Random random = new Random();

/*
MERGE SORT: when size < threshold, use insertion sort
 */

    /**
     * MERGE SORT #1: sets left/right bound, without creating arrays/arrayLists when splitting into two groups.
     * This method is a driver method for merge sort #1.
     *
     * @param  list  array list to be sorted
     * @param  comparator rules to compare
     */
    public static <T> void mergeSort1_Driver(ArrayList<T> list, Comparator<? super T> comparator){
        T[] arr = (T[]) new Object[list.size()]; // create an empty array to fill in result
        mergeSort1(list, arr, comparator, 0 , list.size()-1);

    }
    /**
     * MERGE SORT #1: sets left/right bound, without creating arrays/arrayLists when splitting into two groups.
     * This method is a process for merge sort.
     *
     * @param  list  array list to be sorted
     * @param  arr empty array to fill in result
     * @param  comparator rules to compare
     * @param  left the left bound index of the array list to be sorted
     * @param  right the right bound index of the array list to be sorted
     */
    private static <T> void mergeSort1(ArrayList<T> list, T[] arr, Comparator<? super T> comparator, int left, int right){
        // base case: use insertion sort when small size
        if(left >= right){
            return;
        }
        if(right - left < threshold_){
            insertionSort1(list, left, right, comparator);
        }
        int mid = (left + right)/2;

        mergeSort1(list, arr, comparator, left , mid);
        mergeSort1(list, arr, comparator, mid+1 , right);
        merge1(list, arr, comparator, left, right, mid);
    }

    /**
     * MERGE SORT #1: sets left/right bound, without creating arrays/arrayLists when splitting into two groups.
     * This method is to merge elements from left/right groups into one array.
     *
     * @param  list  array list to be sorted
     * @param  arr empty array to fill in result
     * @param  comparator rules to compare
     * @param  left the left bound index of the array list to be sorted
     * @param  right the right bound index of the array list to be sorted
     * @param  mid the middle index of the array list to be sorted
     */
    private static <T> void merge1(ArrayList<T> list, T[] arr, Comparator<? super T> comparator, int left, int right, int mid){

        int lhs = left; // index of the smallest element in lhs
        int rhs = mid + 1; // index of the smallest element in rhs
        int index = 0; // index of the sorted array to be returned

        while(lhs <= mid && rhs <= right){
            if(comparator.compare(list.get(lhs),list.get(rhs)) < 0){
                arr[index] = list.get(lhs);
                lhs++;
                index++;
            }
            else{
                arr[index] = list.get(rhs);
                rhs++;
                index++;
            }
        }
        while(lhs <= mid ){
            arr[index] = list.get(lhs);
            lhs++;
            index++;
        }
        while(rhs <= right){
            arr[index] = list.get(rhs);
            rhs++;
            index++;
        }

        // save the value from fill-in array to original array list
        for(int i = 0; i < right-left+1; i++){
            list.set(left + i, arr[i]);
        }

    }
    /**
     * MERGE SORT #2: create two empty arrays when splitting into two groups.
     * This method is a driver method for merge sort #2.
     *
     * @param  list  array list to be sorted
     * @param  comparator rules to compare
     *
     */
    public static <T> void mergeSort2_Driver(ArrayList<T> list, Comparator<? super T> comparator){
        T[] arr = (T[]) list.toArray(); // cast arrayList to array
        mergeSort2( arr, comparator);

        // save the value from array to original arrayList
        for(int i = 0; i < arr.length; i++){
            list.set(i, arr[i]);
        }
    }
    /**
     * MERGE SORT #2: create two empty arrays when splitting into two groups.
     * This method is a process for merge sort.
     *
     * @param  arr array with unsorted elements
     * @param  comparator rules to compare
     *
     */
    private static <T> void mergeSort2(T[] arr, Comparator<? super T> comparator){
        // base case: use insertion sort when small size
        if(arr.length < 2){
            return;
        }
        if(arr.length < threshold_){
            insertionSort3(arr, comparator);
            return;
        }

        int mid = arr.length/2;

        // create two empty arrays when splitting into two groups
        T[] lhs = (T[]) new Object[mid];
        T[] rhs = (T[]) new Object[arr.length - mid];

        // copy values from input array into left/right arrays
        System.arraycopy(arr, 0, lhs, 0, mid);
        System.arraycopy(arr, mid , rhs , 0, rhs.length);

        mergeSort2(lhs,comparator);
        mergeSort2(rhs,comparator);
        merge2(lhs, rhs,comparator,arr);

    }
    /**
     * MERGE SORT #2: create two empty arrays when splitting into two groups.
     * This method is to merge elements from left/right groups into one array.
     *
     * @param  lhs left half of the unsorted array
     * @param  rhs left half of the unsorted array
     * @param  comparator rules to compare
     * @param  arr array with unsorted elements
     *
     */
    private static <T> void merge2(T[] lhs, T[] rhs, Comparator<? super T> comparator, T[] arr){
        int r = 0; // index of the smallest element in rhs
        int l = 0; // index of the smallest element in lhs
        int s = 0; // index of the sorted arraylist to be returned

        while(l < lhs.length && r < rhs.length){
            if(comparator.compare(lhs[l],rhs[r]) < 0){
                arr[s] = lhs[l];
                s++;
                l++;
            }
            else{
                arr[s] = rhs[r];
                r++;
                s++;
            }
        }
        while(l < lhs.length){
            arr[s] = lhs[l];
            s++;
            l++;
        }
        while(r < rhs.length){
            arr[s] = rhs[r];
            s++;
            r++;
        }

    }

    /**
     * MERGE SORT #3: create two empty arrayLists when splitting into two groups.
     * This method is a driver method also a process for merge sort #3.
     *
     * @param  list  array list to be sorted
     * @param  comparator rules to compare
     *
     */
    public static <T> void mergesort(ArrayList<T> list, Comparator<? super T> comparator){
        // base case: use insertion sort when small size
        if(list.size() < 2){
            return;
        }
        if(list.size() < threshold_){
            insertionSort2(list, comparator);
            return;
        }
        // split to half array list
        int mid = list.size()/2;
        ArrayList<T> lhs = new ArrayList<>(mid);
        ArrayList<T> rhs = new ArrayList<>(list.size()-mid);

        for(int i = 0; i < mid; i++){
            lhs.add(list.get(i));
        }
        for(int j = mid; j < list.size(); j++){
            rhs.add(list.get(j));
        }
        // recursive each split array lists until size < threshold
        mergesort(lhs,comparator);
        mergesort(rhs,comparator);
        // merge two split array lists into one
        merge3(lhs, rhs, comparator, list);
    }
    /**
     * MERGE SORT #3: create two empty arrayLists when splitting into two groups.
     * This method is to merge elements from left/right groups into one arrayList.
     *
     * @param  lhs left half of the unsorted array
     * @param  rhs left half of the unsorted array
     * @param  comparator rules to compare
     * @param  list arrayList with unsorted elements
     *
     */
    private static <T> void merge3(ArrayList<T> lhs, ArrayList<T> rhs, Comparator<? super T> comparator, ArrayList<T> list){
        int r = 0; // index of the smallest element in rhs
        int l = 0; // index of the smallest element in lhs
        int s = 0; // index of the sorted arraylist to be returned

        // put the smaller element between two group to result
        while(l < lhs.size() && r < rhs.size()){
            if(comparator.compare(lhs.get(l),rhs.get(r)) < 0){
                list.set(s, lhs.get(l));
                s++;
                l++;
            }
            else{
                list.set(s, rhs.get(r));
                r++;
                s++;
            }
        }
        // put remaining elements in the group into result
        while(l < lhs.size()){
            list.set(s, lhs.get(l));
            s++;
            l++;
        }
        while(r < rhs.size()){
            list.set(s, rhs.get(r));
            s++;
            r++;
        }
    }


/*
INSERTION SORT
 */

    /**
     * This method is an insertion sort method for an array list ranging from left bound to right bound.
     * When an array list using mergeSort1 method to sort, mergeSort1 will call this method when
     * the size is less than threshold.
     *
     * @param  list  array list to be sorted
     * @param  left the left bound index of the array list to be sorted
     * @param  right the right bound index of the array list to be sorted
     * @param  comparator rules to compare
     */
    public static <T> void insertionSort1(ArrayList<T> list, int left, int right, Comparator<? super T> comparator){
        //this for loop will iterate from the left index to the right index
        for (int i = left + 1; i <= right; i++) {
            T key = list.get(i); // element to be inserted
            int j = i - 1; // elements to be compared
            // if j > key, shift j to j+1
            while (j >= left && comparator.compare(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            // insert key to correct position
            list.set(j + 1, key);
        }
    }
    /**
     * This method is an insertion sort method for a whole array list.
     * When an array list using mergeSort2 method to sort, mergeSort2 will call this method when
     * the size is less than threshold.
     *
     * @param  list  array list to be sorted
     * @param  comparator rules to compare
     */
    public static <T> void insertionSort2(ArrayList<T> list, Comparator<? super T> comparator){
        for(int i = 1; i < list.size(); i++) {
            T key = list.get(i); // element to be inserted
            int j = i - 1; // elements to be compared
            // if j > key, shift j to j+1
            while (j >= 0 && comparator.compare(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            // insert key to correct position
            list.set(j + 1, key);
        }
    }
    /**
     * This method is an insertion sort method for a whole array.
     * When an array using mergeSort3 method to sort, mergeSort3 will call this method when
     * the size is less than threshold.
     *
     * @param  arr  array to be sorted
     * @param  comparator rules to compare
     */
    public static <T> void insertionSort3(T[] arr, Comparator<? super T> comparator){
        for(int i = 1; i < arr.length; i++) {
            T key = arr[i]; // element to be inserted
            int j = i - 1; // elements to be compared
            // if j > key, shift j to j+1
            while (j >= 0 && comparator.compare(arr[j], key) > 0) {
                arr[j+1] = arr[j];
                j--;
            }
            // insert key to correct position
            arr[j+1] = key;
        }
    }


/*
QUICK SORT
 */
    public static <T> void quicksort(ArrayList<T> list, Comparator<? super T> comparator){

        int left = 0;
        int right = list.size()-1;
        quicksortRecursive(list, comparator, left, right);
    }
    private static <T> void quicksortRecursive(ArrayList<T> list, Comparator<? super T> comparator, int left, int right){
        // base case when left >= right
        if( left < right ){
            int pivotIndex = partition(list, comparator, left, right);
            quicksortRecursive(list, comparator, left, pivotIndex-1 );
            quicksortRecursive(list, comparator, pivotIndex+1, right );
        }
    }
    private static <T> int partition(ArrayList<T> list, Comparator<? super T> comparator, int left, int right){
        // choose pivot (set up in member variable: right, random, middle, median)
        int pivot = pivotPosition(list, comparator, left, right);

        // swap pivot with the right
        swap(list, pivot, right);

        // position of the last sorted element that smaller than pivot
        int posFirstBigger = left;
        // traverse from left to element before pivot
        for( int i = left; i < right; i++ ){
            // if the element is smaller than pivot
            if( comparator.compare(list.get(i), list.get(right)) < 0 ){
                // swap to the left group
                swap(list, i, posFirstBigger);
                posFirstBigger++;
            }
        }
        // swap pivot with the first bigger element
        swap(list, right, posFirstBigger);
        // return position of pivot
        return posFirstBigger;
    }
    private static <T> int pivotPosition( ArrayList<T> list, Comparator<? super T> comparator, int left, int right ){
        if( pivotSelect_.equals("right")){
            return right;
        }else if( pivotSelect_.equals("random")){
            return ( (int)( Math.random() * (right-left) + left ) );
        }else if( pivotSelect_.equals("middle")){
            // return the index of the middle element
            return ( (left+right) / 2);
        }else if( pivotSelect_.equals("median")){
            // compare the first, middle and last elements, and return the index of median value
            T first = list.get(left);
            T middle = list.get( (left+right)/2 );
            T last = list.get(right);

            ArrayList<T> arr = new ArrayList<>();
            arr.add(first);
            arr.add(middle);
            arr.add(last);
            insertionSort2(arr, comparator);

            if( arr.get(1).equals(first) )
                return left;
            else if( arr.get(1).equals(middle) )
                return (left+right)/2;
            else
                return right;
        }
        return right; // default
    }


/*
Three Cases
 */
    // generates and returns an ArrayList of integers 1 to size in ascending order.
    public static ArrayList<Integer> generateBestCase(int size){
        ArrayList<Integer> bestCase = new ArrayList<>();
        for( int i = 0; i < size ; i++ ){
            bestCase.add(i);
        }
        return bestCase;
    }
    // generates and returns an ArrayList of integers 1 to size in permuted order
    public static ArrayList<Integer> generateAverageCase(int size){
        ArrayList<Integer> averageCase = new ArrayList<>();
        averageCase = generateBestCase(size);
        for( int i = averageCase.size() - 1; i > 0; i-- ){
            swap( averageCase, i, random.nextInt(i+1) );
        }
        return averageCase;
    }
    // generates and returns an ArrayList of integers 1 to size in descending order.
    public static ArrayList<Integer> generateWorstCase(int size){
        ArrayList<Integer> worstCase = new ArrayList<>();
        for( int i = size - 1 ; i >= 0 ; i-- ){
            worstCase.add(i);
        }
        return worstCase;
    }

}


