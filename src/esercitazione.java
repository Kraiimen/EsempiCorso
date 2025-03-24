public class StampaArray{

public static void main (String[] args){
        int[] numeri ={10, 20, 30, 40, 50}

       
        
        for(int i = 0; 1< numeri.length; i++){
          System.out.println(numeri[i] + "")  :
        }

        
    }
}

public class SommaArray {
    public static void main(String[] args) {
        int sum = 0;

        int numeri[] = {10, 20, 30 ,40,50}
        for(int i = 0; i < numeri.length; i++){
            sum = sum + numeri[i];
        }
            
    }
    }
public class MassimoMinimoArray {
    public static void main(String[] args){
       

        int[] numeri = {12, 5, 8, 20, 3, 15};
        int max = numeri[0];
        int min = numeri[0];
        
        for(int i = 1 ; i < numeri.length; i++){
            if(numeri[i] > max){
                max = numeri[i];
            }
            if(numeri[i] < min){
                min = numeri[i];
            }

        }
    }



}
   


}