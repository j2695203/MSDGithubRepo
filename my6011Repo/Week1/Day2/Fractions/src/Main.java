import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args)
    {
        ArrayList<Fraction> arrayOfFrac = new ArrayList<>();

        arrayOfFrac.add(0, new Fraction(-2,3));
        arrayOfFrac.add(1, new Fraction(2,3));
        arrayOfFrac.add(2, new Fraction(1,3));

        System.out.println(arrayOfFrac);
        Collections.sort(arrayOfFrac);
        System.out.println(arrayOfFrac);
    }
}