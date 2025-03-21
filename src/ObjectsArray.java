public class ObjectsArray{
    public static void main(String [] args){
        //System.out.println(22/4.0);
        String [] as = new String [5];
        //stampare maiuscola prima stringa array
        // System.out.println(as[0].toUpperCase()); // errore in fase di interpretazione, quando viene creato un array di oggetti lo inizializza con il valore di default delle reference -> null, un indirizzo invalido
        // -> NullPointerException
        String [] students = {"Vittorio Aquila,griffindor", "Lorenzo Coretti,ravenclaw"};
        String s1 = students[0];
        String[] sTokens = s1.split(","); //ritorna la stringa spezzata
        System.out.println(sTokens[0] + " " + sTokens[1]);
    }
}