package assignment06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuadProbeHashTableTest {
    QuadProbeHashTable quadProbeHashTable;
    int capacity = 5;

    @BeforeEach
    void setUp() {
        HashFunctor functor = new GoodHashFunctor();
        quadProbeHashTable = new QuadProbeHashTable(capacity,functor);
    }

    @Test
    void add() {

        assertTrue(quadProbeHashTable.add("one"));
        assertTrue(quadProbeHashTable.add("two"));
        assertTrue(quadProbeHashTable.add("three"));
        assertTrue(quadProbeHashTable.add("four"));
        assertEquals(quadProbeHashTable.getCapacity_(),11);
        assertTrue(quadProbeHashTable.add("five"));
        assertTrue(quadProbeHashTable.add("six"));
        assertEquals(quadProbeHashTable.size(), 6);
        assertEquals(quadProbeHashTable.getCapacity_(),11);


    }

    @Test
    void addAll() {
        ArrayList<String> nums = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "ten"));
        assertTrue(quadProbeHashTable.addAll(nums));
//        quadProbeHashTable.add("twelve");
//        quadProbeHashTable.print();

        assertEquals(quadProbeHashTable.size(), 6);
        assertEquals(quadProbeHashTable.getCapacity_(),11);

    }

    @Test
    void clear() {
        assertTrue(quadProbeHashTable.add("one"));
        assertTrue(quadProbeHashTable.add("two"));
        assertTrue(quadProbeHashTable.add("three"));
        assertTrue(quadProbeHashTable.add("four"));
        assertTrue(quadProbeHashTable.add("five"));
        assertTrue(quadProbeHashTable.add("six"));
        quadProbeHashTable.clear();
        assertEquals(quadProbeHashTable.size(), 0);
        assertEquals(quadProbeHashTable.getCapacity_(), 5);

    }

    @Test
    void contains() {
        assertTrue(quadProbeHashTable.add("one"));
        assertTrue(quadProbeHashTable.add("two"));
        assertTrue(quadProbeHashTable.add("three"));
        assertTrue(quadProbeHashTable.add("four"));
        assertTrue(quadProbeHashTable.add("five"));
        assertTrue(quadProbeHashTable.add("six"));
        assertTrue(quadProbeHashTable.contains("two"));
        assertFalse((quadProbeHashTable.contains("seven")));
    }

    @Test
    void containsAll() {
        ArrayList<String> nums = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "ten"));
        ArrayList<String> nums1 = new ArrayList<>(Arrays.asList("one", "four", "five", "ten"));
        ArrayList<String> nums2 = new ArrayList<>(Arrays.asList("one", "two", "six"));
        quadProbeHashTable.addAll(nums);
        assertTrue(quadProbeHashTable.containsAll(nums1));
        assertFalse(quadProbeHashTable.containsAll(nums2));

    }

    @Test
    void isEmpty() {
        assertTrue(quadProbeHashTable.isEmpty());
        assertTrue(quadProbeHashTable.add("one"));
        assertTrue(quadProbeHashTable.add("two"));
        assertTrue(quadProbeHashTable.add("three"));
        assertTrue(quadProbeHashTable.add("four"));
        assertFalse(quadProbeHashTable.isEmpty());
    }

    @Test
    void remove() {
        ArrayList<String> nums = new ArrayList<>(Arrays.asList("one", "two", "three"));
        quadProbeHashTable.addAll(nums);
        quadProbeHashTable.remove("one");
        assertEquals(quadProbeHashTable.size(),2);
        quadProbeHashTable.remove("two");
        assertEquals(quadProbeHashTable.size(),1);
        quadProbeHashTable.remove("three");
        assertEquals(quadProbeHashTable.size(),0);

    }

    @Test
    void removeAll() {
        ArrayList<String> nums = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "ten"));
        ArrayList<String> nums1 = new ArrayList<>(Arrays.asList("one", "four", "five", "ten"));
        ArrayList<String> nums2 = new ArrayList<>(Arrays.asList("one", "four", "five", "ten"));
        quadProbeHashTable.addAll(nums);
        assertTrue(quadProbeHashTable.removeAll(nums1));
        assertEquals(quadProbeHashTable.size(),2);
        assertFalse(quadProbeHashTable.removeAll(nums2));

    }

    @Test
    void size() {
        assertTrue(quadProbeHashTable.add("one"));
        assertTrue(quadProbeHashTable.add("two"));
        assertTrue(quadProbeHashTable.add("three"));
        assertTrue(quadProbeHashTable.add("four"));
        assertEquals(quadProbeHashTable.size(),4);
    }

    @Test
    void setCapacity(){
        assertEquals(quadProbeHashTable.getCapacity_(), 5);
    }

}