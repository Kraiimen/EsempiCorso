package org.generation.italy.sudProject.entities;

import org.generation.italy.sudProject.Entity;

public abstract class Npc extends Entity {
    // /--ATTRIBUTES--/
    public static int numberOfNpcs;

    // /--CONSTRUCTORS--/
    public Npc(String npcName, int minStatValue, int maxStatValue, int indexClassStat, int classStat, int hp, int maxHp) {
        super(npcName, minStatValue, maxStatValue, indexClassStat, classStat, hp, maxHp);
        numberOfNpcs++;
    }

    // /--METHODS--/
}
