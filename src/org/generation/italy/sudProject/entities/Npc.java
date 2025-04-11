package org.generation.italy.sudProject.entities;

import org.generation.italy.sudProject.Entity;
import org.generation.italy.sudProject.map.Room;

public abstract class Npc extends Entity {
    // /--ATTRIBUTES--/
    public static int numberOfNpcs;

    // /--CONSTRUCTORS--/
    public Npc(String npcName, int minStatValue, int maxStatValue, int indexClassStat, int classStat, int hp, int maxHp, int baseAtk,
               Room npcPosition, int indexNpcPosition, boolean canBeAttacked) {
        super(npcName, minStatValue, maxStatValue, indexClassStat, classStat, hp, maxHp, baseAtk, npcPosition, indexNpcPosition, canBeAttacked );
        numberOfNpcs++;
    }

    // /--METHODS--/
}
