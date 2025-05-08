package org.generation.italy.sudProject.entities.playerClasses;

public enum Classes {
    PALADIN("PALADIN"),
    PRIEST("PRIEST"),
    ROGUE("ROGUE"),
    WIZARD("WIZARD");

    private final String string;

    Classes(String className){
        string = className;
    }

    public String getString() {
        return string;
    }
}

