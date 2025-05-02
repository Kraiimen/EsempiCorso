package personal.TelephonyExercise;

public class PhoneCall {
    private int minutes;
    private String phoneNumber;

    public PhoneCall(int minutes, String phoneNumber){
        this.minutes = minutes;
        this.phoneNumber = phoneNumber;
    }

    public int getMinutes(){
        return minutes;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void printCall(){
        System.out.printf("Telefonata durata %d minuti con il numero %s%n", minutes, phoneNumber);
    }
}
