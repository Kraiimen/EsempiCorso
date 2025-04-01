package edoardo.esercizioConcessionario;

import java.util.ArrayList;

public class Dealership {
    private ArrayList<Vehicle> vehicles;

    public Dealership(){
        vehicles = new ArrayList<>();
    }
    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle){
        vehicles.remove(vehicle);
    }


}
