package edoardo.projectMud;

import edoardo.projectMud.player.Player;
import edoardo.projectMud.rooms.*;

import java.util.HashSet;
import java.util.Random;

public class Randomizer {
    static private final Random RANDOM = new Random();


    public void randomizeRooms(Room room,HashSet<Room> visitedRooms){
//randomizza la stanza se i nodi a cui punta sono null e non fa parte delle stanze iniziale nè di quelle gia visitate
        int size = DungeonManager.initialAvailableRooms.size();
        boolean roomIsInTheInitialSetupOfTheDungeon = room.getIsInTheInitialSetupOfTheDungeon();
        if(!roomIsInTheInitialSetupOfTheDungeon){
            if(!visitedRooms.contains(room.getNordRoom())){
                room.setNordRoom(randomizeSingleRoom(room, DungeonManager.initialAvailableRooms.get(RANDOM.nextInt(size)), Directions.values()[0])  );
            }
            if(!visitedRooms.contains(room.getEstRoom())) {
                room.setEstRoom(randomizeSingleRoom(room,DungeonManager.initialAvailableRooms.get(RANDOM.nextInt(size)),Directions.values()[1]));
            }
            if(!visitedRooms.contains(room.getOvestRoom())) {
                room.setOvestRoom(randomizeSingleRoom(room,DungeonManager.initialAvailableRooms.get(RANDOM.nextInt(size)),Directions.values()[2]));
            }
            if(!visitedRooms.contains(room.getNordRoom())) {
                room.setSudRoom(randomizeSingleRoom(room,DungeonManager.initialAvailableRooms.get(RANDOM.nextInt(size)),Directions.values()[3]));
            }
        }
    }
    private Room randomizeSingleRoom(Room room,PossibleRooms nextRoom, Directions dir) {
        if(room.isGardenAndDirectionIsSud(dir)){
            if(Gardens.getCounterSudGardens() < 5) { //il player deve andare 5 volte a sud e attraversando giardini per avere la possibilità di sbloccare le city Doors
                if (Player.getBackLogDirections().getLast() == dir){
                    Gardens.updateCounterSudGardens();
                    return new Gardens(dir, room);
                } else {
                    return new Gardens(dir, room);
                }
            } else{
                if(RANDOM.nextBoolean()){
                    return new CityDoors(dir, room);
                }
            }
        } else if (room.getClass() == CityDoors.class || room.getClass() == Woods.class) {
            return new Woods(dir, room);
        }

        switch (nextRoom){
            case ARMORY:
                return new Armory(dir, room);

//            case CITYDOORS:
//                return new CityDoors(dir, this);

            case BAKERY:
                return new Bakery(dir, room);

            case GARDENS:
                return new Gardens(dir, room);

            case MARKETSQUARE:
                return new MarketSquare(dir, room);

            case TEMPLE:
                return new Temple(dir, room);

            case TEMPLESQUARE:
                return new TempleSquare(dir, room);

//            case WOODS:
//                return new Woods(dir, this);

            case NULL:
                return null;


        }
        return null;
    }
}
