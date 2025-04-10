package org.generation.italy.edenGame.room;

import java.util.Map;

public class MarketSquare extends Room{
    public MarketSquare(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("Un grande mercato, tanto chiasso e disordine, la gentre va e viene, si compra ma si lascia sempre qualcosa...");
    }

    @Override
    public void move() {

    }

//    @Override
//    public void getPossibleDirections() {

//    }
}
