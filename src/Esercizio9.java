
public class Esercizio9{
	public static void main(String[] args){

// Esercizio 9: Verificare che nell'array non esistano tre numeri consecutivi la cui somma è maggiore di 12
        
            
        int sum = 12;
        boolean status = false;
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2*2;
        numbers[2] = 3*3;
        numbers[3] = 4*4;
        numbers[4] = 5*5;

        
        for(int i =0; i < (numbers.length-2); i++){
            if((numbers[i]+ numbers[i + 1] + numbers[i + 2]) > 12){
                status = true;

            }
        }             
        if(status == true){
            System.out.println("esistono tre numeri consecutivi la cui somma e maggiore di 12");
        }
        if(status == false){
            System.out.println("non esistono tre numeri consecutivi la cui somma e maggiore di 12");
        }           
    }             
}