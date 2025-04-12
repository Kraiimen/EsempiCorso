package org.generation.italy.sudProject.entities.npcTypes;

import org.generation.italy.sudProject.Entity;
import org.generation.italy.sudProject.entities.Npc;
import org.generation.italy.sudProject.map.Room;

public class CanNotBeAttackedNpc extends Npc {

    // /--CONSTRUCTORS--/
    public CanNotBeAttackedNpc(String npcName, int minStatValue, int maxStatValue, int indexClassStat, int classStat, int hp,
                               int maxHp, int baseAtk, Room npcPosition, int indexNpcPosition) {
        super(npcName, minStatValue, maxStatValue, indexClassStat, classStat, hp, maxHp, baseAtk, npcPosition, indexNpcPosition, false);
    }
}
