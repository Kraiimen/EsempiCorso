package esercizioConcessionaria;

import java.util.ArrayList;

public class Dealership {
    private ArrayList<Vehicle> vehicles;

    public Dealership(){
        vehicles = new ArrayList<Vehicle>();
    }
    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle){
        vehicles.remove(vehicle);
    }
    public Vehicle searchVehicle(String plate){
        for(Vehicle v : vehicles){
            if(v.getPlate().equals(plate)){
                return v;
            }
        }
        return null;
    }
}
