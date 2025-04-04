package org.generation.italy.vehiclesRental;

import java.util.ArrayList;

public class Concessionaria {
    private ArrayList<Vehicle> vehicles;

    public Concessionaria(){
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        vehicles.remove(vehicle);
    }

    public Vehicle findByPlate(String plate){
        for(Vehicle v : vehicles){
            if(v.getPlate().equals(plate)){
                return v;
            }
        }
        return null;
    }
}
