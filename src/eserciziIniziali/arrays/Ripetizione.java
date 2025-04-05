package eserciziIniziali.arrays;

public class Ripetizione {
    public static void main(String[] args) {

        int a = 10;
        int[] vettoreA = new int[5]; // gli indici del vettore vanno da 0 a n-1 attraverso l'indice accedo alla cella
        // vettoreA[0] = 10;
        // vettoreA[4] = 10;
        // System.out.println(vettoreA[4]); //10
        // vettoreA[vettoreA.length-1] = 15;
        // System.out.println(vettoreA[4]);
        // for(int i = 4 ; i >= 0 ; i--) {
        //     vettoreA[i] = i+10;
        //     System.out.println(vettoreA[i]);
            
        // }
        
        for(int i= 0 ; i < vettoreA.length ; i++) {
            vettoreA[i] = i+10;   
        }
            // vettoreA[4] = vettoreA[0];
            // vettoreA[3] = vettoreA[1];
            // vettoreA[2] = vettoreA[2];
            // vettoreA[1] = vettoreA[3];
            // vettoreA[0] = vettoreA[4];
            
            int temp = 0;
            for(int i = vettoreA.length-1 ; i >= 0 ; i-- ) {
               vettoreA[i] = vettoreA[temp];
               temp++;
            }



            // for(int i = vettoreA.length-1 ; i >= 0 ; i-- ) {
            //     for(int y = 0 ; y < vettoreA.length;y++){
            //         vettoreA[i] = vettoreA[y];
            //     }   
            //  }

    }
}
