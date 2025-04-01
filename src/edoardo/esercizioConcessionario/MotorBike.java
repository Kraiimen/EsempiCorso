package edoardo.esercizioConcessionario;

import java.time.Year;

public class MotorBike extends Vehicle {
    private static final double DAILY_COST = 30;
    private static final int daysForDiscount = 5;
    private static final double DISCOUNT_PERCENTAGE = 0.1;

    public MotorBike(String plate, String model, Year year){
        super(plate, model, year);

    }

    @Override
    public double calculateRentCost(int days) {
        if(days <= 0){
            System.out.println("Non puoi mettere 0");
            return 0;
        }

        if(days <= daysForDiscount){
            return DAILY_COST*days;
        }
        return DAILY_COST*(1-DISCOUNT_PERCENTAGE)*days;
        //return days > 5 ?  DAILY_COST*(1-DISCOUNT_PERCENTAGE)*days: DAILY_COST * days;

    }
}
