package org.generation.italy.ravenClaw.garageExercise;

import java.util.ArrayList;

public class Garage<T,U> {
    private ArrayList<T> carList;
    private ArrayList<U> motorCycleList;

    public int parkCar(T car){
        carList.add(car);

        return carList.size();
    }
    public int parkMoto(U motorCycle){
        motorCycleList.add(motorCycle);

        return motorCycleList.size();
    }


}
