package org.generation.italy.vehiclesRental;

import java.time.Year;

public class ElectricCar extends Vehicle{
    private static final double DAILY_COST = 50;
    private final double AUTONOMY_IN_KILOMETERS;
    private final int MAX_CHARGE = 100;
    private int batteryCharge;

    public ElectricCar(String plate, String model, Year year, double AUTONOMY_IN_KILOMETERS){
        super(plate, model, year);
        this.AUTONOMY_IN_KILOMETERS = AUTONOMY_IN_KILOMETERS;
        batteryCharge = MAX_CHARGE;
    }

    @Override
    public double calculateRentalCost(int days){
        return days * DAILY_COST;
    }

    public void recharge(){
        batteryCharge = MAX_CHARGE;
    }
}
