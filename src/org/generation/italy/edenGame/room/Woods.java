package org.generation.italy.edenGame.room;

import java.util.Map;

public class Woods extends Room{
    public Woods(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("Non sai cosa troverai, puoi solo sperare di poterlo raccontare ");
        System.out.println(" ");
    }

    @Override
    public void move() {

    }

//    @Override
//    public void getPossibleDirections() {
//
//    }
}
