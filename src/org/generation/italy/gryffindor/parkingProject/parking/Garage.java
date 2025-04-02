package org.generation.italy.gryffindor.parkingProject.parking;

import java.util.ArrayList;

public class Garage<T extends Car, U extends Motorcycle>{
    private ArrayList<T> cars;
    private ArrayList<U> motorcycles;

    public int parkCar(T car) {
        cars.add(car);

        return cars.size();
    }
    public int parkMoto(U moto) {
       motorcycles.add(moto);
       return motorcycles.size();
    }

//    public void park(T t) { // Questi due metodi funzionano, pur prendendo in input due Objects ed essendo quindi ugualu
//                            // Questo grazie a una "magia" del compiler
//    }
//    public void park(U u) {
//
//    }
}
