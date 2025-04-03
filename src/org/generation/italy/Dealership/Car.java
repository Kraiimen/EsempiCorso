package org.generation.italy.Dealership;

public abstract class Car implements Vehicle{
    private boolean isMoveable;
    @Override
    public void startEngine() {
        System.out.println("La macchina è accesa ");
    }

    @Override
    public void turnOffEngine() {
        System.out.println("La macchina è spenta ");
    }
    public void handBrake(){
        isMoveable = false;
    }
    public void removeHandBrake(){
        isMoveable = true;
    }
}
