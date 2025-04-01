package org.generation.italy.parkinglot.garagemanagement;

import java.util.ArrayList;

public class Garage<T,U> {
    private ArrayList<T> box = new ArrayList<>();
    private ArrayList<U> box2 = new ArrayList<>();

    public int parkCar(T obj) {
        box.add(obj);
        return box.size();
    }

    public int parkMotorcycle(U obj) {
        box2.add(obj);
        return box2.size();
    }

}
