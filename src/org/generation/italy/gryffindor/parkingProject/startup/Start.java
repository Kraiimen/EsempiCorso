package org.generation.italy.gryffindor.parkingProject.startup;

import org.generation.italy.gryffindor.parkingProject.parking.*;

public class Start {
    public static void main(String[] args){
        Garage<Car, MotorCycle> garage = new Garage<Car, MotorCycle>();
        Car f = new Ferrari();
        Car p = new Porsche();
        MotorCycle h = new Harley();
        MotorCycle g = new Guzzi();
        f.startEngine();
        p.startEngine();
        h.startEngine();
        g.startEngine();

        f.turnOffEngine();
        p.turnOffEngine();
        h.turnOffEngine();
        g.turnOffEngine();

        f.startEngine();
        p.startEngine();
        h.startEngine();
        g.startEngine();

        garage.parkCar(f);
        garage.parkCar(p);
        garage.parkCar(p);
        garage.parkMotorCycle(h);
        garage.parkMotorCycle(g);
    }
}
