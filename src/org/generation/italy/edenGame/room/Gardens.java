package org.generation.italy.edenGame.room;

import java.util.Map;

public class Gardens extends Room{
    public Gardens(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("I giardini, fioriti e colorati, il vanto della casata reale ");
        System.out.println("------------------------------------------------------------");
        System.out.println(" ");
    }



    @Override
    public void getPossibleActions() {
        System.out.println("Attacca (A), Cerca (C), Riposa (R), Esci da qui (E)");
    }

//    @Override
//    public void getPossibleDirections() {
//
//    }
}
