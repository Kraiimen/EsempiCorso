import java.io.Console;
public class Functions {
    
    public static void main(String[] args) {
        Console console = System.console();
        // int val1 = ReadInt();
        // int val2 = ReadInt();
        // System.out.println("La somma dei due numeri è: " + (val1+val2));
        // int ev = ReadInt();
        // System.out.println(checkEven(ev));
        String input = console.readLine("inserisci una frase: ");
        // String input2 = console.readLine("inserisci un' altra frase: ");
        // printLenAndUpperCaseLowerCase(input);
        System.out.println(Capitalize(input));
    }
    public static int ReadInt(){
        Console console = System.console();
        String input = console.readLine("inserisci un numero: ");
        return Integer.parseInt(input);

    }
    // un metodo che controlli se il dato numero è pari, se lo è risponde con un bool true, sennò false
    public static boolean checkEven (int x){
        return x%2==0;
    }

    public static void lenghtout (String x){
        System.out.println(x.length());
    }
    public static void upperout (String x){
        System.out.println(x.toUpperCase());
    }
    public static void lowerout (String x){
        System.out.println(x.toLowerCase());
    }
    public static void printLenAndUpperCaseLowerCase (String x){
        lenghtout(x);
        upperout(x);
        lowerout(x);
    }
    public static String wichIsLonger(String x, String y){
        return x.length()>y.length()?x:y;
    }

    public static String Capitalize(String sentence) {
        sentence = sentence.toLowerCase();
        sentence = (Character.toUpperCase(sentence.charAt(0)))+sentence.substring(1);
        return sentence;
    }
}
