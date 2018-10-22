package ca.jbrains.math.test;

import org.junit.Assert;
import org.junit.Test;

public class AddFractionsTest {
    @Test
    public void zeroPlusZero() throws Exception {
        Assert.assertEquals(0, new Fraction(0).plus(new Fraction(0)).intValue());
    }

    public static class Fraction {
        public Fraction(int integerValue) {

        }

        public Fraction plus(Fraction other) {
            return new Fraction(238);
        }

        public int intValue() {
            return 0;
        }
    }
}
