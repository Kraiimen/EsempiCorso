public class Loops {
    public static void main(String[] args) {
           
         //  1 ciclo del 1 slot eseguirà solo una volta che int=0 ,2 slot  poi valuta che i<10, 3 
         // slot esegue e pensa due è minore di dieci e quindi continua fino a nove. 
      for(int i = 0; i < 10; i++ ){
           System.out.println(i);
        }
            System.out.println("Terminato il ciclo");

        //     //ciclo For che stampa i numeri dipari da 1 a 100

    //     for (int i = 0 ; i < 101; i++ ){
    //         if(i % 2 != 0) {  // se
    //             System.out.println(i);
    //     }
    // } 
      for(int i=1; i < 100; i -=5){ 
        System.out.println(i);
      }

      int y = 100;
      while (y > 0) {
        System.out.println(y);
        y -= 5;
      }
        
     
      

    }
}
