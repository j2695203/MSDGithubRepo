package assignment05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest_String{

    BinarySearchTree<String> BST = new BinarySearchTree<>();

    ArrayList<String> stringsContained = new ArrayList<>(Arrays.asList("bird","zebra","z")); // all strings are contained in BST
    ArrayList<String> stringsPartContained = new ArrayList<>(Arrays.asList("Zebra","panda","tiger")); // part of strings are contained in BST
    ArrayList<String> stringsNotContained = new ArrayList<>(Arrays.asList("Dog","octopus","whale")); // all strings are not contained in BST

    @BeforeEach
    void buildup(){
        BST.add("dog");
        BST.add("bird");
        BST.add("bird"); // an existed word
        BST.add("zebra");
        BST.add("Zebra"); // capital letter
        BST.add("z");
        BST.add("1"); // number
    }

    @Test
    void add() {
        BST.add("Monkey");
        BST.add("!");
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("!","1","Monkey","Zebra","bird","dog","z","zebra")); // based on ASCII
        assertEquals(expected, BST.toArrayList());
    }

    @Test
    void addAll() {
        assertFalse(BST.addAll(stringsContained)); // not changed if add contained numbers
        assertTrue(BST.addAll(stringsPartContained)); // "Zebra","panda","tiger"
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("1","Zebra","bird","dog","panda","tiger","z","zebra"));
        assertEquals(expected, BST.toArrayList());
    }

    @Test
    void clear() {
        BST.root_ = null;
        assertEquals(0, BST.size());
    }

    @Test
    void contains() {
        assertTrue(BST.contains("zebra"));
        assertFalse(BST.contains("turkey"));
    }

    @Test
    void containsAll() {
        assertTrue(BST.containsAll(stringsContained));
        assertFalse(BST.containsAll(stringsPartContained));
        assertFalse(BST.containsAll(stringsNotContained));
    }

    @Test
    void first() {
        assertEquals("1", BST.first());
    }

    @Test
    void isEmpty() {
        assertFalse(BST.isEmpty());
        BST.clear();
        assertTrue(BST.isEmpty());
    }

    @Test
    void last() {
        assertEquals("zebra", BST.last());
    }

    @Test
    void remove() {

        BST.remove("bird");
        ArrayList<String> expected1 = new ArrayList<>(Arrays.asList("1","Zebra","dog","z","zebra"));
        assertEquals(expected1, BST.toArrayList());

        BST.remove("1");
        ArrayList<String> expected2 = new ArrayList<>(Arrays.asList("Zebra","dog","z","zebra"));
        assertEquals(expected2, BST.toArrayList());

        BST.remove("dog"); // remove root node
        ArrayList<String> expected3 = new ArrayList<>(Arrays.asList("Zebra","z","zebra"));
        assertEquals(expected3, BST.toArrayList());

    }

    @Test
    void removeAll() {
        assertFalse(BST.removeAll(stringsNotContained)); // "Dog","octopus","whale"
        ArrayList<String> expected1 = new ArrayList<>(Arrays.asList("1","Zebra","bird","dog","z","zebra"));
        assertEquals(expected1, BST.toArrayList());

        assertTrue(BST.removeAll(stringsPartContained)); // "Zebra","panda","tiger"
        ArrayList<String> expected2 = new ArrayList<>(Arrays.asList("1","bird","dog","z","zebra"));
        assertEquals(expected2, BST.toArrayList());

        assertTrue(BST.removeAll(stringsContained)); // "bird","zebra","z"
        ArrayList<String> expected3 = new ArrayList<>(Arrays.asList("1","dog"));
        assertEquals(expected3, BST.toArrayList());
    }

    @Test
    void size() {
        assertEquals(6, BST.size());
        BST.remove("dog");
        assertEquals(5, BST.size());
        BST.clear();
        assertEquals(0, BST.size());
    }

    @Test
    void toArrayList() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("1","Zebra","bird","dog","z","zebra"));
        assertEquals(expected, BST.toArrayList());
    }
}