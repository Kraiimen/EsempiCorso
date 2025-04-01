package org.generation.italy.vehiclesRental;

import java.time.Year;

public class MotorBike extends Vehicle {
    private static final int DAYS_FOR_DISCOUNT = 5;
    private static final int DAILY_COST = 30;

    public MotorBike(String plate, String model, Year year){
        super(plate, model, year);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days <= DAYS_FOR_DISCOUNT ? days * DAILY_COST : days * DAILY_COST - (days * DAILY_COST * DAYS_FOR_DISCOUNT);
    }

}
