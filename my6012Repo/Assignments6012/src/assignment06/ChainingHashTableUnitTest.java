package assignment06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ChainingHashTableTest {
    int tableCapacity = 3581;
    int strAmount = 1000;
    int strLength = 1000;
    ChainingHashTable table, tableBad, tableMed, tableGood;
    ArrayList<String> contained, partialContained, notContained;

    @BeforeEach
    void setUp() {

        HashFunctor badHash = new BadHashFunctor();
        HashFunctor medHash = new MediocreHashFunctor();
        HashFunctor goodHash = new GoodHashFunctor();

        table = new ChainingHashTable(tableCapacity,badHash);
        tableBad = new ChainingHashTable(tableCapacity,badHash);
        tableMed = new ChainingHashTable(tableCapacity,medHash);
        tableGood = new ChainingHashTable(tableCapacity,goodHash);

        table.add("dog");
        table.add("bird");
        table.add("zebra");
        table.add("Zebra"); // capital letter
        table.add("z");
        table.add("1"); // number

        contained = new ArrayList<>(Arrays.asList("bird","zebra","z")); // all strings are contained in table
        partialContained = new ArrayList<>(Arrays.asList("Zebra","panda","tiger")); // part of strings are contained in table
        notContained = new ArrayList<>(Arrays.asList("Dog","octopus","whale")); // all strings are not contained in table
    }

    @Test
    void add() {
        // add an existed string
        assertTrue(table.contains("dog"));
        assertFalse(table.add("dog"));

        // add a new string
        assertFalse(table.contains("deer"));
        table.add("deer");
        assertTrue(table.contains("deer"));
    }

    @Test
    void addAll() {
        // add existed strings
        assertFalse(table.addAll(contained));
        assertEquals(6, table.size());
        // add partial existed strings
        assertTrue(table.addAll(partialContained));
        assertEquals(8, table.size());
        // add non-existed strings
        assertTrue(table.addAll(notContained));
        assertEquals(11, table.size());
    }

    @Test
    void clear() {
        assertFalse(table.isEmpty());
        table.clear();
        assertTrue(table.isEmpty());
    }

    @Test
    void contains() {
        assertTrue(table.contains("zebra"));
        assertFalse(table.contains("turkey"));
    }

    @Test
    void containsAll() {
        assertTrue(table.containsAll(contained));
        assertFalse(table.containsAll(partialContained));
        assertFalse(table.containsAll(notContained));
    }

    @Test
    void isEmpty() {
        assertFalse(table.isEmpty());
        table.clear();
        assertTrue(table.isEmpty());
    }

    @Test
    void remove() {
        assertTrue(table.remove("bird"));
        assertFalse(table.contains("bird"));
        assertEquals(5, table.size());
    }

    @Test
    void removeAll() {
        // remove non-existed strings
        assertFalse(table.removeAll(notContained));
        assertEquals(6, table.size());
        // remove partial existed strings
        assertTrue(table.removeAll(partialContained));
        assertEquals(5, table.size());
        // remove existed strings
        assertTrue(table.removeAll(contained));
        assertEquals(2, table.size());
    }

    @Test
    void size() {
        assertEquals(6, table.size());
        table.add("hello");
        assertEquals(7, table.size());
    }

    /**
     * Create strings randomly
     * @param length assigned length of string
     * @return random string
     */
    static String getRandomString(int length)
    {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    @Test
    void testHashFuntor(){

        // create random string
        String str;
        ArrayList<String> randomStrings = new ArrayList<>();
//        int strAmount = tableCapacity;
//        int strLength = 5;

        for( int i = 0; i < strAmount; i++ ){
            str = getRandomString(strLength);
            randomStrings.add(str);
        }

        // create tables with different hash method
        tableBad.addAll(randomStrings);
        tableMed.addAll(randomStrings);
        tableGood.addAll(randomStrings);

        // show result
        System.out.println("capacity: " + tableCapacity);
        System.out.println("number of strings: " + strAmount);
        System.out.println("Bad Hash:      " + tableBad.collisionTime() + " times");
        System.out.println("Mediocre Hash: " + tableMed.collisionTime() + " times");
        System.out.println("Good Hash:     " + tableGood.collisionTime() + " times");

    }
}