package org.generation.italy.edenGame.room;

import java.util.Map;

public class Gardens extends Room{
    public Gardens(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("I giardini, fioriti e colorati, il vanto della casata reale ");
    }

    @Override
    public void move() {

    }

//    @Override
//    public void getPossibleDirections() {
//
//    }
}
