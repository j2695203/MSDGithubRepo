package assignment03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchSetTest {

    /*
    Test add integers to the set, and the set should be sorted with order
     */
    @Test
    void testAddInteger() {
        BinarySearchSet<Integer> set_integer = new BinarySearchSet<>(); // test constructor

        // should be empty array
        assertTrue(set_integer.isEmpty());            // test isEmpty()
        assertEquals(0, set_integer.size()); // test size()

        // should add elements and be sorted with order
        set_integer.add(0);  // test add()
        set_integer.add(20);
        set_integer.add(20); // should not add existed element
        set_integer.add(-5);
        set_integer.add(10);

        // check empty and size again after add elements
        assertFalse(set_integer.isEmpty());           // test isEmpty()
        assertEquals(4, set_integer.size()); // test size()

        // create an expected array with the same value, order, and size as set.toArray()
        Integer[] expectedArray = new Integer[]{-5,0,10,20};

        // check if the set is ordered as expected
        assertArrayEquals(expectedArray,set_integer.toArray()); // test toArray()
        assertEquals(-5,set_integer.first());          // test first()
        assertEquals(20,set_integer.last());           // test last()
    }

    /*
    Test add strings to the set, and should be sorted with (descending) order based on comparator
     */
    @Test
    void testAddStringWithComparator() {

        // create a descending comparator
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if( o1.compareTo(o2) < 0 ){
                    return 1;
                }else if( o1.compareTo(o2) > 0 ){
                    return -1;
                }else{
                    return 0;
                }
            }
        };

        BinarySearchSet<String> set_string = new BinarySearchSet<>(comparator); // test constructor
        assertNotNull(set_string.comparator());  // test comparator()

        // should be empty array
        assertTrue(set_string.isEmpty());            // test isEmpty()
        assertEquals(0, set_string.size()); // test size()

        // should add elements and be sorted with order
        set_string.add("Give"); // test add()
        set_string.add("Me");
        set_string.add("A");
        set_string.add("Break");

        // check empty and size again after add elements
        assertFalse(set_string.isEmpty());           // test isEmpty()
        assertEquals(4, set_string.size()); // test size()

        // create an expected array with the same value, order, and size as set.toArray()
        String[] expectedArray = new String[]{"Me","Give","Break","A"};

        // check if the set is ordered as expected
        assertArrayEquals(expectedArray,set_string.toArray()); // test toArray()
        assertEquals("Me",set_string.first());         // test first()
        assertEquals("A",set_string.last());           // test last()
    }

    /*
   Test add all of the elements in the specified collection to this set
    */
    @Test
    void testAddAll() {

        BinarySearchSet<Integer> set_integer = new BinarySearchSet<>();

        // create an array with elements (with repeated number), and add to the set
        Integer[] integers = new Integer[] {8, -7, 10, -10, 0, 8};
        set_integer.addAll(List.of(integers));        // test addAll()
        assertEquals(5, set_integer.size());

        // create an expected array, and check if the set is ordered as expected
        Integer[] expectedArray = new Integer[] {-10, -7, 0, 8, 10};
        assertArrayEquals(expectedArray,set_integer.toArray());

    }

    @Test
    void testClear() {

        BinarySearchSet<Integer> set_integer = new BinarySearchSet<>();

        set_integer.add(0);
        set_integer.add(20);
        set_integer.add(-5);
        set_integer.add(10);

        assertEquals(4, set_integer.size());

        set_integer.clear();  // test clear()
        assertEquals(0,set_integer.size());
    }


    @Test
    void testContains() {

        BinarySearchSet<Integer> set_integer = new BinarySearchSet<>();

        set_integer.add(0);
        set_integer.add(20);
        set_integer.add(-5);
        set_integer.add(10);

        assertTrue(set_integer.contains(-5)); // test contains()
        assertFalse(set_integer.contains(50));

        // create some arrays
        Integer[] integersSame = new Integer[] {20, 10, -5, 0};
        Integer[] integersContainTwo = new Integer[] {20, 10};
        Integer[] integersSameButMore = new Integer[] {20, 10, -5, 0, 100, 50};

        assertTrue(set_integer.containsAll(List.of(integersSame)));      // test containsAll()
        assertTrue(set_integer.containsAll(List.of(integersContainTwo)));
        assertFalse(set_integer.containsAll(List.of(integersSameButMore)));
    }


    @Test
    void testIterator() {
        // create collection
        BinarySearchSet<Integer> set_integer = new BinarySearchSet<>();
        Integer[] integers = new Integer[] {1,2,3};
        set_integer.addAll(List.of(integers));

        Iterator iter = set_integer.iterator();

        assertEquals(1, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(2, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(3, iter.next());
        assertFalse(iter.hasNext());
//        iter.remove();
//        assertEquals(2,set_integer.last());
    }

    @Test
    void testRemove() {
        BinarySearchSet<Integer> set_integer = new BinarySearchSet<>();

        set_integer.add(0);
        set_integer.add(20);
        set_integer.add(-5);
        set_integer.add(10);

        Integer[] expected = new Integer[] {-5, 0, 10, 20};
        assertArrayEquals( expected, set_integer.toArray());

        set_integer.remove(0);  // test remove()
        expected = new Integer[] {-5, 10, 20};

        assertArrayEquals( expected, set_integer.toArray());
        assertFalse(set_integer.remove(100)); // remove an element doesn't exist

        // create a collections
        Integer[] integersContainTwo = new Integer[] {20, 10, 100};

        // remove 2 elements
        set_integer.removeAll(List.of(integersContainTwo));  // test removeAll()
        expected = new Integer[] {-5};

        assertArrayEquals(expected, set_integer.toArray() );

    }


    @Test
    void testDoubleArrayCapacity() {

        BinarySearchSet<Integer> set_integer = new BinarySearchSet<>();

        // create a collection which size equals to initial capacity
        Integer[] integers = new Integer[] {1,2,3,4,5,6,7,8,9,10};
        set_integer.addAll(List.of(integers));
        assertEquals(10, set_integer.size());

        // capacity is doubled when size > capacity
        set_integer.add(11);
        assertEquals(20, set_integer.capacity_);
    }
}