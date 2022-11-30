package Assignment01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixJUnitTester {
    int[][] twoByThreeData1;
    int[][] twoByThreeData2;
    int[][] twoByThreeData3;
    int[][] threeByFourData;
    private Matrix twoByThree1;
    private Matrix twoByThree2;
    private Matrix twoByThree3;
    private Matrix threeByFour;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        twoByThreeData1 = new int[][] { {1, 2, 3}, {4, 5, 6} };
        twoByThreeData2 = new int[][] { {1, -3, 5}, {2, -4, 6} };
        twoByThreeData3 = new int[][] { {0, 0, 0}, {0, 0, 0} };
        threeByFourData = new int[][] { {7, 8, 1, 1}, {9, 10, 1, 1}, {11, 12, 1, 1}};
        twoByThree1 = new Matrix(twoByThreeData1);
        twoByThree2 = new Matrix(twoByThreeData2);
        twoByThree3 = new Matrix(twoByThreeData3);
        threeByFour = new Matrix(threeByFourData);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    // for equals
    @Test
    public void equalsWithSameValues() {
        Matrix matrixEqual = new Matrix(twoByThreeData1);
        assertEquals(twoByThree1, matrixEqual);
    }

    @Test
    public void equalsWithBalancedDimensionsDifferentValues() {
        Matrix matrixEqual = new Matrix(twoByThreeData2);
        assertFalse(twoByThree1.equals(matrixEqual));
    }

    @Test
    public void equalsWithUnbalancedDimensions() {
        assertFalse(twoByThree1.equals(threeByFour));
    }

    // for toString
    @Test
    public void twoByThreeToString() {
        String resultString = "1 2 3 \n4 5 6 \n";
        assertEquals(resultString, twoByThree1.toString());
    }

    // for times
    @Test
    public void timesWithBalancedDimensions() {
        Matrix matrixProduct = new Matrix( new int[][] { {58, 64, 6, 6}, {139, 154, 15, 15} } );
        assertTrue(twoByThree1.times(threeByFour).equals(matrixProduct));
    }

    @Test
    public void timesWithUnbalancedDimensions() {
        Matrix matrixProduct = threeByFour.times(twoByThree1);
        assertNull(matrixProduct);
    }
    @Test
    public void timesWithBalancedDimensionsValueZero() {
        Matrix matrixProduct = twoByThree3.times(threeByFour);
        Matrix matrixExpected = new Matrix( new int[][] { {0, 0, 0, 0}, {0, 0, 0, 0} } );
        assertEquals(matrixExpected, matrixProduct);
    }

    // for plus
    @Test
    public void plusWithBalancedDimensions(){
        Matrix matrixPlus = new Matrix( new int[][] { {2, -1, 8}, {6, 1, 12} } );
        assertEquals(matrixPlus, twoByThree1.plus(twoByThree2));
    }

    @Test
    public void plusWithUnbalancedDimensions(){
        assertNull(twoByThree1.plus(threeByFour));
    }
}