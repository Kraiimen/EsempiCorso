package org.generation.italy.sudProject.entities.npcTypes;

import org.generation.italy.sudProject.entities.Npc;
import org.generation.italy.sudProject.map.Room;

public class CanNotDieNpc extends Npc {
    protected static final boolean CAN_BE_ATTACKED = false;


    // /--CONSTRUCTORS--/
    public CanNotDieNpc(String npcName, int minStatValue, int maxStatValue, int indexClassStat, int classStat, int hp,
                        int maxHp, int baseAtk, Room npcPosition, int indexNpcPosition) {
        super(npcName, minStatValue, maxStatValue, indexClassStat, classStat, hp, maxHp, baseAtk, npcPosition, indexNpcPosition);
    }
}
