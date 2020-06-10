package it.unibo.big

import org.junit.Assert.{assertEquals, assertFalse}
import org.junit.Test

class TestScala {
  @Test def test(): Unit = {
    assertFalse(0.1 + 0.2 == 0.3)
    assertEquals(0.1 + 0.2, 0.3, 0.001)
  }
}
