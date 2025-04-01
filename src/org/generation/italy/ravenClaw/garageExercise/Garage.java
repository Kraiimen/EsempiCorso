package org.generation.italy.ravenClaw.garageExercise;

import java.util.ArrayList;

public class Garage<T extends Car,U extends Motorcycle> {

    private ArrayList<T> carList;
    private ArrayList<U> motorCycleList;

    public Garage(){
        carList = new ArrayList<>();
        motorCycleList = new ArrayList<>();
    }

    public int parkCar(T car){
        carList.add(car);
        System.out.println("I'm parking the car");
        car.pullTheHandBrake();
        return carList.size();
    }
    public int parkMoto(U motorCycle){
        motorCycleList.add(motorCycle);
        System.out.println("I'm parking the motorcycle");
        motorCycle.kickTheKickstand();
        return motorCycleList.size();
    }



}
