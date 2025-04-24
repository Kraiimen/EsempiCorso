package javaIntroduction;

public class SwitchExamples {
    public static void main(String[] args) {
        int x = 22; // Supponiamo di non sapere quanto valga x
        switch(x) {
            case 12:
                System.out.println("x vale 12");
                break;
            case 22:
                System.out.println("x vale 22");
                // Non faccio break? Lui esegue tutti gli altri casi fino a quando trova un break;
                break; // Senza il break stamperebbe anche "x vale 3"
            case 3:
                System.out.println("x vale 3");
                break;
            default:
                System.out.println("x ha un valore non previsto");
        }

        String name = "Elvis";
        switch (name) {
            case "Elvis", "Filippo", "Lorenzo", "Camilla", "Edoardo", "Nicolò" -> System.out.println("Lo studente è di Ravenclaw");
            case "Emanuele", "Piero", "Rino" -> System.out.println("Lo studente è Gryffindor");
            default -> System.out.println("Lo studente è imboscato");
        }

        String message = switch (name) {
            case "Elvis", "Filippo", "Lorenzo", "Camilla", "Edoardo", "Nicolò" -> "Lo studente è di Ravenclaw";
            case "Emanuele", "Piero", "Rino" -> "Lo studente è Gryffindor";
            default -> "Lo studente è imboscato";
        };


    }
}
