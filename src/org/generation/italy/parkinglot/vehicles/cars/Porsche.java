package org.generation.italy.parkinglot.vehicles.cars;

import org.generation.italy.parkinglot.vehicles.Car;

public class Porsche extends Car {
    public Porsche(String plate){
        this.plate = plate;
    }

    @Override
    public void startEngine() {
        System.out.println("La Porsche con targa \""+plate+"\" è accesa.");
    }

    @Override
    public void stopEngine() {
        System.out.println("La Porsche con targa \""+plate+"\" è spenta.");
    }
}
