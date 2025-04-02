package org.generation.italy.Dealership;

import java.util.ArrayList;

public class Start {
    public static void main(String[] args){
        Garage<Car, Motorcycle> garage = new Garage<>();

        garage.parkCar(new Ferrari());
        garage.parkCar(new Porsche());
        garage.parkMoto(new Harleydavidson());
        garage.parkMoto(new Guzzi());
    }

}
