import java.io.Console;
import java.util.Random;
public class ArrayExercises {
    public static void main(String[] args) {
        Console console = System.console();
        String Conres = console.readLine("Quale esercizzio vuoi attivare?");
        int Es = Integer.parseInt(Conres);
        int[] numbers = new int[5];
        int[] numbers10 = new int[10];
        int supporto;
        boolean supportoB = true;
        Random dice = new Random(); 
        switch (Es) {
            case 1:
                // 1 creare un array di 5 interi e inizializzarlo con i  primi numeri da 1 a 5 al quadrato
                for(int i =0; i<numbers.length;i++){
                    numbers[i] = (i+1)*(i+1);
                }
                for (int p : numbers) {
                    System.out.println(p);
                }
                break;
            case 2:
                // 2 calcolare e stampare il valore della somma di tutti i numeri contenuti nell'array
                supporto =0;
                for(int i =0; i<numbers.length;i++){
                    numbers[i] = i+1;
                }
                for(int i =0; i<numbers.length;i++){
                    if(numbers[i]>supporto){
                        supporto = numbers[i];
                    }
                }
                System.out.println("il valore della somma di tutti i numeri contenuti nell'array è: "+supporto);
                break;
            case 3:
                // 3 calcolare e stampare il valore minimo contenuto nell'array
                supporto=1000;
                for(int i =0; i<numbers.length;i++){
                    numbers[i] = i+1;
                }
                for(int i =0; i<numbers.length;i++){
                    if(numbers[i] <supporto){
                        supporto = numbers[i];
                    }
                }
                System.out.println("il valore minimo contenuto nell'array è: "+supporto);
                break;
            case 4:
                // 4 calcolare il valore medio dei numeri contenuti nell'array
                supporto =0;
                for(int i =0; i<numbers.length;i++){
                    numbers[i] = i+1;
                }
                for(int i =0; i<numbers.length;i++){
                    supporto += numbers[i];
                }
                System.out.println("il valore medio dei numeri contenuti nell'array è: " + (supporto/numbers.length-1));
                break;
            case 5:
                // 5 calcolare e stampare il numero di multipli di due che esistono all interno del array
                supporto =0;
                for(int i =0; i<numbers.length;i++){
                    numbers[i] = i+1;
                }
                for(int i =0; i<numbers.length;i++){
                    if(numbers[i]%2 == 0){
                        supporto++;
                    }
                }
                System.out.println("il numero di multipli di due è: " + supporto);
                break;
            case 6:
                // 6 dato un valore arbitrario calcolare e stampare il numero di volte in cui l'array contiene il valore
                int Z =2;
                supporto =0;
                for(int i =0; i<numbers.length;i++){
                    numbers[i] = i+1;
                }
                for(int i =0; i<numbers.length;i++){
                    if(numbers[i] == Z){
                        supporto++;
                    }
                }
                System.out.println("il valore 2 c'è: " + supporto + " volte"); 
                break;
            case 7:
                // 7 Invertire l'array
                for(int i =0; i<numbers.length;i++){
                    numbers[i] = i+1;
                }
                for (int r = numbers.length-1,f=0; f<r;f++,r--){
                    supporto = numbers[r];
                    numbers[r] = numbers[f];
                    numbers[f] = supporto;
                }        
                for (int i : numbers) {
                    System.out.println(i);
                }
                break;
            case 8:
                // 8 Dato un numero arbitrario (int z =8) verificare quante volte succede nell array che ci siano 2 numeri consecutivi, la cui somma sia z
                supporto =0;
                int z = 9;
                for(int i =0; i<numbers10.length;i++){
                    numbers10[i] = dice.nextInt(11);
                }
                for(int i =1; i<numbers10.length;i++){
                    if(numbers10[i]+numbers10[i-1] ==z){
                        supporto++;
                    }
                }
                for (int p : numbers10) {
                    System.out.print(p + " ");
                }
                System.out.println("il numero di volte in cui due numeri consecutivi se sommati facciano 8 è: " +supporto);
                break;
            case 9:
                // 9 Verificare che nell'array non esistano 3 numeri consecutivi la cui somma sia maggiore di 12
                supporto =0;
                for(int i =0; i<numbers10.length;i++){
                    numbers10[i] = dice.nextInt(11);
                }
                for(int i =2; i<numbers10.length;i++){
                    if((numbers10[i]+numbers10[i-1]+numbers10[i-2])>12){
                        supportoB =true;
                        supporto = numbers10[i]+numbers10[i-1]+numbers10[i-2];
                        System.out.println(numbers10[i] +" + "+numbers10[i-1] +" + "+ numbers10[i-2] + " = " + supporto);
                    }
                }
                if(supportoB){
                    System.out.println("Sono presenti 3 numeri consecutivi la cui somma da un numero maggiore di 12");
                }else if(supportoB == false){
                    System.out.println("Non sono presenti 3 numeri consecutivi la cui somma da un numero maggiore di 12");
                }
                for (int p : numbers10) {
                    System.out.print(p + " ");
                }
                break;
            case 10:
                // 10 Trovare il numero che appare più volte nell'array, se ci sono due valori con lo stesso numero di volete come massimo, va bene uno dei due o entrambi
                supporto =0; // numero di volte in cui il numero controllato è presente nell array
                int NUmeroControllato;
                int NumMax =0; // numero di volte in cui cui appare il numero più alto
                int MostO= 0; //il numero con il maggior numero di Occurrencys
                for(int i =0; i<numbers10.length;i++){
                    numbers10[i] = dice.nextInt(11);
                }
                for(int i =0; i<numbers10.length;i++){
                    NUmeroControllato = numbers10[i];
                    for(int k =0; k<numbers10.length;k++){
                        if(numbers10[k] == NUmeroControllato){
                            supporto++;
                        }
                    }
                    if(supporto > NumMax){
                    MostO=NUmeroControllato;
                    NumMax=supporto; 
                    }
                    supporto=0;
                }    
                for (int p : numbers10) {
                    System.out.print(p + " ");
                }                
                System.out.println("Il numero che appare di più volte è: " + MostO + " che appare: " + NumMax + " Volte");
                break;
        
            default:
                break;
        }
    }
}
