package org.generation.italy.parkinglot.vehicles;

public abstract class Motorcycle implements Vehicle{
    protected String plate;
    public void putOnStand() {
        System.out.println("La moto è sul cavalletto.");
    }
}
