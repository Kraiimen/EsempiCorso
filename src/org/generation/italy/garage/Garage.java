package org.generation.italy.garage;

import java.util.ArrayList;

public class Garage<T extends Car, U extends Motorcycle> {
    ArrayList<T> ts;
    ArrayList<U> us;

    public Garage() {
        ts = new ArrayList<T>();
        us = new ArrayList<U>();
    }

    public void parkCar(T car) {
        try {
            car.park();
            ts.add(car);
            System.out.println("There are " + ts.size() + " cars parked");
        } catch (NullPointerException e) {
            System.out.println("Error: the car you're trying to park does not exist");
        }

    }

    public void parkMoto(U moto) {
        try {
            moto.park();
            us.add(moto);
            System.out.println("There are " + us.size() + " motos parked");

        } catch (NullPointerException e) {
            System.out.println("Error: the moto you're trying to park does not exist");
        }


    }


}
