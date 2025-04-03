package org.generation.italy.fantasykingdom;

import java.util.ArrayList;

public class FantasyBattle {
    public static void main(String[] args) {
        ArrayList<Fighter> fighters = new ArrayList<>();
        Knight Volodya = new Knight("Vova", 100, 38, 25);
        Wizard Anus = new Wizard("MagusAnus", 80, 30);
        Wizard Penus = new Wizard("Penus", 75, 28);
        Dragon dragoon = new Dragon("Mikhail", 140, 60);

        Anus.attack(dragoon);
        Volodya.attack(dragoon);
        dragoon.attack(Anus);


    }
}
