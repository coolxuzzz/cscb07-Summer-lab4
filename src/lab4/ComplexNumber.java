package lab4;

public class ComplexNumber extends SpecialNumber implements Comparable<ComplexNumber> {
    double real;
    double imaginary;

    public ComplexNumber (double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }


    @Override
    public SpecialNumber add(SpecialNumber obj) throws Lab4Exception {
        if (!(obj instanceof ComplexNumber))
            throw new Lab4Exception("Cannot add an incompatible type");

        ComplexNumber num = (ComplexNumber) obj;
        return new ComplexNumber(this.real + num.real, this.imaginary + num.imaginary);
    }

    @Override
    public SpecialNumber divideByInt(int num) throws Lab4Exception {
        if (num == 0)
            throw new Lab4Exception("Cannot divide by zero");

        return new ComplexNumber(this.real / num, this.imaginary / num);
    }

    @Override
    public int hashCode() {
        return (int) (real * imaginary);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ComplexNumber) {
            ComplexNumber res = (ComplexNumber) obj;
            return this.real == res.real && this.imaginary == res.imaginary;
        }
        return false;
    }

    @Override
    public int compareTo(ComplexNumber o) {
        double x = Math.pow(this.real, 2) + Math.pow(this.imaginary, 2);
        double y = Math.pow(o.real, 2) + Math.pow(o.imaginary, 2);

        if (x > y)
            return 1;
        else if (x < y)
            return -1;
        else
            return 0;
    }
}
