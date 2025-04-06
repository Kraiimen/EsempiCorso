package introduction;

public class Conditionals {
    public static void main(String[] args) {

        int x = 10;

        if (x == 3) {
            System.out.println("Si, si, x è uguale proprio a 3");
        } else if (x == 5) {
            System.out.println("Si, x è uguale a 5");
        } else if (x == 7) {
            System.out.println("Si, x è uguale a 7");
        } else {
            System.out.println("X è diverso da 3, 5 e 7");
            System.out.println("Che sfiga!");
        }

        // Se hai meno di 15 anni, il costo sarà uguale a 50
        // Se hai tra i 15 e i 20 anni, il costo sarà 70
        // Se hai tra i 20 e i 32 anni, il costo sarà 200
        // Se hai 32 anni e più, il costo sarà 200

        // se la persona ha tra 20 e 32 anni, è maschio e chiede un biglietto
        // dopo le 18, ha uno sconto di 10% sul biglietto
        // se è femmina, ha uno sconto di 20% dopo le 15
        // femmine: lo sconto viene dato alle persone che arrivano dopo le 15 oppure dev'essere un mercoledì
        // maschi:


        int age = 25;
        double cost = 0;
        boolean isFemale = false;
        int time = 16;

        final double FEMALE_DISCOUNT_PERCENTAGE = 0.2;
        final double MALE_DISCOUT_PERCENTAGE = 0.1;
        final String day = "wednesday";
        // final significa che la variabile è una costante

        if (age < 15) {
            cost = 50;
        } else if (age < 20) {
            cost = 70;
        } else if (age < 32) {
            cost = 100;
            if (isFemale && (time > 15 || day.equals("wednesday"))) {
                // cost=cost * (1 - FEMALE_DISCOUNT_PERCENTAGE);
                // cost=cost-cost*FEMALE_DISCOUNT_PERCENTAGE;
                cost -= cost * FEMALE_DISCOUNT_PERCENTAGE;
            } else if (!isFemale && (time > 18 || day.equals("sunday"))) {
                // cost=cost * (1 - MALE_DISCOUT_PERCENTAGE);
                cost -= cost * MALE_DISCOUT_PERCENTAGE;
            }
        } else {
            cost = 200;
        }

        // } else if (age < 32) {
        // cost = 100;
        // if (isFemale) {
        // if (time >= 15) {
        // // cost=cost*.8; cost=cost-cost/5;
        // cost = cost * (1 - FEMALE_DISCOUNT_PERCENTAGE);
        // }
        // } else {
        // if (time >= 18) {
        // // cost=cost*.9; cost=cost-cost/10
        // cost = cost * (1 - MALE_DISCOUT_PERCENTAGE);
        // }
        // }
        // } else {
        // cost = 200;
        // }


        // else if (age < 32 && isFemale && time > 15) {
        // 	cost = cost * (1 - FEMALE_DISCOUNT_PERCENTAGE);
        // } else if (age < 32 && !isFemale && time > 18) {
        // 	cost = cost * (1 - MALE_DISCOUT_PERCENTAGE);
        // } else if (age < 32) {
        // 	cost = 100;
        // } else {
        // 	cost = 200;
        // }

        System.out.println(cost);

    }
}