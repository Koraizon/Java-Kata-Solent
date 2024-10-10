package org.solent.enums;

public enum Instruction {
    A("AVANCER"),
    D("DROITE"),
    G("GAUCHE");

    private final String description;

    Instruction(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
