import java.io.Console;
public class Methods{
    public static void main(String[] args){
        // Console console = System.console();// .console è una funzione la variabile ha ol nome console, C è nome classe e c è il nome

        // System.out.println("Dammi un numero > ");
        // String input1 = console.readLine(); // creo stringa di nome input e deve leggere la console
        // int x1 = Integer.parseInt(input1);
        // System.out.println("Dammi il secondo numero > ");
        // String input2 = console.readLine();
        // int x2 = Integer.parseInt(input2);

        int x1 = readInteger();
        int x2 = readInteger();

        System.out.println("La somma dei due numeri è " + (x1 + x2));
        int result = sum(x1 , x2);
        System.out.println("la somma dei due numeri è " + result);

        printSum(x1 , x2);
        sum(x1 , x2); // se non c'è una variabile che la riceve, non cambia nulla invocando sum
    }

    public static int readInteger(){
        // è una funzione intero che legge l'input e converte in int
        // nelle tonde ci sarebbe un imput che serve alla macchina 
        // ma ad alcune non serve mettere nulla dentro
        // nelle {} c'è il body della funzione
        Console console = System.console();
        System.out.println("Dammi un numero intero > ");
        String input = console.readLine();
        int x = Integer.parseInt(input); //legge dall'input un numero e la trasforma in un intero
        return x; // e la fa ritornare come numero intero

    }

    public static int sum(int x, int y){ // int: mi torna un intero
    // funzione che prenderà x e y e farà una somma
        int z = x + y;
        return z;

    }

    public static void printSum(int x , int y){
        int z = x + y;
        System.out.println(z);
    } 
    
}