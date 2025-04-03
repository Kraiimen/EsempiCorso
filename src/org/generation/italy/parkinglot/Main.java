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

        porscheNera.startEngine();
        garage.parkCar(porscheNera);
        porscheNera.stopEngine();

        System.out.println();

        ferrariRossa.startEngine();
        garage.parkCar(ferrariRossa);
        ferrariRossa.stopEngine();

        System.out.println();

        harleyBlu.startEngine();
        garage.parkMotorcycle(harleyBlu);
        harleyBlu.stopEngine();

        System.out.println();
        
        guzziGialla.startEngine();
        garage.parkMotorcycle(guzziGialla);
        guzziGialla.stopEngine();
    }
}
