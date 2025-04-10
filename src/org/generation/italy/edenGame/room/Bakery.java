package org.generation.italy.edenGame.room;

import java.util.Map;

public class Bakery extends Room{
    public Bakery(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("Una pannetteria dove i più affamati possono ristorare, il profumo di pane ti aiuterà a ritrovare le tue forze ");
        System.out.println(" ");
    }
    @Override
    public void move() {

    }
}
