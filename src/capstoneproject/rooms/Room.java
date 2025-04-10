package capstoneproject.rooms;


import capstoneproject.Directions;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Room {
    protected String name;
    private String description;
    protected Map<Directions, Room> exits;

    public Room(String name, String description){
        this.name=name;
        this.description = description;
        this.exits = new HashMap<>();

    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }

    public void addExit(Directions dir , Room exit){
        exits.put(dir, exit);
        exit.addExit(dir.getOpposite(),this);
    }

    public Optional<Room> getExitAt (Directions dir){
        Room destination = exits.get(dir);
        if(destination == null){
            return Optional.empty();
        }
        return Optional.of(destination);
    }


}
