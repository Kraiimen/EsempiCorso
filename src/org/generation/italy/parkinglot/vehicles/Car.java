package org.generation.italy.parkinglot.vehicles;

public abstract class Car implements Vehicle {
    protected String plate;
    public void handbrake() {
        System.out.println("Freno a mano tirato.");
    }

}
