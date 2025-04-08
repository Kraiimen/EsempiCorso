package mudgame.main;

import mudgame.entities.*;
import mudgame.entities.Character;

public class Main {
    public static void main(String[] args) {
        Character c1 = new Character("Carmine", 100, "Kraiimen", 10, 10);
        Character c2 = new Character("Alessio", 100, "BebeLasquale", 10, 10);
        SuperChar sc = new SuperChar("Sabrina", 100, "Tusk", 10, 10);

        c1.attackPlayer(c2);
        c1.attackPlayer(sc);
    }
}
