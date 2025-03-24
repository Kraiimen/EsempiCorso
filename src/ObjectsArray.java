public class ObjectsArray{
    public static void main (String[] args){
        String[] as = new String[5];
        //stampare maiuscola prima stringa
        // System.out.println(as[0].toUpperCase());
        String[] students = {"Lorenzo Coretti,griffindor", "Vittorio Aquila,ravenclaw"};
        System.out.println (students[0].toUpperCase());

        String[] griffindor = new String [6];
        int grCounter = 0;
        griffindor[grCounter] = "Emanuele Giustiniani";
        grCounter ++;
        String s1 = students[0];
        System.out.println (s1);
        String[] sTokens = s1.split(",");
        System.out.println (sTokens[0]);
        System.out.println (sTokens[1]);


        String x = "Lorenzo Coretti";
        if (sTokens[0] != x){
            System.out.println(x);
        }
        
        
    
    }

}