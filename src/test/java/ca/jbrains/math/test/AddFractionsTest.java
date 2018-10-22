package ca.jbrains.math.test;

import org.junit.Assert;
import org.junit.Test;

public class AddFractionsTest {
    @Test
    public void zeroPlusZero() throws Exception {
        Fraction sum = new Fraction(0).plus(new Fraction(0));
        Assert.assertEquals(new Fraction(0), sum);
    }

    @Test
    public void notZeroPlusZero() throws Exception {
        Fraction sum = new Fraction(3).plus(new Fraction(0));
        Assert.assertEquals(new Fraction(3), sum);
    }

    @Test
    public void zeroPlusNotZero() throws Exception {
        Fraction sum = new Fraction(0).plus(new Fraction(6));
        Assert.assertEquals(new Fraction(6), sum);
    }

    @Test
    public void notZeroPlusNotZero() throws Exception {
        Fraction sum = new Fraction(3).plus(new Fraction(6));
        Assert.assertEquals(new Fraction(9), sum);
    }

    @Test
    public void nonIntegersWithTheSameDenominator() throws Exception {
        Fraction sum = new Fraction(1, 5).plus(new Fraction(2, 5));
        Assert.assertEquals(new Fraction(3, 5), sum);
    }

    @Test
    public void differentDenominatorsWithoutReducing() throws Exception {
        Fraction sum = new Fraction(7, 4).plus(new Fraction(3, 5));
        Assert.assertEquals(new Fraction(47, 20), sum);
    }

    public static class Fraction {
        private int numerator;
        private int denominator;

        public Fraction(int integerValue) {
            this(integerValue, 1);
        }

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Fraction plus(Fraction other) {
            if (this.denominator == other.denominator)
                return new Fraction(this.numerator + other.numerator, other.denominator);
            else
                return new Fraction(
                        this.numerator * other.denominator + this.denominator * other.numerator,
                        this.denominator * other.denominator);
        }

        public int intValue() {
            return numerator;
        }

        public int getNumerator() {
            return numerator;
        }

        public int getDenominator() {
            return denominator;
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof Fraction) {
                Fraction that = (Fraction) other;

                return this.numerator * that.denominator == that.numerator * this.denominator;
            }
            else {
                return false;
            }
        }
    }
}
