package mud.rooms;

import mud.CardinalPoints;
import mud.characters.Entity;
import mud.characters.fightable.monsters.Monster;
import mud.items.Item;

import java.util.*;
import java.util.stream.Collectors;

import static mud.GameUtil.player;

public abstract class Room {
    //field
    private String name;
    private HashMap<CardinalPoints, Room> directions;
    private HashMap<String, Entity> presentEntities;
    private List<Monster> presentMonsters;
    private List<String> presentMonstersClasses;
    private List<Item> presentItems;

    //costruttore
    public Room(String name){
        this.name = name;
        directions = new HashMap<>();
        presentEntities = new HashMap<>();
        presentItems = new ArrayList<>();
        presentMonsters = new ArrayList<>();
        presentMonstersClasses = new ArrayList<>();
    }
    //costruttore per l'ultimo garden
    public Room(String name, Room lastRoom) {
        this(name);
        directions.put(CardinalPoints.SOUTH, lastRoom);
    }

    //funzioni principali
    public void enterInRoom(Entity entity) {
        entity.setActualRoom(this);
    }
    public void leaveRoom(Entity entity) {
            presentEntities.remove(name);
    }

    public void changeRoomNPC(CardinalPoints cardinal, Entity entity){
        if(directions.containsKey(cardinal)) {
            leaveRoom(entity);
            directions.get(cardinal).enterInRoom(entity);
        }
    }

    //funziona ma era meglio metterlo in player direttamente
//    public void changeRoomPlayer(CardinalPoints cardinal, Entity entity){
//        if(directions.containsKey(cardinal)) {
//            leaveRoom(entity);
//            directions.get(cardinal).enterInRoom(entity);
//            this.printEntrance();
//        } else {
//            System.out.println("The road is closed. You're still at " + name);
//        }
//    }

    public abstract void printEntrance();

    public void printEntities(){
        Set<String> printable = new HashSet<>(presentEntities.keySet());
        printable.remove(player.getName());
        if(printable.isEmpty()){
            System.out.println("Looks like you're the only one around here right now");
        } else{
            System.out.println("In here there are some other creatures: ");
            printable.forEach(e -> System.out.println(e + " the " + presentEntities.get(e).getClass().getSimpleName()));
        }
    }

    //getter e setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public HashMap<CardinalPoints, Room> getDirections() {
        return directions;
    }
    public void setDirections(HashMap<CardinalPoints, Room> directions) {
        this.directions = directions;
    }

    public HashMap<String, Entity> getPresentEntities() {
        return presentEntities;
    }
    public void setPresentEntities(HashMap<String, Entity> presentEntities) {
        this.presentEntities = presentEntities;
    }

    public List<Item> getPresentItems() {
        return presentItems;
    }
    public void setPresentItems(List<Item> presentItems) {
        this.presentItems = presentItems;
    }

    public List<Monster> getPresentMonsters() {
        return presentMonsters;
    }
    public void setPresentMonsters(List<Monster> presentMonsters) {
        this.presentMonsters = presentMonsters;
    }

    public List<String> getPresentMonstersClasses() {
        return presentMonstersClasses;
    }
    public void setPresentMonstersClasses(List<String> presentMonstersClasses) {
        this.presentMonstersClasses = presentMonstersClasses;
    }
}
