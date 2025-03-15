import java.io.Console;

public class FindBiggest{
    public static void main(String[] args){
        Console console = System.console();

        //*
        int maxValue = Integer.MIN_VALUE;
        String answer = "";

        while(!(answer.toUpperCase().equals("Q"))){
            System.out.println("inserisci un numero, premi q per finire");
            answer = console.readLine();
            
            if(!(answer.toUpperCase().equals("Q"))){
                int n = Integer.parseInt(answer);
                if(maxValue < n){
                    maxValue = n;
                }
            }
        }
        if(maxValue != Integer.MIN_VALUE)
        {
            System.out.println("\nIl più grande inserito è " + maxValue);
        }
        else {
            System.out.println("\nnon hai inserito nessun numero");
        }
        //*/

    }
}