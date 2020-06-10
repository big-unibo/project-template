package it.unibo.big;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestJava {
    private final double aNumber = 0.1;
    private final double bNumber = 0.2;
    private final double cNumber = 0.3;
    private final double thr = 0.001;
    @Test
    public void test() {
        // assert statements
        assertFalse(aNumber + bNumber == cNumber);
        assertEquals(aNumber + bNumber, cNumber, thr);
    }
}
