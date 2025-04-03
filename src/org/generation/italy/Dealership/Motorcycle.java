package org.generation.italy.Dealership;

public abstract class Motorcycle implements Vehicle {
    private boolean isMoveable;
    @Override
    public void startEngine() {
        System.out.println("La moto è accesa ");
    }

    @Override
    public void turnOffEngine() {
        System.out.println("La moto è spenta ");
    }
    public void putOnStand(){
        isMoveable = false;
    }
    public void putOffStand(){
        isMoveable = true;
    }
}
