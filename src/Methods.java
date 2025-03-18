import java.io.Console;
public class Methods {
    public static void main(String[] args){
        // Console.console = System.console ();

        // System.out.print("dammi un numero > ");
        // String imput1 = console.readLine();
        // int x1 = integer.parseInt(input1);
        // System.out.print("Dammi un numero > ");
        // String imput2 = console.readLine();
        // int x2 = integer.parseInt(input2);

        int x1 = readInteger();
        int x2 = readInteger();

        System.out.println("La somma dei 2 numeri è" + (x1 + x2));
    
        int result = sum(x1 , x2);
        System.out.println("la somma è "+ result);
    }

    public static int readInteger(){  //public = può essere presa ovunque, static = magico, readInteger = nome, (imput)
        Console.console = System.console ();
       
        System.out.print("dammi un numero > ");
        String imput = console.readLine();
        int x = integer.parseInt(input);
        return x;               //il return è OBBLIGATORIO
    }


    public static int sum(int x, int y){
        int z = x + y;
        return z;

    }
    
    public static void printSum(int x, int y){  //una funzione void non viene assegnata ad una variabile nella main
        int z = x + y;
        System.out.println( z );

    }
    


}