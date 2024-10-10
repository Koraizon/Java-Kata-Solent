package org.solent.enums;

public enum Orientation {
    N("NORTH"),
    S("SOUTH"),
    E("EAST"),
    W("WEST");

    private final String description;

    Orientation(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
