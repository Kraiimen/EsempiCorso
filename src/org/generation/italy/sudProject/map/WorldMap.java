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
        //crea le stanze
        world.add(new Room("Temple_Square"));
        world.add(new Room("Market_Square"));
        world.add(new Room("Temple"));
        world.add(new Room("Bakery"));
        world.add(new Room("Armory"));
        world.add(new Room("Garden_1"));
        world.add(new Room("Garden_2"));
        world.add(new Room("Garden_3"));
        world.add(new Room("Woods"));
        //aggiunge le stanze adiacenti
        world.get(TEMPLE_SQUARE_INDEX).setRooms(null, world.get(MARKET_SQUARE_INDEX), world.get(TEMPLE_INDEX), null);
        world.get(MARKET_SQUARE_INDEX).setRooms(world.get(TEMPLE_SQUARE_INDEX), world.get(GARDEN_1_INDEX), world.get(BAKERY_INDEX), world.get(ARMORY_INDEX));
        world.get(TEMPLE_INDEX).setRooms(null, null, null, world.get(TEMPLE_SQUARE_INDEX));
        world.get(BAKERY_INDEX).setRooms(null, null, null, world.get(MARKET_SQUARE_INDEX));
        world.get(ARMORY_INDEX).setRooms(null, null, world.get(MARKET_SQUARE_INDEX), null);
        world.get(GARDEN_1_INDEX).setRooms(world.get(MARKET_SQUARE_INDEX), world.get(GARDEN_2_INDEX), null, null);
        world.get(GARDEN_2_INDEX).setRooms(world.get(GARDEN_1_INDEX), world.get(GARDEN_3_INDEX), null, null);
        world.get(GARDEN_3_INDEX).setRooms(world.get(GARDEN_2_INDEX), world.get(WOODS_INDEX), null, null);
        world.get(WOODS_INDEX).setRooms(world.get(GARDEN_3_INDEX), null, null, null);
        //aggiunge la descrizione a ciascuna stanza
        world.get(TEMPLE_SQUARE_INDEX).setRoomDescription("Una grande piazza, con al centro una statua raffigurante una divinità cara al popolo di Moonveil");
        world.get(MARKET_SQUARE_INDEX).setRoomDescription("Un mercato povero di negozianti, ma ricco di banditi");
        world.get(TEMPLE_INDEX).setRoomDescription("Uno dei più grandi della storia. Un luogo di preghiera per chi cerca perdono, ma anche un tetto sulla testa");
        world.get(BAKERY_INDEX).setRoomDescription("Il forno dedicato alla sacra divinità della città, si presenta come un luogo buio, ma almeno qui un pezzo di pane si trova, se riesci a permettertelo");
        world.get(ARMORY_INDEX).setRoomDescription("Nulla è meglio di una lama per sgozzare chi detesti, se cerchi questa o protezione, allora sei nel posto giusto!");
        world.get(GARDEN_1_INDEX).setRoomDescription("I Giardini si presentano come un luogo deserto, il sole non raggiunge mai questo luogo avvolto dal mistero");
        world.get(GARDEN_2_INDEX).setRoomDescription("Il centro dei Giardini presenta un pozzo, dove in parecchi sono rimasti vittime di caduta. Nessuno sa quanto sia profondo");
        world.get(GARDEN_3_INDEX).setRoomDescription("La fine dei Giardini, ma anche l'inizio per chi entra per la prima volta in città");
        world.get(WOODS_INDEX).setRoomDescription("Un bosco illuminato dalla luna, la tua unica fonte di luce. Il fuoco è inutilizzabile per via di una maledizione");
    }
}