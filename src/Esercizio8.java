 // Esercizio 8: Dato un numero arbitrario (es int z = 8) verificare quante volte succede nell'array che ci siano due numeri consecutivi la cui somma fa z

public class Esercizio8{
	public static void main(String[] args){

    int[] numbers = new int[5];
    numbers[0] = 1;
    numbers[1] = 2;
    numbers[2] = 3;
    numbers[3] = 4;
    numbers[4] = 5;


        int counter = 0;
        int z = 3;
        for(int i =0; i < (numbers.length-1); i++){ 
            if(z == (numbers[i]+ numbers[i + 1])){
                counter++;
            }    

        }

        System.out.println(counter);
        
    }
}       
