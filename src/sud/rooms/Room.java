package sud.rooms;

import sud.items.*;
import sud.entity.*;
import java.util.*;

public class Room {
    private String name;
    private Room nordPath,sudPath,westPath,eastPath;
    private boolean hasItems, hasNPC, hasGuards, hasCritters, hasMOBS;
    private ArrayList<Item> itemsInRoom;
    private ArrayList<Entity> MOBSInRoom, guardsInRoom, crittersInRoom;
    private Set<Entity> NPCInRoom;
    private static Map<String,Room> roomMap = new HashMap();

    static {
        Room debugroom = new Room("debroom");

        Room castle = new Room("castle");
        roomMap.put("castle",castle);
        Room prison = new Room("prison");
        roomMap.put("prison",prison);
        Room temple = new Room("temple");
        roomMap.put("temple", temple);
        Room templeSq = new Room("templeSquare");
        roomMap.put("templeSquare", templeSq);
        Room market = new Room("market");
        roomMap.put("market", market);
        Room forge = new Room("forge");
        roomMap.put("forge", forge);
        Room backery = new Room("backery");
        roomMap.put("backery", backery);
        Room alchemist = new Room("alchemist");
        roomMap.put("alchemist", alchemist);
        Room fieldsN = new Room("fieldsN");
        roomMap.put("fieldsN", fieldsN);
        Room fieldsS = new Room("fieldsS");
        roomMap.put("fieldsS", fieldsS);
        Room forest = new Room("forest");
        roomMap.put("forest", forest);
        Room bossRoom = new Room("bossRoom");
        roomMap.put("bossRoom", bossRoom);

        castle.setPaths(debugroom, templeSq, prison, debugroom);
        castle.setRoomProperties(false, true, true, false, false);

        prison.setPaths(debugroom, debugroom, debugroom, castle);
        prison.setRoomProperties(false, true, true, false, false);

        templeSq.setPaths(debugroom, market, debugroom, temple);
        templeSq.setRoomProperties(false, true, true, false, false);

        temple.setPaths(debugroom, debugroom, templeSq, debugroom);
        temple.setRoomProperties(false, true, true, false, false);

        market.setPaths(templeSq, fieldsN, forge, backery);
        market.setRoomProperties(true, true, true, false, false);

        backery.setPaths(debugroom, debugroom, market, debugroom);
        backery.setRoomProperties(true, true, true, false, false);

        forge.setPaths(debugroom, alchemist, debugroom, market);
        forge.setRoomProperties(true, true, true, false, false);

        alchemist.setPaths(forge, debugroom, debugroom, debugroom);
        alchemist.setRoomProperties(true, true, true, false, false);

        fieldsN.setPaths(market, fieldsS, debugroom, debugroom);
        fieldsN.setRoomProperties(true, false, false, true, false);

        fieldsS.setPaths(fieldsN, forest, debugroom, debugroom);
        fieldsS.setRoomProperties(true, false, false, false, true);

        forest.setPaths(fieldsS, debugroom, debugroom, bossRoom);
        forest.setRoomProperties(true, false, false, false, true);

        bossRoom.setPaths(debugroom, debugroom, forest, debugroom);
        bossRoom.setRoomProperties(true, false, false, false, true);
    }

    public Room(String name, Room nordPath, Room sudPath, Room westPath, Room eastPath, boolean hasItems, boolean hasNPC, boolean hasGuards, boolean hasCritters, boolean hasMOBS, ArrayList<Item> itemsInRoom, ArrayList<Entity> MOBSInRoom, ArrayList<Entity> guardsInRoom, ArrayList<Entity> crittersInRoom, Set<Entity> NPCInRoom) {
        this.name = name;
        this.nordPath = nordPath;
        this.sudPath = sudPath;
        this.westPath = westPath;
        this.eastPath = eastPath;
        this.hasItems = hasItems;
        this.hasNPC = hasNPC;
        this.hasGuards = hasGuards;
        this.hasCritters = hasCritters;
        this.hasMOBS = hasMOBS;
        this.itemsInRoom = itemsInRoom;
        this.MOBSInRoom = MOBSInRoom;
        this.guardsInRoom = guardsInRoom;
        this.crittersInRoom = crittersInRoom;
        this.NPCInRoom = NPCInRoom;
    }

