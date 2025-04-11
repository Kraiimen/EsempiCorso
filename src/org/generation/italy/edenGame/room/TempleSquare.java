package org.generation.italy.edenGame.room;

import java.util.Map;

public class TempleSquare extends Room{


    public TempleSquare(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("Una piazza sacra, al centro della cittadella, pieno di persone e di storie ");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" ");
    }


    @Override
    public void getPossibleActions() {
        System.out.println("Cerca (C), Esci da qua (E)");
    }

}
