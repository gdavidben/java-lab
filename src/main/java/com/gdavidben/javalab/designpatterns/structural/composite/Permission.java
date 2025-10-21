package com.gdavidben.javalab.designpatterns.structural.composite;

public class Permission implements AccessControl {

    private final String name;

    public Permission(final String name) {
        this.name = name;
    }

    @Override
    public boolean hasPermission(String permission) {
        return this.name.equalsIgnoreCase(permission);
    }
}
