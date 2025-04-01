package org.generation.italy.vehiclesRental;

import java.time.Year;

public class Car extends Vehicle{
    private static final int DAILY_COST = 50;

    public Car(String plate, String model, Year year){
        super(plate, model, year);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * DAILY_COST;
    }
}
