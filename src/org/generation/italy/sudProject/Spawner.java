package org.generation.italy.sudProject;

import org.generation.italy.sudProject.entities.mobs.Cat;
import org.generation.italy.sudProject.entities.npcTypes.Guard;
import org.generation.italy.sudProject.map.Room;

import static org.generation.italy.sudProject.Entity.dice;
import static org.generation.italy.sudProject.entities.npcTypes.Guard.deleteGuards;
import static org.generation.italy.sudProject.map.Room.CAT_INDEX;
import static org.generation.italy.sudProject.map.Room.GUARD_INDEX;

public class Spawner {

    // /--METHODS--/
    public static void generateRoomEntities(Room room, int numOfCats, int numOfGuards){
        for(int i=0; i<numOfCats; i++){
            room.getRoomEntities().get(CAT_INDEX).add(new Cat("Cat", room, CAT_INDEX));
        }
        for(int i=0; i<numOfGuards; i++){
            room.getRoomEntities().get(GUARD_INDEX).add(new Guard("Guard", room, GUARD_INDEX));
        }
    }

    public static void resetGuardsInRoom(Room room){
        if(room.getRoomEntities().get(GUARD_INDEX) != null){
            int numGuards = (room.getRoomEntities().get(GUARD_INDEX).size());
            int randomNumber = dice.nextInt(numGuards+1);
            room.getRoomEntities().get(GUARD_INDEX).clear();
            deleteGuards(numGuards);
            for(int i=0; i<randomNumber; i++){
                room.getRoomEntities().get(GUARD_INDEX).add(new Guard("Guard", room, GUARD_INDEX));
            }
        }
    }
}
