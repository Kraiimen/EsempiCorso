package org.generation.italy.sudProject.entities.npcTypes.npcs;

import org.generation.italy.sudProject.entities.npcTypes.CanNotBeAttackedNpc;
import org.generation.italy.sudProject.map.Room;

public class Blacksmith extends CanNotBeAttackedNpc {



    // /--CONSTRUCTORS--/
    public Blacksmith(String npcName, Room npcPosition, int indexNpcPosition) {
        super(npcName, 5, 10, STRENGTH_INDEX, 13, 50, 50, 10, npcPosition, indexNpcPosition);
    }
}
