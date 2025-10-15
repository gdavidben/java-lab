package com.gdavidben.javalab;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testHello() {
        assert Main.hello().equals("Hello, Java!");
    }
}
