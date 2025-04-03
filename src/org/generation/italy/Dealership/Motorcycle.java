package org.generation.italy.Dealership;

public abstract class Motorcycle implements Veihcle{
    private boolean isMoveable;
    @Override
    public void StartEngine() {
        System.out.println("La macchina è accesa");
    }

    @Override
    public void turnOffEngine() {
        System.out.println("La macchina è spenta");
    }
    public void putOnStand(){
        isMoveable = false;
    }
    public void putOffStand(){
        isMoveable = true;
    }
}
