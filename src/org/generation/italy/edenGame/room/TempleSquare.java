package org.generation.italy.edenGame.room;

import java.util.Map;

public class TempleSquare extends Room{


    public TempleSquare(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("Una piazza sacra, al centro della cittadella, pieno di persone e di storie ");
    }

    @Override
    public void move() {

    }

//    @Override
//    public void getPossibleDirections(Map<Compass, Room> directions) {
//        if(directions.get(nextRoom) != null) {
//            this.directions = directions;
//            System.out.println("Le strade da qui portano a: " + directions);
//        }

//    }
}
