package org.generation.italy.sudProject.entities.mobs;

import org.generation.italy.sudProject.Entity;

public abstract class PeacefulMob extends Entity {
    // /--ATTRIBUTES--/
    public static int numberOfPeacefulMobs;
    // /--CONSTRUCTORS--/
    public PeacefulMob(String mobName, int hp, int hpMax) {
        super(mobName, 0, 1, -1, -1, hp, hpMax);
        numberOfPeacefulMobs++;
    }

    // /--METHODS--/

    // /--GETTER-&-SETTER--/
}
