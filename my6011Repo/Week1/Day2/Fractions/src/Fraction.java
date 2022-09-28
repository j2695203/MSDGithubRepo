
public class Fraction{
    private long numerator, denominator;

    public Fraction(){                 // constructor
        numerator = 0;
        denominator = 1;
    }

    public Fraction(long n, long d){   // constructor
        if ( d < 0){                   // let denominator be positive
            numerator = n * -1;
            denominator = d * -1;
        }else{
            numerator = n;
            denominator = d;
        }
        reduce();
    }

    public Fraction plus(Fraction rhs){
        Fraction f = new Fraction();
        f.numerator = numerator * rhs.denominator + rhs.numerator * denominator;
        f.denominator = denominator * rhs.denominator;
        f.reduce();
        return f;
    }

    public Fraction minus(Fraction rhs){
        Fraction f = new Fraction();
        f.numerator = numerator * rhs.denominator - rhs.numerator * denominator;
        f.denominator = denominator * rhs.denominator;
        f.reduce();
        return f;
    }

    public Fraction times(Fraction rhs){
        Fraction f = new Fraction();
        f.numerator = numerator * rhs.numerator;
        f.denominator = denominator * rhs.denominator;
        f.reduce();
        return f;
    }

    public Fraction divideBy(Fraction rhs){
        Fraction f = new Fraction();
        f.numerator = numerator * rhs.denominator;
        f.denominator = denominator * rhs.numerator;
        f.reduce();
        return f;
    }

    public Fraction reciprocal(){
        Fraction f = new Fraction();
        if (numerator == 0){                // can't be reciprocal cause denominator can't be 0
            System.exit(1);
        }
        if (numerator < 0){                 // switch denominator to positive num
            f.numerator = denominator * -1;
            f.denominator = numerator * -1;
        }else{
            f.numerator = denominator;
            f.denominator = numerator;
        }
        return f;
    }

    public String toString(){
        String s;
        if (numerator == 0){                  // display 0 when numerator is 0, ex. 0/3 -> 0
            s = "0";
        }else if (denominator == 1){          // display numerator value when denominator is 1, ex. 3/1 -> 3
            s = Long.toString(numerator);
        }else{
            s = (numerator) + "/" + (denominator);
        }
        return s;
    }

    public double toDouble(){
        return (numerator * 1.0 / denominator);
    }

    private long GCD(){
        long gcd = numerator;
        long remainder = denominator;
        while( remainder != 0 ) {
            long temp = remainder;
            remainder = gcd % remainder;
            gcd = temp;
        }
        return Math.abs(gcd);
    }

    private void reduce(){
        long gcd = GCD();
        numerator /= gcd;
        denominator /= gcd;
    }
}
