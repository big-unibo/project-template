package it.unibo.big;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestJava {
    @Test
    public void Test() {
        // assert statements
        assertFalse(0.1 + 0.2 == 0.3);
        assertEquals(0.1 + 0.2, 0.3, 0.001);
    }
}
