package org.generation.italy.Dealership;

import java.util.ArrayList;

public class Garage <T extends Car, U extends Motorcycle> {
    private ArrayList<T> arrayCar = new ArrayList<>();
    private ArrayList<U> arrayMotorcycle = new ArrayList<>();

    public int parkCar(T car){
        this.arrayCar.add(car);
        return arrayCar.size();

    }
    public int parkMotorcycle(U motorcycle){
        this.arrayMotorcycle.add(motorcycle);
        return arrayMotorcycle.size();
    }
}