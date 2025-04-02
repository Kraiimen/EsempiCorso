package org.generation.italy.gryffindor.parkingProject.parking;

public abstract class Car implements Vehicle{
    private boolean isOn;
    private boolean ishandbrakeOn;

    public Car() {
        isOn = false; // Di default boolean sarebbe false comunque
        ishandbrakeOn = false;
    }

    @Override
    public void startEngine() {
        isOn = true;
    }

    @Override
    public void turnOffEngine() {
        isOn = false;
    }

    public void handBrake() {

    }

    public boolean getIsOn() {
        return isOn;
    }
}
