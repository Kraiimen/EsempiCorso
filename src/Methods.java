import java.io.Console; // io sta per input output
public class Methods{
    public static void main(String[] args){





        int num1 = readInteger(); // invochiamo la funzione readInteger che assegna il valore di num  a num1
        int num2 = readInteger(); 

        //System.ou.println("La somma dei due numeri è: " + num1+num2) //stampa num1 e num 2 come stringa -> errore di logico -> lo fa perche a concatenare parte da sinistra 
        //System.ou.println("La somma dei due numeri è: " + (num1+num2)); //necessario per fare correttamente la somma di num1 e num 2
        System.out.println("La somma dei due numeri è: " + sum(num1, num2)); 
        printSum(num1, num2);



    }

    public static int readInteger(){
        Console console = System.console(); //chiamiamo il metodo console di system
        String input = console.readLine("Dammi un numero > ");
        int num = Integer.parseInt(input);
        return num;
    }
    public static int sum(int x, int y){
        int sum = x + y;
        return sum;
    }
    public static void printSum(int x, int y){
        System.out.println("La somma dei due numeri è: " + sum(x, y)); 
    }


}