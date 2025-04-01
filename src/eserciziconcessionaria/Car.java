package eserciziconcessionaria;

import java.time.Year;

public class Car extends Vehicle{
    private static final double DAILY_COST = 50;

    public Car(String plate, String model, Year year){
        super(plate, model, year);
    }
    @Override
    public double calculateRentCost(int days) {
        return days * DAILY_COST;
    }
}
