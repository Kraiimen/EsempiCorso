package org.generation.italy.parkinglot.vehicles.cars;

import org.generation.italy.parkinglot.vehicles.Car;

public class Ferrari extends Car {
    public Ferrari(String plate){
        this.plate = plate; // c'ho il bf che gioca accanto
    }

    @Override
    public void startEngine() {
        System.out.println("La Ferrari con targa \""+plate+"\" è accesa.");
    }

    @Override
    public void stopEngine() {
        System.out.println("La Ferrari con targa \""+plate+"\" è spenta.");
    }
}
