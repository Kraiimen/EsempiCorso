package org.generation.italy.parkinglot.vehicles.motorcycles;

import org.generation.italy.parkinglot.vehicles.Motorcycle;

public class Harley extends Motorcycle {
    public Harley(String plate){
        this.plate = plate;
    }

    @Override
    public void startEngine() {
        System.out.println("La Harley con targa \""+plate+"\" è accesa.");
    }

    @Override
    public void stopEngine() {
        System.out.println("La Harley con targa \""+plate+"\" è spenta.");
    }
}
