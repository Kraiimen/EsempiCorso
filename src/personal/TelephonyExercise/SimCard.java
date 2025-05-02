package personal.TelephonyExercise;

import java.util.ArrayList;

public class SimCard {
    private static int lastId = 0;
    private int id;
    private String phoneNumber;
    private double credit;
    private ArrayList<PhoneCall> calls;

    public SimCard(String phoneNumber,double credit){
        this.phoneNumber = phoneNumber;
        this.credit = credit;
        calls = new ArrayList<>();
        lastId ++;
        id = lastId;
    }

    public void addPhoneCall(int minutes, String phoneCalled){
        calls.add(new PhoneCall(minutes, phoneCalled));
    }

    public int calculateTotalMinutes(){
        int totalMinutes = 0;
        for(PhoneCall pc : calls){
            totalMinutes += pc.getMinutes();
        }
        return totalMinutes;
    }

    public int getHowManyCallsGivenNumber(String phoneCalled){
        int totalCalls = 0;
        for(PhoneCall pc : calls){
            if(phoneCalled.equals(pc.getPhoneNumber())){
                totalCalls++;
            }
        }
        return totalCalls;
    }

    public void printInfoAndCalls(){
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Sim ID" + id);
        System.out.println("Credit :" + credit);
        for(PhoneCall pc : calls){
            pc.printCall();
        }
    }
}
