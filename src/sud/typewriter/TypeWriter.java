package sud.typewriter;

public class TypeWriter {

    public static void byLetter(String input) {
        byLetter(input, 5);
    }

    public static void byLetter(String input, int ms) {
        for (int i = 0; i < input.length(); i++) {
            System.out.print(input.charAt(i));
            sleep(ms);
        }
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
