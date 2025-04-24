import java.util.Random;
import java.util.Vector;

// NO PAIN, NO GAIN

public class Puzzle {
    public static void main(String[] args) {
        // StringBuilder
        StringBuilder word = new StringBuilder("Elvis");
        System.out.println("Prima dello StringBuilder: " + word);
        word.append(" La Fata");

        // String
        String parola = "Carmine";
        System.out.println("Prima dello '+=' : " + parola);
        parola += " Erario";

        System.out.println("StringBuilder: " + word);
        System.out.println("Dopo '+=' : " + (parola));
    }
}
