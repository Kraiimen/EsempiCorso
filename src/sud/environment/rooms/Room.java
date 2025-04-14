package sud.environment.rooms;

import sud.actors.Actor;
import sud.environment.CardinalDirection;
import sud.items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Room {
    // /-----------/ CAMPI /-----------/
    private String name;
    private String content; //descrizione, npc, loot ecc

    //private List<String> menu;      //azioni possibili nella stanza
    private List<Actor> residents = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    private String description;
    //private String event;     FORSE?

    private double enemyZone;
    private double guardZone;

    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private List<Room> directions;

    public Room(String description) {
        this.description = description;
        directions = new ArrayList<Room>(4);
    }

    public Room(String description, Room north, Room east, Room south, Room west) {
        this.description = description;

        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;

        directions = new ArrayList<Room>(4);
        directions.add(north);
        directions.add(east);
        directions.add(south);
        directions.add(west);
    }

    public void enter(Actor a){
        residents.add(a);
    }
    public void leave(Actor a){
        residents.remove(a);
    }

    public Room getRoomByDirection(CardinalDirection direction){
        return switch (direction){
            case CardinalDirection.NORTH -> north;
            case CardinalDirection.EAST -> east;
            case CardinalDirection.SOUTH -> south;
            case CardinalDirection.WEST -> west;
            default -> null;
        };
    }

    public void setDirections(Room north, Room east, Room south, Room west) {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;

        directions = new ArrayList<Room>(4);
        directions.add(north);
        directions.add(east);
        directions.add(south);
        directions.add(west);
        var v = isAdjacent(this);
    }

    public boolean isAdjacent(Room r) {
        return directions.contains(r);
    }

    public Room getNorth() {
        return north;
    }
    public void setNorth(Room north) {
        this.north = north;
        directions.set(0, north);
    }

    public Room getEast() {
        return east;
    }
    public void setEast(Room east) {
        this.east = east;
        directions.set(1, east);
    }

    public Room getSouth() {
        return south;
    }
    public void setSouth(Room south) {
        this.south = south;
        directions.set(2, south);
    }

    public Room getWest() {
        return west;
    }
    public void setWest(Room west) {
        this.west = west;
        directions.set(3, west);
    }

    public List<Actor> getResidents() {
        return residents;
    }

    public List<Actor> getEnemies() {
        //TODO modificare il filter per prendere i nemici (e la lista visto che Actor non ha questo tipo di info)
        return residents.stream().filter(a -> true).collect(Collectors.toList());
    }

    public List<Actor> getMovables() {
        //TODO modificare il filter per prendere quelli che si possono spostare (e la lista visto che Actor non ha questo tipo di info)
        return residents.stream().filter(a -> true).collect(Collectors.toList());
    }

    public List<Item> getLoot() {
        return items;
    }

//    public List<String> getMenu() {
//        return menu;
//    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double isEnemyZone() {
        return enemyZone;
    }
    public double isGuardZone() {
        return guardZone;
    }

    public boolean hasResidents() {
        return residents != null && !residents.isEmpty();   //TODO devo controllare se la lista contiene solo null? ci devo pensare
    }
    public boolean hasItems() {
        return items != null && !items.isEmpty();   //TODO devo controllare se la lista contiene solo null? ci devo pensare
    }
    public boolean hasEnemies() {
        return residents != null && residents.stream().anyMatch(a -> true);
    }
}
