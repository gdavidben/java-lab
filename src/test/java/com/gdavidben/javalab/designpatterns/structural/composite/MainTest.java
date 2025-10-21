package com.gdavidben.javalab.designpatterns.structural.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class MainTest {

    @Test
    void test() {
        final var read = new Permission("READ");
        final var write = new Permission("WRITE");
        final var execute = new Permission("EXECUTE");

        final var developer = new Role("Developer");

        developer.add(read);
        developer.add(write);

        final var admin = new Role("Admin");

        admin.add(developer);
        admin.add(execute);

        assertTrue(developer.hasPermission("READ"));
        assertFalse(developer.hasPermission("EXECUTE"));
        assertTrue(admin.hasPermission("READ"));
        assertTrue(admin.hasPermission("EXECUTE"));
    }
}
