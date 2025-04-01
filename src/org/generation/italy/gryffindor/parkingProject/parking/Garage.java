package org.generation.italy.gryffindor.parkingProject.parking;

import java.util.ArrayList;

public class Garage<T extends Car, U extends MotorCycle> {
    private ArrayList<T> cars;
    private ArrayList<U> motorCycles;

    public int parkCar(T car){
        cars.add(car);
        car.turnOffEngine();
        return cars.size();
    }
    public int parkMotorCycle(U bike){
        motorCycles.add(bike);
        bike.turnOffEngine();
        return motorCycles.size();
    }
}
