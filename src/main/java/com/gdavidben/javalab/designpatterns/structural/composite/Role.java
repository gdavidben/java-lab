package com.gdavidben.javalab.designpatterns.structural.composite;

import java.util.HashSet;
import java.util.Set;

public class Role implements AccessControl {

    private final String name;

    private final Set<AccessControl> accessControls = new HashSet<>();


    public Role(final String name) {
        this.name = name;
    }

    public void add(final AccessControl accessControl) {
        accessControls.add(accessControl);
    }

    @Override
    public boolean hasPermission(String permission) {
        return accessControls.stream().anyMatch(ac -> ac.hasPermission(permission));
    }
}
