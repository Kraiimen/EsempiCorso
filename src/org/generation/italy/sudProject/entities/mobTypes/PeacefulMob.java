package org.generation.italy.sudProject.entities.mobTypes;

import org.generation.italy.sudProject.Entity;
import org.generation.italy.sudProject.map.Room;

public abstract class PeacefulMob extends Entity {
    // /--ATTRIBUTES--/
    public static int numberOfPeacefulMobs;
    // /--CONSTRUCTORS--/
    public PeacefulMob(String mobName, int hp, int hpMax, Room mobPosition, int indexMobPosition, int inventoryCap, int money) {
        super(mobName, 0, 1, -1, -1, hp, hpMax,0,
                mobPosition, indexMobPosition, true, inventoryCap, money);
        numberOfPeacefulMobs++;
    }

    // /--METHODS--/
    @Override
    public void attack(Entity target) {
        if(target.isCanBeAttacked()){
            target.setHp(target.getHp() - this.getAtk());
        }
        if(isDead(target)){
            target.die();
        }
    }
    // /--GETTER-&-SETTER--/
}
