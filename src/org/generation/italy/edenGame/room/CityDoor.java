package org.generation.italy.edenGame.room;

import java.util.Map;

public class CityDoor extends Room{
    public CityDoor(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("Questa è la grande porta della città di Eden, da qui in poi regna l'oscuro... ");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(" ");
    }


    @Override
    public void getPossibleActions() {
        System.out.println("Attacca (A), Esci di qui (E)");
    }

//    @Override
//    public void getPossibleDirections() {
//
//    }
}
