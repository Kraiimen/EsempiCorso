package edoardo.projectMud.rooms;

import edoardo.projectMud.Directions;
import edoardo.projectMud.DungeonManager;
import edoardo.projectMud.items.Item;
import edoardo.projectMud.npc.NpcClasses;
import edoardo.projectMud.player.Player;
import edoardo.projectMud.npc.*;

import java.util.*;

public abstract class Room {
    static private final Random RANDOM = new Random();
    static private final int MAX_NPC_AT_ROOM = 4;
    private static final PossibleRooms[] possibleRooms = PossibleRooms.values();
    private String name;
    private String description;
    private ArrayList< Npc> npcs;
    private ArrayList<Item> items;
    private Room nordRoom;
    private Room estRoom;
    private Room ovestRoom;
    private Room sudRoom;
    private boolean isInTheInitialSetupOfTheDungeon;


    public Room(){
    }
    public Room(Directions dir, Room r){
        switch (dir){
            case NORD -> sudRoom = r;
            case EST -> ovestRoom = r;
            case OVEST -> estRoom = r;
            case SUD -> nordRoom = r;
        }
    }
    public Room(boolean isInTheInitialSetupOfTheDungeon){
        this.isInTheInitialSetupOfTheDungeon = isInTheInitialSetupOfTheDungeon;
    }
    public Room(Room nordRoom, Room estRoom, Room ovestRoom, Room sudRoom) {
        this.nordRoom = nordRoom;
        this.estRoom = estRoom;
        this.ovestRoom = ovestRoom;
        this.sudRoom = sudRoom;
        isInTheInitialSetupOfTheDungeon = true;
    }
    @Override
    public String toString() {
        //String directions = "A nord "+ nordRoom.getName() + "\n" + "A Est "+ estRoom.getName() + "\n" + "A Ovest "+ this.ovestRoom.getName() + "\n" + "A Sud "+ this.sudRoom.getName() + "\n";
        return name + "\n" + description +"\n";

    }
    protected abstract void initialize();

    private void randomizeNpcInRoom(HashSet<Room> visitedRooms){

         if(!visitedRooms.contains(this)){
             int numberNpcs = RANDOM.nextInt(MAX_NPC_AT_ROOM);
             for(int i = 0; i < numberNpcs; i++){
                 int randomNpc = RANDOM.nextInt(NpcClasses.values().length);
                 if (randomNpc <= 2){
                    npcs.add(new Cat());
                 } else {
                     npcs.add(new Guard());
                 }

             }
         }
     }

    public void randomizeRooms(HashSet<Room> visitedRooms){
//randomizza la stanza se i nodi a cui punta sono null e non fa parte delle stanze iniziale nè di quelle gia visitate
        int size = DungeonManager.initialAvailableRooms.size();
        if(!isInTheInitialSetupOfTheDungeon){
            if (!visitedRooms.contains(nordRoom)){
                nordRoom = randomizeSingleRoom( DungeonManager.initialAvailableRooms.get(RANDOM.nextInt(size)), Directions.values()[0]);
            }
            if(!visitedRooms.contains(estRoom)){
                estRoom = randomizeSingleRoom(DungeonManager.initialAvailableRooms.get(RANDOM.nextInt(size)),Directions.values()[1]);
            }
            if(!visitedRooms.contains(ovestRoom)){
                ovestRoom = randomizeSingleRoom( DungeonManager.initialAvailableRooms.get(RANDOM.nextInt(size)),Directions.values()[2]);
            }
            if(!visitedRooms.contains(sudRoom)){
                sudRoom = randomizeSingleRoom( DungeonManager.initialAvailableRooms.get(RANDOM.nextInt(size)),Directions.values()[3]);
            }
        }

    }

    public boolean isGardenAndDirectionIsSud(Directions dir){
        return this.getClass() == Gardens.class && dir == Directions.SUD;
    }
//ARMORY, CITYDOORS, BAKERY, GARDENS, MARKETSQUARE, TEMPLE, TEMPLESQUARE, WOODS, NULL
    private Room randomizeSingleRoom( PossibleRooms nextRoom, Directions dir) {
        if(isGardenAndDirectionIsSud(dir)){
            if(Gardens.getCounterSudGardens() < 5) { //il player deve andare 5 volte a sud e attraversando giardini per avere la possibilità di sbloccare le city Doors
                if (Player.getBackLogDirections().getLast() == dir){
                    Gardens.updateCounterSudGardens();
                    return new Gardens(dir, this);
                } else {
                    return new Gardens(dir, this);
                }
            } else{
                if(RANDOM.nextBoolean()){
                    return new CityDoors(dir, this);
                }
            }
        } else if (this.getClass() == CityDoors.class || this.getClass() == Woods.class) {
            return new Woods(dir, this);
        }

        switch (nextRoom){
            case ARMORY:
                return new Armory(dir, this);

//            case CITYDOORS:
//                return new CityDoors(dir, this);

            case BAKERY:
                return new Bakery(dir, this);

            case GARDENS:
                return new Gardens(dir, this);

            case MARKETSQUARE:
                return new MarketSquare(dir, this);

            case TEMPLE:
                return new Temple(dir, this);

            case TEMPLESQUARE:
                return new TempleSquare(dir, this);

//            case WOODS:
//                return new Woods(dir, this);

            case NULL:
                return null;


        }
        return null;
    }
    public String getNotNullPath(){
        String notNullPath = "";
        if (nordRoom!= null){
            notNullPath+= "NORD - " + nordRoom.name+ "\n";
        }
        if (estRoom!= null){
            notNullPath+= "EST - " + estRoom.name+ "\n";
        }
        if (ovestRoom != null){
            notNullPath+= "OVEST - " +ovestRoom.name+ "\n";
        }
        if (sudRoom != null){
            notNullPath+= "SUD - " + sudRoom.name+ "\n";
        }
        return notNullPath;
    }

    public void setNordRoom(Room nordRoom) {
        this.nordRoom = nordRoom;
    }

    public void setOvestRoom(Room ovestRoom) {
        this.ovestRoom = ovestRoom;
    }

    public void setSudRoom(Room sudRoom) {
        this.sudRoom = sudRoom;
    }

    public void setEstRoom(Room estRoom) {
        this.estRoom = estRoom;
    }

    public Room getNordRoom() {
        return nordRoom;
    }

    public Room getEstRoom() {
        return estRoom;
    }

    public Room getOvestRoom() {
        return ovestRoom;
    }

    public Room getSudRoom() {
        return sudRoom;
    }

    public String getDescription() {
        return description;
    }
    public String getName(){
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsInTheInitialSetupOfTheDungeon() {
        return isInTheInitialSetupOfTheDungeon;
    }
}
