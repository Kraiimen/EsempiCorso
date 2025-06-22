package org.generation.italy.sudProject;

public enum TimePhase {
    DAY("DAY"),
    NIGHT("NIGHT");

    private final String value;

    TimePhase(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