    public Room(String name) {
        this.name = name;
        this.itemsInRoom = new ArrayList<>();
        this.MOBSInRoom = new ArrayList<>();
        this.guardsInRoom = new ArrayList<>();
        this.crittersInRoom = new ArrayList<>();
        this.NPCInRoom = new HashSet<>();
    }

    public void setPaths(Room nord, Room sud, Room west, Room east) {
        this.nordPath = nord;
        this.sudPath = sud;
        this.westPath = west;
        this.eastPath = east;
    }

    public void setRoomProperties(boolean hasItems, boolean hasNPC, boolean hasGuards, boolean hasCritters, boolean hasMOBS) {
        this.hasItems = hasItems;
        this.hasNPC = hasNPC;
        this.hasGuards = hasGuards;
        this.hasCritters = hasCritters;
        this.hasMOBS = hasMOBS;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Room getNordPath() {
        return nordPath;
    }
    public void setNordPath(Room nordPath) {
        this.nordPath = nordPath;
    }

    public Room getSudPath() {
        return sudPath;
    }
    public void setSudPath(Room sudPath) {
        this.sudPath = sudPath;
    }

    public Room getWestPath() {
        return westPath;
    }
    public void setWestPath(Room westPath) {
        this.westPath = westPath;
    }

    public Room getEastPath() {
        return eastPath;
    }
    public void setEastPath(Room eastPath) {
        this.eastPath = eastPath;
    }

    public boolean isHasItems() {
        return hasItems;
    }
    public void setHasItems(boolean hasItems) {
        this.hasItems = hasItems;
    }

    public boolean isHasNPC() {
        return hasNPC;
    }
    public void setHasNPC(boolean hasNPC) {
        this.hasNPC = hasNPC;
    }

    public boolean isHasGuards() {
        return hasGuards;
    }
    public void setHasGuards(boolean hasGuards) {
        this.hasGuards = hasGuards;
    }

    public boolean isHasCritters() {
        return hasCritters;
    }
    public void setHasCritters(boolean hasCritters) {
        this.hasCritters = hasCritters;
    }

    public boolean isHasMOBS() {
        return hasMOBS;
    }
    public void setHasMOBS(boolean hasMOBS) {
        this.hasMOBS = hasMOBS;
    }

    public ArrayList<Item> getItemsInRoom() {
        return itemsInRoom;
    }
    public void setItemsInRoom(ArrayList<Item> itemsInRoom) {
        this.itemsInRoom = itemsInRoom;
    }

    public ArrayList<Entity> getMOBSInRoom() {
        return MOBSInRoom;
    }
    public void setMOBSInRoom(ArrayList<Entity> MOBSInRoom) {
        this.MOBSInRoom = MOBSInRoom;
    }

    public ArrayList<Entity> getGuardsInRoom() {
        return guardsInRoom;
    }
    public void setGuardsInRoom(ArrayList<Entity> guardsInRoom) {
        this.guardsInRoom = guardsInRoom;
    }

    public ArrayList<Entity> getCrittersInRoom() {
        return crittersInRoom;
    }
    public void setCrittersInRoom(ArrayList<Entity> crittersInRoom) {
        this.crittersInRoom = crittersInRoom;
    }

    public Set<Entity> getNPCInRoom() {
        return NPCInRoom;
    }
    public void setNPCInRoom(Set<Entity> NPCInRoom) {
        this.NPCInRoom = NPCInRoom;
    }

    static public Room getRoomPointerFromName (String name){
        return roomMap.get(name);
    }
}
