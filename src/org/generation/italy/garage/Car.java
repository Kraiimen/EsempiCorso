package org.generation.italy.garage;

public abstract class Car implements Vehicle {
    String plate;
    int releaseYear;

    public Car(String plate, int releaseYear) {
        this.plate = plate;
        this.releaseYear = releaseYear;
    }

    public void handbrake() {
        System.out.println("Handbrake set");
    }

    @Override
    public void park() {
        handbrake();
    }

}
