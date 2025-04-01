package esercizioConcessionaria;

import java.time.Year;

public class MotorBike extends Vehicle {
    private static final double DAILY_COST = 30;
    private static final int DAYS_FOR_DISCOUNT = 5;
    private static final double DISCOUNT_PERCENTAGE = 0.1;

    public MotorBike(String plate,String model, Year year){
        super(plate, model, year);
    }

    @Override
    public double calculateRentCost(int days){
        if(days <= 0){
            System.out.println("TU MADRE");
            return 0;
        }
//        if(days <= DAYS_FOR_DISCOUNT){
//            return days * DAILY_COST;
//        } else {
//            return days * DAILY_COST - (days * DAILY_COST * DISCOUNT_PERCENTAGE);
//        }
       return days <= DAYS_FOR_DISCOUNT ? days * DAILY_COST : days * DAILY_COST - (days * DAILY_COST * DISCOUNT_PERCENTAGE);
    }



}
