import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FractionTest {

    @Test
    void plus() {
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(1,3);
        Fraction f3 = f1.plus(f2);
        Assertions.assertEquals("5/6",f3.toString());
    }

    @Test
    void minus() {
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(1,3);
        Fraction f3 = f1.minus(f2);
        Assertions.assertEquals("1/6",f3.toString());
    }

    @Test
    void times() {
        Fraction f1 = new Fraction(-3,-5);
        Fraction f2 = new Fraction(1,-3);
        Fraction f3 = f1.times(f2);
        Assertions.assertEquals("-1/5",f3.toString());
    }

    @Test
    void divideBy() {
        Fraction f1 = new Fraction(-3,-5);
        Fraction f2 = new Fraction(1,-3);
        Fraction f3 = f1.times(f2);
        Assertions.assertEquals("-1/5",f3.toString());
    }

    @Test
    void reciprocal() {
        Fraction f1 = new Fraction(6,-12);
        Fraction f2 = f1.reciprocal();
        Assertions.assertEquals("-2",f2.toString());

        Fraction f3 = new Fraction(-1,-6);
        Fraction f4 = f3.reciprocal();
        Assertions.assertEquals("6",f4.toString());
    }

    @Test
    void testToString() {
        Fraction f1 = new Fraction(0,-3);
        Assertions.assertEquals("0",f1.toString());

        Fraction f2 = new Fraction(3,-3);
        Assertions.assertEquals("-1",f2.toString());
    }

    @Test
    void toDouble() {
        Fraction f1 = new Fraction(3,4);
        Assertions.assertEquals(0.75,f1.toDouble());
    }

    @Test
    public void runAllTests(){

    }
}