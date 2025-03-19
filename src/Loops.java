import java.io.Console;

public class Loops {
    public static void main(String[] args){

        


        Console console = System.console();



        // Ciclo for che stampa i numeri dispari da 1 a 100
        
        // for(int i=1; i<101; i+=2){
        //     System.out.println(i);
        // }


        // Multipli di 5 da 100 a 0
        // for(int i=100; i>0; i-=5){
        //     System.out.println(i);
        // }

        // int y = 100;
        // while(y > 0){
        //     System.out.println(y);
        //     y -= 5;
        // }

        // int z = 100;
        // do {
        //     System.out.println(z);
        //     z -= 5;
        // } while (z > 0);

        String answer;
        do {
            System.out.println("Inserisci una risposta di tipo Yes or No");
            answer = console.readLine();

            if(!answer.equals("Yes") && !answer.equals("No")){
                System.out.println("Ti ho detto di rispondere Yes or No");
            }

        } while (!answer.equals("Yes") && !answer.equals("No"));
    }

    public void prova(){
        System.out.println("Sono prova() in Loops");
    }
}