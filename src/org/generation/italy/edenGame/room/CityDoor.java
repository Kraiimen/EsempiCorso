package org.generation.italy.edenGame.room;

import java.util.Map;

public class CityDoor extends Room{
    public CityDoor(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("Questa è la grande porta della città di Eden, da qui in poi regna l'oscuro... ");
    }

    @Override
    public void move() {

    }

//    @Override
//    public void getPossibleDirections() {
//
//    }
}
