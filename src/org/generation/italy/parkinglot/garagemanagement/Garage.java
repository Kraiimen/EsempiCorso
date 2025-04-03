package org.generation.italy.parkinglot.garagemanagement;

import org.generation.italy.parkinglot.vehicles.Car;
import org.generation.italy.parkinglot.vehicles.Motorcycle;

import java.util.ArrayList;

public class Garage<T extends Car, U extends Motorcycle> {
    private ArrayList<T> box = new ArrayList<>();
    private ArrayList<U> box2 = new ArrayList<>();

    public int parkCar(T obj) {
        System.out.println("Parcheggiando la macchina...");
        box.add(obj);
        obj.handbrake();
        return box.size();
    }

    public int parkMotorcycle(U obj) {
        System.out.println("Parcheggiando la moto...");
        box2.add(obj);
        obj.putOnStand();
        return box2.size();
    }

}
