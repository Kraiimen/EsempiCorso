package org.generation.italy.sudProject.entities.npcTypes.npcs;

import org.generation.italy.sudProject.entities.npcTypes.CanNotBeAttackedNpc;
import org.generation.italy.sudProject.map.Room;

public class Baker extends CanNotBeAttackedNpc {



    // /--CONSTRUCTORS--/
    public Baker(String npcName, Room npcPosition, int indexNpcPosition) {
        super(npcName, 1, 4, DEXTERITY_INDEX, 8,
                10, 10, 2, npcPosition, indexNpcPosition, 1);
    }
}
