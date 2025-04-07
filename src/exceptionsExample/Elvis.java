package exceptionsExample;

import java.util.Scanner;

public class Elvis {
    public static void main(String[] args) {
        System.out.println("Inizio main");
        Scanner scanner = new Scanner(System.in);
        Account a = new Account(1000);
        boolean correct = false;
        int amount = 0;

        do {
            System.out.print("Inserisci un amount: ");
            amount = scanner.nextInt();

            try{
                a.deposit(amount);
                correct = true;
            } catch (ElvisException e) {
                System.out.println(e.getMessage());
            }
        } while (!correct);

        System.out.println("Fine main");
    }
}
