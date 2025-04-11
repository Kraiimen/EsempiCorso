package org.generation.italy.edenGame.room;

import java.util.Map;

public class Temple extends Room{

    public Temple(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("Qui il sacerdote potrà farti riposare. Puoi anche chiedergli una benedizione per la tua Esperienza ");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println(" ");
    }


    @Override
    public void getPossibleActions() {
        System.out.println("Riposa (R), Prega (P), Esci da qua (E)");
    }

//    @Override
//    public void getPossibleDirections() {
//    }

}
