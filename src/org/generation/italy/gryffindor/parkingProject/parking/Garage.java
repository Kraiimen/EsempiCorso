package org.generation.italy.gryffindor.parkingProject.parking;

import java.util.ArrayList;

public class Garage<T extends Car, U extends MotorCycle> {
    private ArrayList<T> cars;
    private ArrayList<U> motorCycles;

    public Garage(){
        cars = new ArrayList<T>();
        motorCycles = new ArrayList<U>();
    }

    public int parkCar(T car){
        System.out.println("parcheggio macchina");
        cars.add(car);
        car.turnOffEngine();
        System.out.println();

        return cars.size();
    }
    public int parkMotorCycle(U bike){
        System.out.println("parcheggio moto");
        motorCycles.add(bike);
        bike.turnOffEngine();
        System.out.println();

        return motorCycles.size();
    }
}
