package org.generation.italy.ravenClaw.garageExercise;

public class Startup {
    public static void main (String[] args){
        Garage<Car, Motorcycle> garage = new Garage<>();

        garage.parkCar(new Ferrari());
        garage.parkCar(new Porsche());
        garage.parkMoto(new Harley());
        garage.parkMoto(new Guzzi());
    }
}
