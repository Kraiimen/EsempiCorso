package edoardo.esercizioConcessionario;

import java.time.Year;

public class ElectricCar extends Vehicle {
    private static final double DAILY_COST = 50;
    private final double AUTONOMY_IN_KILOMETERS;
    private int batteryCharge;
    private final int MAX_CHARGE = 100;

    public ElectricCar(String plate, String model, Year year, double maxAutonomy){
        super(plate, model, year);
        AUTONOMY_IN_KILOMETERS = maxAutonomy;
        batteryCharge = MAX_CHARGE;

    }

    @Override
    public double calculateRentCost(int days) {
        return DAILY_COST*days;
    }
    public void recharge(){
        batteryCharge = MAX_CHARGE;
    }
}
