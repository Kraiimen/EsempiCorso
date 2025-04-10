package org.generation.italy.sudProject.map;

import java.util.ArrayList;
import java.util.HashMap;


public class WorldMap {
    // /--ATTRIBUTES--/
    public static ArrayList<Room> world;

    public static final int TEMPLE_SQUARE_INDEX = 0;
    public static final int MARKET_SQUARE_INDEX = 1;
    public static final int TEMPLE_INDEX = 2;
    public static final int BAKERY_INDEX = 3;
    public static final int ARMORY_INDEX = 4;
    public static final int GARDEN_1_INDEX = 5;
    public static final int GARDEN_2_INDEX = 6;
    public static final int GARDEN_3_INDEX = 7;
    public static final int WOODS_INDEX = 8;

    // /--CONSTRUCTORS--/
    public WorldMap(){
        world.add(new Room("Temple_Square"));
        world.add(new Room("Market_Square"));
        world.add(new Room("Temple"));
        world.add(new Room("Bakery"));
        world.add(new Room("Armory"));
        world.add(new Room("Garden_1"));
        world.add(new Room("Garden_2"));
        world.add(new Room("Garden_3"));
        world.add(new Room("Woods"));

        world.get(TEMPLE_SQUARE_INDEX).setRooms(null, world.get(MARKET_SQUARE_INDEX), world.get(TEMPLE_INDEX), null);
        world.get(MARKET_SQUARE_INDEX).setRooms(world.get(TEMPLE_SQUARE_INDEX), world.get(GARDEN_1_INDEX), world.get(BAKERY_INDEX), world.get(ARMORY_INDEX));
        world.get(TEMPLE_INDEX).setRooms(null, null, null, world.get(TEMPLE_SQUARE_INDEX));
        world.get(BAKERY_INDEX).setRooms(null, null, null, world.get(MARKET_SQUARE_INDEX));
        world.get(ARMORY_INDEX).setRooms(null, null, world.get(MARKET_SQUARE_INDEX), null);
        world.get(GARDEN_1_INDEX).setRooms(world.get(MARKET_SQUARE_INDEX), world.get(GARDEN_2_INDEX), null, null);
        world.get(GARDEN_2_INDEX).setRooms(world.get(GARDEN_1_INDEX), world.get(GARDEN_3_INDEX), null, null);
        world.get(GARDEN_3_INDEX).setRooms(world.get(GARDEN_2_INDEX), world.get(WOODS_INDEX), null, null);
        world.get(WOODS_INDEX).setRooms(world.get(GARDEN_3_INDEX), null, null, null);
    }
}