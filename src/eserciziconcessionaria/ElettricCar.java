package eserciziconcessionaria;

import java.time.Year;

public class ElettricCar extends Vehicle{
    private final double DAILY_COST = 50;
    private  final double AUTONOMY_KM;
    private final int MAX_CHARGE = 100;
    private int batteryCharge;

    public ElettricCar(String plate, String model, Year year, double AUTONOMY_KM) {
        super(plate, model, year);
        this.AUTONOMY_KM = AUTONOMY_KM;
        this.batteryCharge = MAX_CHARGE;
     }

    @Override
    public double calculateRentCost(int days ) {
        return days * DAILY_COST;
    }

    public void recharge(){
        batteryCharge = MAX_CHARGE;
    }
}



