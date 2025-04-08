package firstExercises;

public class SwitchExamples {
    public static void main(String[] args){
        int x = 22; // x = ?
        switch (x) {
            case 12:
                System.out.println("x vale 12");
                break;
            case 22:
                System.out.println("X vale 22");
                //break; //senza break continua fino al prossimo break
            case 3:
                System.out.println("X vale 3");
                break;
            default:
                System.out.println("X ha un valore non previsto");
        }
        String name = "Elvis";
        switch (name){
            case "Elvis","Filippo","Lorenzo","Camilla","Edoardo","Nicolò" -> System.out.println("Lo studente fa parte di RavenClaw");
            case "Emanuele", "Rino" -> System.out.println("Lo studente fa parte di Gryffindor");
            default -> System.out.println("Lo studente è un imboscato");
        }
        String message = switch (name){
            case "Elvis","Filippo","Lorenzo","Camilla","Edoardo","Nicolò" -> "Lo studente fa parte di RavenClaw";
            case "Emanuele", "Rino" -> "Lo studente fa parte di Gryffindor";
            default -> "Lo studente è un imboscato";

        };
    }
}
