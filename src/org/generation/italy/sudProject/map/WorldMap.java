package org.generation.italy.sudProject.map;

import java.util.ArrayList;
import java.util.HashMap;


public class WorldMap {
    // /--ATTRIBUTES--/
    private static ArrayList<Room> rooms;
    public static HashMap<Room, ArrayList<Room>> world;

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
        rooms = new ArrayList<>();
        rooms.add(new Room("Temple_Square"));
        rooms.add(new Room("Market_Square"));
        rooms.add(new Room("Temple"));
        rooms.add(new Room("Bakery"));
        rooms.add(new Room("Armory"));
        rooms.add(new Room("Garden_1"));
        rooms.add(new Room("Garden_2"));
        rooms.add(new Room("Garden_3"));
        rooms.add(new Room("Woods"));

        //NORD 0, SUD 1, EST 2, OVEST 3
        //stanza Temple_Square
        world.put(rooms.get(TEMPLE_SQUARE_INDEX), new ArrayList<Room>());
        world.get(TEMPLE_SQUARE_INDEX).add(null);
        world.get(TEMPLE_SQUARE_INDEX).add(rooms.get(MARKET_SQUARE_INDEX));
        world.get(TEMPLE_SQUARE_INDEX).add(rooms.get(TEMPLE_INDEX));
        world.get(TEMPLE_SQUARE_INDEX).add(null);

        //stanza Market_Square
        world.put(rooms.get(MARKET_SQUARE_INDEX), new ArrayList<Room>());
        world.get(MARKET_SQUARE_INDEX).add(rooms.get(TEMPLE_SQUARE_INDEX));
        world.get(MARKET_SQUARE_INDEX).add(rooms.get(GARDEN_1_INDEX));
        world.get(MARKET_SQUARE_INDEX).add(rooms.get(BAKERY_INDEX));
        world.get(MARKET_SQUARE_INDEX).add(null);

        //stanza Temple
        world.put(rooms.get(TEMPLE_INDEX), new ArrayList<Room>());
        world.get(TEMPLE_INDEX).add(null);
        world.get(TEMPLE_INDEX).add(null);
        world.get(TEMPLE_INDEX).add(null);
        world.get(TEMPLE_INDEX).add(rooms.get(TEMPLE_SQUARE_INDEX));

        //stanza Bakery
        world.put(rooms.get(BAKERY_INDEX), new ArrayList<Room>());
        world.get(BAKERY_INDEX).add(null);
        world.get(BAKERY_INDEX).add(null);
        world.get(BAKERY_INDEX).add(null);
        world.get(BAKERY_INDEX).add(rooms.get(MARKET_SQUARE_INDEX));

        //stanza Armory
        world.put(rooms.get(ARMORY_INDEX), new ArrayList<Room>());
        world.get(ARMORY_INDEX).add(null);
        world.get(ARMORY_INDEX).add(null);
        world.get(ARMORY_INDEX).add(rooms.get(MARKET_SQUARE_INDEX));
        world.get(ARMORY_INDEX).add(null);

        //stanza Garden_1
        world.put(rooms.get(GARDEN_1_INDEX), new ArrayList<Room>());
        world.get(GARDEN_1_INDEX).add(rooms.get(MARKET_SQUARE_INDEX));
        world.get(GARDEN_1_INDEX).add(rooms.get(GARDEN_2_INDEX));
        world.get(GARDEN_1_INDEX).add(null);
        world.get(GARDEN_1_INDEX).add(null);

        //stanza Garden_2
        world.put(rooms.get(GARDEN_2_INDEX), new ArrayList<Room>());
        world.get(GARDEN_2_INDEX).add(rooms.get(GARDEN_1_INDEX));
        world.get(GARDEN_2_INDEX).add(rooms.get(GARDEN_3_INDEX));
        world.get(GARDEN_2_INDEX).add(null);
        world.get(GARDEN_2_INDEX).add(null);

        //stanza Garden_3
        world.put(rooms.get(GARDEN_3_INDEX), new ArrayList<Room>());
        world.get(GARDEN_3_INDEX).add(rooms.get(GARDEN_2_INDEX));
        world.get(GARDEN_3_INDEX).add(rooms.get(WOODS_INDEX));
        world.get(GARDEN_3_INDEX).add(null);
        world.get(GARDEN_3_INDEX).add(null);

        //stanza Woods
        world.put(rooms.get(WOODS_INDEX), new ArrayList<Room>());
        world.get(WOODS_INDEX).add(rooms.get(GARDEN_3_INDEX));
        world.get(WOODS_INDEX).add(null);
        world.get(WOODS_INDEX).add(null);
        world.get(WOODS_INDEX).add(null);
    }
}