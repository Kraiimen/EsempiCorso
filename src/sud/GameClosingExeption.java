package sud;

public class GameClosingExeption extends Exception {
    public GameClosingExeption() {
        super("The game has closed");
    }
}
