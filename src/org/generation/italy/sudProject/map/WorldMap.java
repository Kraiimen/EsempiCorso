package org.generation.italy.sudProject.map;

import org.generation.italy.sudProject.Entity;
import org.generation.italy.sudProject.Spawner;
import org.generation.italy.sudProject.entities.npcTypes.npcs.Baker;
import org.generation.italy.sudProject.entities.npcTypes.npcs.Blacksmith;
import org.generation.italy.sudProject.entities.npcTypes.npcs.MoonPriest;

import java.util.ArrayList;

import static org.generation.italy.sudProject.Spawner.addNewEntityType;
import static org.generation.italy.sudProject.map.Room.ROOM_MAIN_NPC_INDEX;


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
        world.add(new Room("Temple_Square", 3));
        world.add(new Room("Market_Square", 4));
        world.add(new Room("Temple", 0));
        world.add(new Room("Bakery", 2));
        world.add(new Room("Armory", 2));
        world.add(new Room("Garden_1", 2));
        world.add(new Room("Garden_2", 1));
        world.add(new Room("Garden_3", 2));
        world.add(new Room("Woods", 0));
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
        //aggiunge entità generiche in ciascuna stanza
        Spawner.generateRoomEntities(world.get(TEMPLE_SQUARE_INDEX), 3, 0);
        Spawner.generateRoomEntities(world.get(MARKET_SQUARE_INDEX), 3, 0);
        Spawner.generateRoomEntities(world.get(TEMPLE_INDEX), 0,0);
        Spawner.generateRoomEntities(world.get(BAKERY_INDEX), 0,0);
        Spawner.generateRoomEntities(world.get(ARMORY_INDEX), 0,0);
        Spawner.generateRoomEntities(world.get(GARDEN_1_INDEX), 3,0);
        Spawner.generateRoomEntities(world.get(GARDEN_2_INDEX), 3,0);
        Spawner.generateRoomEntities(world.get(GARDEN_3_INDEX), 3,0);
        Spawner.generateRoomEntities(world.get(WOODS_INDEX), 0,3);
        //aggiunge entità uniche alle stanze
        addNewEntityType(world.get(TEMPLE_INDEX));
        world.get(TEMPLE_INDEX).getRoomEntities().get(ROOM_MAIN_NPC_INDEX).add(new MoonPriest("Moon_Priest", world.get(TEMPLE_INDEX), ROOM_MAIN_NPC_INDEX));

        addNewEntityType(world.get(ARMORY_INDEX));
        world.get(ARMORY_INDEX).getRoomEntities().get(ROOM_MAIN_NPC_INDEX).add(new Blacksmith("Blacksmith", world.get(ARMORY_INDEX), ROOM_MAIN_NPC_INDEX));

        addNewEntityType(world.get(BAKERY_INDEX));
        world.get(BAKERY_INDEX).getRoomEntities().get(ROOM_MAIN_NPC_INDEX).add(new Baker("Baker", world.get(BAKERY_INDEX), ROOM_MAIN_NPC_INDEX));
    }
}