package lab01;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeClass;

import static org.junit.jupiter.api.Assertions.*;

class TestFindSmallestDiff {

    private int[] arr1, arr2, arr3, arr4, arr5;

    @BeforeEach
    protected void setUp() throws Exception {
        // happens before every test method.
        arr1 = new int[0];
        arr2 = new int[] { 3, 3, 3 };
        arr3 = new int[] { 52, 4, -8, 0, -17 };
        arr4 = new int[] { -2, -1, 0, 1, 2 };
        arr5 = new int[] { 1, 49, -23, -25, 0 };
    }

    @AfterEach
    public void tearDown() throws Exception {
        // happens right after every Test.
    }

    private void someHelperMethodUsedInManyTests() {
    }

    @Test
    public void emptyArray() {
        assertEquals(-1, DiffUtil.findSmallestDiff(arr1));
    }
    @Test
    public void allArrayElementsEqual() {
        assertEquals(0, DiffUtil.findSmallestDiff(arr2));
    }
    @Test
    public void smallRandomArrayElements() {
        assertEquals(4, DiffUtil.findSmallestDiff(arr3));
    }
    @Test
    public void test4(){
        assertEquals(1, DiffUtil.findSmallestDiff(arr4));
    }
    @Test
    public void test5(){
        assertEquals(1, DiffUtil.findSmallestDiff(arr4));
    }
}