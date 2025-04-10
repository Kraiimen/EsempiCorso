package org.generation.italy.edenGame.room;

import java.util.Map;

public class Temple extends Room{

    public Temple(String name, Map<Compass, Room> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
    }

//    @Override
//    public void getPossibleDirections() {
//    }

}
