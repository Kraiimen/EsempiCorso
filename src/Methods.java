import java.io.Console;
public class Methods{
    public static void main(String[] args){
        // Console console = System.console();

        // System.out.print("Dammi un numero > ");
        // String input1 = console.readLine();
        // int x1 = Integer.parseInt(input1);
        // 
        // System.out.print("Dammi un numero > ");
        // String input2 = console.readLine();
        // int x2 = Integer.parseInt(input2);

        int x1 = readInteger();
        int x2 = readInteger();

        System.out.println("La somma dei due numeri è " + (x1 + x2));

        int result = sum(x1 , x2);
        System.out.println("La somma dei due numeri è " + result);

        printSum(x1 , x2);
        sum(x1 , x2); //se non c'è una variabile che la riceve, non cambia nulla invocando sum
    }

    public static int readInteger(){
        Console console = System.console();

        System.out.print("Dammi un numero intero > ");
        String input = console.readLine();
        int x = Integer.parseInt(input);
        return x;
    }

    public static int sum(int x , int y){
        int z = x + y;
        return z;
    }

    public static void printSum(int x , int y){
        int z = x + y;
        System.out.println(z);
    }


}