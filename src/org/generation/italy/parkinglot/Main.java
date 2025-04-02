package org.generation.italy.parkinglot;

import org.generation.italy.parkinglot.garagemanagement.Garage;
import org.generation.italy.parkinglot.vehicles.Car;
import org.generation.italy.parkinglot.vehicles.Motorcycle;
import org.generation.italy.parkinglot.vehicles.cars.Ferrari;
import org.generation.italy.parkinglot.vehicles.cars.Porsche;
import org.generation.italy.parkinglot.vehicles.motorcycles.Guzzi;
import org.generation.italy.parkinglot.vehicles.motorcycles.Harley;

public class Main {
    public static void main(String[] args){
        Garage<Car, Motorcycle> garage = new Garage<>();
        Porsche porscheNera = new Porsche("ihih");
        Ferrari ferrariRossa = new Ferrari("ohoh");
        Harley harleyBlu = new Harley("ehe3h");
        Guzzi guzziGialla = new Guzzi("ah5ah");

        garage.parkCar(porscheNera);
        garage.parkCar(ferrariRossa);
        garage.parkMotorcycle(harleyBlu);
        garage.parkMotorcycle(guzziGialla);
    }
}
