package org.generation.italy.edenGame.room;

import java.util.Map;

public class Armory extends Room{
    public Armory(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("Un luogo dove le armi vengono forgiate, vendute e comprate... ma anche trovate ");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(" ");
    }



    @Override
    public void getPossibleActions() {
        System.out.println("Attacca (A), Ruba (St), Compra (B), Esci di qui (E)");
    }

//    @Override
//    public void getPossibleDirections() {
//
//    }
}
