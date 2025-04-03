package org.generation.italy.Dealership;

public abstract class Car implements Veihcle{
    private boolean isMoveable;
    @Override
    public void StartEngine() {
        System.out.println("La macchina è accesa");
    }

    @Override
    public void turnOffEngine() {
        System.out.println("La macchina è spenta");
    }
    public void handBrake() {
        isMoveable = false;
    }
    public void removeHandBrake(){
        isMoveable = true;
    }
}
