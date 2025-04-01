package org.generation.italy.Dealership;

import java.util.ArrayList;

public class Garage<T extends Car, U extends  Motorcycle>{
    private ArrayList<T> arrayCar = new ArrayList<>();
    private ArrayList<U> arrayMoto = new ArrayList<>();

   public int parkCar(T car){
       arrayCar.add(car);
       return arrayCar.size();
   }

   public int parkMoto(U moto){
       arrayMoto.add(moto);
       return arrayMoto.size();
   }
}
