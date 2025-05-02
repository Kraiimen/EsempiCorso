package personal.TelephonyExercise;

public class Start {
    public static void main(String[] args){
        SimCard sc = new SimCard("1" , 0);
        sc.addPhoneCall(1, "123");
        sc.addPhoneCall(65, "555");
        sc.addPhoneCall(3, "123");

        int x = sc.calculateTotalMinutes();
        System.out.println(x);
        int y = sc.getHowManyCallsGivenNumber("123");
        System.out.println(y);
        sc.printInfoAndCalls();
    }
}
