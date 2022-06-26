package lab4;

/**
 * RationalNumber is the class inheriting the SpecialNumber class, which
 * allows an application to represent rational number supporting add(),
 * divideByInt(), and computeAverage() functions in work. In addition,
 * the class itself also supports sorting by natural ordering.
 *
 * @author xuzheng
 * @version 1.0
 */
public class RationalNumber extends SpecialNumber implements Comparable<RationalNumber>{
    /**
     * Represent numerator part.
     */
    int numerator;

    /**
     * Represent denominator part.
     */
    int denominator;

    /**
     * Create a rational number with given numerator and denominator.
     * @param numerator         Numerator part of the rational number.
     * @param denominator       Denominator part of the rational number.
     * @throws Lab4Exception    Show error messages "Denominator cannot be
     *                          zero" denominator is zero.
     */
    public RationalNumber (int numerator, int denominator) throws Lab4Exception {
        if (denominator == 0)
            throw new Lab4Exception("Denominator cannot be zero");

        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Add calling rational number object with the special number OBJ.
     * @param obj               A special number object.
     * @return                  A resulting rational number object.
     * @throws Lab4Exception    The error message "Cannot add an incompatible
     *                          type" is shown if OBJ is not a rational number
     *                          object.
     */
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

    /**
     * Divide  the  calling rational number object  by  the NUM.
     * @param num Divisor.
     * @return                  The resulting rational number object.
     * @throws Lab4Exception    Show error messages "Cannot divide by zero"
     *                          if NUM is zero.
     */
    @Override
    public SpecialNumber divideByInt(int num) throws Lab4Exception {
        if (num == 0)
            throw new Lab4Exception("Cannot divide by zero");

        return new RationalNumber(this.numerator, this.denominator * num);
    }

    /**
     * Compare rational number O with the calling object.
     * @param o A rational number object.
     * @return  A negative integer, zero, or a positive integer as this
     *          object is less, equal to, or greater than the specified
     *          object.
     */
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

    /**
     * Get hashcode of the calling object.
     * @return Hashcode.
     */
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

    /**
     * If the calling object is equal to OBJ.
     * @param obj   Object.
     * @return      True if they are equal. False otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RationalNumber) {
            RationalNumber num = (RationalNumber) obj;
            return this.hashCode() == num.hashCode();
        }
        return false;
    }
}
