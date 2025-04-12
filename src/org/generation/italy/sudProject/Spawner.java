package org.generation.italy.sudProject;

import org.generation.italy.sudProject.entities.mobTypes.mobs.Cat;
import org.generation.italy.sudProject.entities.mobTypes.mobs.Cultist;
import org.generation.italy.sudProject.entities.npcTypes.npcs.Guard;
import org.generation.italy.sudProject.map.Room;

import java.util.ArrayList;

import static org.generation.italy.sudProject.Entity.dice;
import static org.generation.italy.sudProject.entities.npcTypes.npcs.Guard.deleteGuards;
import static org.generation.italy.sudProject.map.Room.*;

public class Spawner {

    // /--METHODS--/
    public static void generateRoomEntities(Room room, int numOfCats, int numOfCultists){
        for(int i=0; i<numOfCats; i++){
            room.getRoomEntities().get(CAT_INDEX).add(new Cat("Cat", room, CAT_INDEX));
        }
        for(int i=0; i<room.getMaxGuardsInRoom(); i++){
            room.getRoomEntities().get(GUARD_INDEX).add(new Guard("Guard", room, GUARD_INDEX));
        }
        for(int i=0; i<numOfCultists; i++){
            room.getRoomEntities().get(CULTIST_INDEX).add(new Cultist("Cultist", room, CULTIST_INDEX));
        }

    }
    public static void addNewEntityType(Room room){
        room.getRoomEntities().add(new ArrayList<Entity>());
    }

    public static void resetGuardsInRoom(Room room){
        if(room.getRoomEntities().get(GUARD_INDEX) != null){
            int numGuards = (room.getRoomEntities().get(GUARD_INDEX).size());
            int randomNumber = dice.nextInt(room.getMaxGuardsInRoom()+1);
            room.getRoomEntities().get(GUARD_INDEX).clear();
            deleteGuards(numGuards);
            for(int i=0; i<randomNumber; i++){
                room.getRoomEntities().get(GUARD_INDEX).add(new Guard("Guard", room, GUARD_INDEX));
            }
        }
    }
}
