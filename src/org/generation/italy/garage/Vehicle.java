package org.generation.italy.garage;

public interface Vehicle {

    public default void startEngine() {
        System.out.println("Engine is starting");
    }

    public default void stopEngine() {
        System.out.println("Engine is stopping");
    }

    public abstract void park();
}
