public class NewArray {
    public static void main(String[] args) {
        // verifica se i numeri nell'array sono ordinati in ordine crescente
        // immagina che l'array sia fatto così: 2, 7, 5, 8, 10
     int[] array7 = {2, 4, 5, 8, 10};
     boolean sorted = true;

     for(int i = 0 ; i < array7.length-1; i++ ){
        if(array7[i] > array7[i+1]){
           sorted = false;
           break;
        }
     } 
        if(sorted){
        System.out.println("I numeri sono in ordine crescente");
     } else {
        System.out.println("I numeri non sono in ordine crescente");}
     
     
       // Esercizio 8: Dato un numero arbitrario (es int z = 8) verificare quante volte succede nell'array che ci siano due numeri consecutivi la cui somma fa z 
     
     int[] numbers10 = {8,8,2,2,8,8,3,2,2,8,8,8};
     int z = 4;
     int counter = 0;
     for(int i = 0; i < numbers10.length-1; i++){
        if(numbers10[i] + numbers10[i+1] == z){
            counter++;
        }
    }   
        System.out.println("Le volte che un numero si ripete due volte "+ z + ": "   + counter + " volte");



      // Esercizio 9: Verificare che nell'array non esistono tre numeri consecutivi la cui somma è maggiore di 12

      int[] array6 = {1,2,3,4,5,6,7,8,9,10};
      int q = 12;
      int counter5 = 0;
      boolean treNumberi = false;

      for(int i = 0; i < array6.length-2; i++){
        if(array6[i] + array6[i+1] + array6[i+2] > q){
            counter5++;
            treNumberi= true;
            System.out.println("Nell'array esistono tre numeri consecutivi:" + array6[i] + " ," + array6[i+1]+ " ," + array6[i+2] + "sono maggiori di 12");
        }
      } if(!treNumberi){
            System.out.println("Nell array non ci");
        }
    



     int[] number11 = {1,2,3,2,3,1,1,2,3};
     boolean treNumeri = false;
     int x =12;
     int counter1 = 0;
     for (int i = 0; i < number11.length-2; i++){
        if( number11[i] + number11[i+1]+ number11[i+2] > x){
            counter1++;
            treNumeri = true;
            System.out.println("la somma di questi numeri: "+ number11[i]+ ", "+ number11[i+1] + ", " + number11[i+2] + " sono maggiori di 12");
        } 
    } 
    if(treNumeri == false){
        System.out.println("Non esistono tre numeri CONSECUTIVI CHE IL VALORE è MAGGIORE DI 12");
    } else{
        System.out.println(counter1); 
    }



    // Esercizio 10: Trovare il numero che appare più volte nell'array -es [2, 7, 12, 7, 2] - se ci sono più valori che appaiono lo stesso numero di volte basta che il programma stampi uno di questi numer 


        int[] array10 = {1, 7, 12, 7, 3};
        int numRipetuti= 0; // quante volte appare il numer
        int maxRecap= 0;  // Tiene traccia del massimo numero di ripetizioni

    // Facciamo due cicli for per confronatre lo stesso array e contare gli stessi 
        for(int i = 0 ; i < array10.length; i++){
            int counter3 = 0;
            for(int j = 0 ; j < array10.length; j++){
                if(array10[i] == array10[j]){ //Il ciclo interno j confronta l'elemento array10[i]con ogni altro elemento array10[j].
                    counter3++; // quando trova la corrispondenza aggiunge 1 
                }
                if(counter3 > maxRecap){ //Controlliamo se counter3 è maggiore di maxRecap (che tiene traccia del numero massimo di ripetizioni trovato finora).
                    maxRecap = counter3;
                    numRipetuti = array10[i];
                }

            }
        }       
        System.out.println("Il numero che viene ripetuto è:    " + numRipetuti);
        
      

        int[] array9 =  {2, 7, 12, 7, 2};
        int numRepeat = array9[0]; // andrà a vedere qual è il numero che appare di piu
        int maxRe = 0; // andrà a calcolare quante volte è stato conteggiato 

        for (int m = 0; m < array9.length; m++){
            int counterNew = 0;
            for(int w = 0; w < array9.length; w++){
              if(array9[m] == array9[w]){
                  counterNew++;
                } if(counterNew > maxRe){
                 maxRe = counterNew;
                 numRepeat= array9[m];
                }
  
            }
        }    
        System.out.println("il numero che appare di piu : " +  numRepeat);
        
  
        System.out.println();
  

    }
}
