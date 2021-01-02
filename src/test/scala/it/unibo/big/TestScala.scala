package it.unibo.big

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse}
import org.junit.jupiter.api.Test

class TestScala {
  @Test def test(): Unit = {
    assertFalse(0.1 + 0.2 == 0.3)
    assertEquals(0.1 + 0.2, 0.3, 0.001)
  }
}
