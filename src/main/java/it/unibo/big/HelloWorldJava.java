package it.unibo.big;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An example of Java class.
 */
public final class HelloWorldJava {
    private static final Logger L = LoggerFactory.getLogger(HelloWorldJava.class);

    private HelloWorldJava() {
    }

    /**
     * Hello, World.
     * @param args arguments
     */
    public static void main(final String[] args) {
        L.debug("Hello, world!");
    }
}
