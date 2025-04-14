package sud;

public class Start {
    public static void main(String[] args) {

        Game.start();

        while (true) {
            Game.printGUI();

            Game.update();

        }
    }
}
