package com.gdavidben.javalab.stablevalue;

// More details: https://openjdk.org/jeps/502
public class Main {
    // OLD: Since LOGGER is a final field, it must be initialized eagerly, whenever an instance of Main is created.
    // static final Logger LOGGER = new Logger();

    // NEW: A stable value must be initialized some time before its content is first retrieved, and it is immutable thereafter.
    static final StableValue<Logger> LOGGER = StableValue.of();

    static Logger logger() {
        return LOGGER.orElseSet(Logger::new);
    }

    void main() {
        logger().info("Hello, Java 25!");
    }
}

class Logger {
    public void info(final String msg) {
        IO.println("INFO: " + msg);
    }
}
