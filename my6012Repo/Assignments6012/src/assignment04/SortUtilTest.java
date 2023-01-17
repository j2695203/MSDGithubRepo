package assignment04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static java.util.Collections.swap;
import static org.junit.jupiter.api.Assertions.*;

class SortUtilTest {
    static Random random = new Random();

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

    @Test
    void testMergeSortInteger(){
        // create a list with disordered values
        ArrayList<Integer> data = new ArrayList<>();
        data.add(2);
        data.add(0);
        data.add(-1);
        data.add(-2);
        data.add(1);
        // create comparator with ascending order
        Comparator<? super Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if( o1 < o2 )
                    return -1;
                else if( o1 > o2 )
                    return 1;
                else
                    return 0;
            }
        };
        // sort the list
        SortUtil.mergesort(data, comparator);
        // check if the sorted list is as expected order
        ArrayList<Integer> expected = new ArrayList<>( Arrays.asList(-2,-1,0,1,2) );
        assertEquals(expected,data);
    }

    @Test
    void testQuickSortInteger(){
        // create a list with disordered values
        ArrayList<Integer> data = new ArrayList<>();
        data.add(2);
        data.add(0);
        data.add(-1);
        data.add(-2);
        data.add(1);
        // create comparator with ascending order
        Comparator<? super Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if( o1 < o2 )
                    return -1;
                else if( o1 > o2 )
                    return 1;
                else
                    return 0;
            }
        };
        // sort the list
        SortUtil.quicksort(data, comparator);
        // check if the sorted list is as expected order
        ArrayList<Integer> expected = new ArrayList<>( Arrays.asList(-2,-1,0,1,2) );
        assertEquals(expected,data);
    }

    @Test
    void testQuickSortString(){
        // create a list with disordered values
        ArrayList<String> data = new ArrayList<>();
        data.add("Give");
        data.add("Me");
        data.add("A");
        data.add("Break");
        data.add("Please");
        // create comparator with descending order
        Comparator<? super String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if( o1.compareTo(o2) < 0 )
                    return 1;
                else if( o1.compareTo(o2) > 0 )
                    return -1;
                else
                    return 0;
            }
        };
        // sort it
        SortUtil.quicksort(data, comparator);
        // check if the sorted list is as expected order
        ArrayList<String> expected = new ArrayList<>( Arrays.asList("Please","Me","Give","Break","A") );
        assertEquals(expected,data);
    }

    @Test
    void testMergeSortString(){
        // create a list with disordered values
        ArrayList<String> data = new ArrayList<>();
        data.add("Give");
        data.add("Me");
        data.add("A");
        data.add("Break");
        data.add("Please");
        // create comparator with descending order
        Comparator<? super String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if( o1.compareTo(o2) < 0 )
                    return 1;
                else if( o1.compareTo(o2) > 0 )
                    return -1;
                else
                    return 0;
            }
        };
        // sort it
        SortUtil.mergesort(data, comparator);
        // check if the sorted list is as expected order
        ArrayList<String> expected = new ArrayList<>( Arrays.asList("Please","Me","Give","Break","A") );
        assertEquals(expected,data);
    }

    @Test
    void testQuickSortIntegerAverageCase(){
        // create a list with disordered values
        ArrayList<Integer> data = new ArrayList<>();
        data = generateAverageCase(100);
        // create comparator with ascending order
        Comparator<? super Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if( o1 < o2 )
                    return -1;
                else if( o1 > o2 )
                    return 1;
                else
                    return 0;
            }
        };
        // sort the list
        SortUtil.quicksort(data, comparator);
        // check if the sorted list is as expected order
        for( int i = 0; i < data.size() - 1; i++ ){
            assertTrue( comparator.compare(data.get(i+1), data.get(i)) > 0 );
        }
    }

    @Test
    void testMergeSortIntegerAverageCase(){
        // create a list with disordered values
        ArrayList<Integer> data = new ArrayList<>();
        data = generateAverageCase(100);
        // create comparator with ascending order
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if( o1 < o2 )
                    return -1;
                else if( o1 > o2 )
                    return 1;
                else
                    return 0;
            }
        };
        // sort the list
        SortUtil.mergesort(data, comparator);
        // check if the sorted list is as expected order
        for( int i = 0; i < data.size() - 1; i++ ){
            assertTrue( comparator.compare(data.get(i+1), data.get(i)) > 0 );
        }
    }

}