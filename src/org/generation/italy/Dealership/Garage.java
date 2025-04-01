package org.generation.italy.Dealership;

import java.util.ArrayList;

public class Garage<T extends Car, U extends  Motorcycle>{
    private ArrayList<T> arrayCar;
    private ArrayList<U> arrayMoto;

    public Garage(){
        arrayCar = new ArrayList<>();
        arrayMoto = new ArrayList<>();
    }

   public int parkCar(T car){
       arrayCar.add(car);
       car.handBrake();
       System.out.println("Sto parcheggiando la macchina");
       return arrayCar.size();
   }

   public int parkMoto(U moto){
       arrayMoto.add(moto);
       moto.putOffStand();
       System.out.println("Sto parcheggiando la moto");
       return arrayMoto.size();
   }
}
