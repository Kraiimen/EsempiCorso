package org.generation.italy.parkinglot.vehicles.motorcycles;

import org.generation.italy.parkinglot.vehicles.Motorcycle;

public class Guzzi extends Motorcycle {
    public Guzzi(String plate){
        this.plate = plate;
    }

    @Override
    public void startEngine() {
        System.out.println("La Guzzi con targa \""+plate+"\" è accesa.");
    }

    @Override
    public void stopEngine() {
        System.out.println("La Guzzi con targa \""+plate+"\" è spenta.");
    }


}
