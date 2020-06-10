package it.unibo.big

import org.slf4j.{Logger, LoggerFactory}

object HelloWorldScala {
  val L: Logger = LoggerFactory.getLogger("Test")
  def main(args: Array[String]): Unit = {
    L.debug("Hello, World!")
  }
}
