package lab4;

/**
 * RationalNumber is the class inheriting the SpecialNumber class, which
 * allows an application to represent rational number supporting add(),
 * divideByInt(), and computeAverage() functions in work. In addition, the
 * class itself also supports sorting by natural ordering.
 *
 */
public class RationalNumber extends SpecialNumber implements Comparable<RationalNumber>{
    int numerator;
    int denominator;

    public RationalNumber (int numerator, int denominator) throws Lab4Exception {
        if (denominator == 0)
            throw new Lab4Exception("Denominator cannot be zero");

        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public SpecialNumber add(SpecialNumber obj) throws Lab4Exception {
        if (!(obj instanceof RationalNumber))
            throw new Lab4Exception("Cannot add an incompatible type");

        RationalNumber num = (RationalNumber) obj;
        RationalNumber res = new RationalNumber(0, this.denominator);
        // Get common denominator
        if(this.denominator != num.denominator) {
            res.denominator = this.denominator * num.denominator;
            res.numerator += this.numerator * num.denominator;
            res.numerator += num.numerator * this.denominator;
        }
        // has common denominator already
        else {
            res.numerator = this.numerator + num.numerator;
        }
        return res;
    }

    @Override
    public SpecialNumber divideByInt(int num) throws Lab4Exception {
        if (num == 0)
            throw new Lab4Exception("Cannot divide by zero");

        return new RationalNumber(this.numerator, this.denominator * num);
    }

    @Override
    public int compareTo(RationalNumber o) {
        int x = this.numerator * o.denominator;
        int y = o.numerator * this.denominator;
        if (x > y)
            return 1;
        else if (x < y)
            return -1;
        else
            return 0;
    }

    @Override
    public int hashCode() {
        int x = numerator;
        int y = denominator;
        while (true) {
            if (x > y)
                x -= y;
            else if (x < y)
                y -= x;
            else
                return numerator * denominator / x / x;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RationalNumber) {
            RationalNumber num = (RationalNumber) obj;
            return this.hashCode() == num.hashCode();
        }
        return false;
    }
}
