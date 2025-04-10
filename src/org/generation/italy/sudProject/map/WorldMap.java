package org.generation.italy.sudProject.map;

import java.util.LinkedList;

public class WorldMap {
    // /--ATTRIBUTES--/
    private LinkedList<Room> world;

    // /--CONSTRUCTORS--/
    public WorldMap(){
        world = new LinkedList<>();
        world.offer(new Room("Temple_Square",false, true,true, false));
        world.offer(new Room("Market_Square",true, true,true, true));
        world.offer(new Room("Temple",false, false,false, true));
        world.offer(new Room("Bakery",false, false,false, true));
        world.offer(new Room("Armory",false, false,true, false));
        world.offer(new Room("Garden_1",true, true,false, false));
        world.offer(new Room("Garden_2",true, true,false, false));
        world.offer(new Room("Garden_3",true, true,false, false));
        world.offer(new Room("Woods",true, false,false, false));
    }




    // /--METHODS--/
}
