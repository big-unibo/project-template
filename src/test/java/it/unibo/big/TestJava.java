package it.unibo.big;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
