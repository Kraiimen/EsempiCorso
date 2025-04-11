package org.generation.italy.capstonProject.mudGame.entity;

import org.generation.italy.capstonProject.mudGame.entity.npc.Cat;
import org.generation.italy.capstonProject.mudGame.entity.npc.Guard;
import org.generation.italy.capstonProject.mudGame.entity.npc.Npc;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

public class WorldBuilder {
    public static void populateWorld(){
        Room templeSquare = Room.getRoomByName("Temple Square");

        Npc guard1 = new Guard("Giovanni", 60, templeSquare);
        Npc cat1 = new Cat("Whiskers", 20, templeSquare);

        Room temple = Room.getRoomByName("Temple");
        Npc cat2 = new Cat("KittyPurry", 20, temple);
    }
}
