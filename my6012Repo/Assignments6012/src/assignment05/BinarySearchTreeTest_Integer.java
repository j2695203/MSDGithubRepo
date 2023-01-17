package assignment05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest_Integer {

    BinarySearchTree<Integer> integerBST = new BinarySearchTree<>();

    ArrayList<Integer> integersContained = new ArrayList<>(Arrays.asList(20, 1, 0));
    ArrayList<Integer> integersPartContained = new ArrayList<>(Arrays.asList(3, -3, 0));
    ArrayList<Integer> integersNotContained = new ArrayList<>(Arrays.asList(3, -3, 5));

    @BeforeEach
    void buildup(){
        integerBST.add(0);
        integerBST.add(20);
        integerBST.add(20); // an existed integer
        integerBST.add(-1); // negative integer
        integerBST.add(1);
    }

    @Test
    void add() {
        integerBST.add(-2);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(-2,-1,0,1,20));
        assertEquals(expected, integerBST.toArrayList());
    }

    @Test
    void addAll() {
        assertFalse(integerBST.addAll(integersContained)); // not changed if add contained numbers
        assertTrue(integerBST.addAll(integersPartContained)); //3, -3, 0
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(-3,-1,0,1,3,20));
        assertEquals(expected, integerBST.toArrayList());
    }

    @Test
    void clear() {
        integerBST.root_ = null;
        assertEquals(0,integerBST.size());
    }

    @Test
    void contains() {
        assertTrue(integerBST.contains(-1));
        assertFalse(integerBST.contains(-10));
    }

    @Test
    void containsAll() {
        assertTrue(integerBST.containsAll(integersContained));
        assertFalse(integerBST.containsAll(integersPartContained));
        assertFalse(integerBST.containsAll(integersNotContained));
    }

    @Test
    void first() {
        assertEquals(-1, integerBST.first());
    }

    @Test
    void isEmpty() {
        assertFalse(integerBST.isEmpty());
        integerBST.clear();
        assertTrue(integerBST.isEmpty());
    }

    @Test
    void last() {
        assertEquals(20, integerBST.last());
    }

    @Test
    void remove() {

        integerBST.remove(-1);
        ArrayList<Integer> expected1 = new ArrayList<>(Arrays.asList(0,1,20));
        assertEquals(expected1, integerBST.toArrayList());

        integerBST.remove(0); // remove root node
        ArrayList<Integer> expected2 = new ArrayList<>(Arrays.asList(1,20));
        assertEquals(expected2, integerBST.toArrayList());

        integerBST.remove(1);
        ArrayList<Integer> expected3 = new ArrayList<>(Arrays.asList(20));
        assertEquals(expected3, integerBST.toArrayList());

        integerBST.remove(20);
        assertTrue(integerBST.isEmpty());

    }

    @Test
    void removeAll() {
        assertFalse(integerBST.removeAll(integersNotContained));
        ArrayList<Integer> expected1 = new ArrayList<>(Arrays.asList(-1,0,1,20));
        assertEquals(expected1, integerBST.toArrayList());

        assertTrue(integerBST.removeAll(integersPartContained)); // 3, -3, 0
        ArrayList<Integer> expected2 = new ArrayList<>(Arrays.asList(-1,1,20));
        assertEquals(expected2, integerBST.toArrayList());

        assertTrue(integerBST.removeAll(integersContained)); // 20, 1, 0
        ArrayList<Integer> expected3 = new ArrayList<>(Arrays.asList(-1));
        assertEquals(expected3, integerBST.toArrayList());
    }

    @Test
    void size() {
        assertEquals(4, integerBST.size());
        integerBST.remove(20);
        assertEquals(3, integerBST.size());
        integerBST.clear();
        assertEquals(0, integerBST.size());
    }

    @Test
    void toArrayList() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(-1,0,1,20));
        assertEquals(expected, integerBST.toArrayList());
    }
}