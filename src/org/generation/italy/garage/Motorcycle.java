package org.generation.italy.garage;

public class Motorcycle implements Vehicle {
    String model;
    int releaseYear;

    public Motorcycle(String model, int releaseYear) {
        this.model = model;
        this.releaseYear = releaseYear;
    }

    public void putOnStand() {
        System.out.println("Stand set");
    }

    @Override
    public void park() {
        putOnStand();
    }
}
