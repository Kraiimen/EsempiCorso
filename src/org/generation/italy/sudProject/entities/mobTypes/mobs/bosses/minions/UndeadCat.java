package org.generation.italy.sudProject.entities.mobTypes.mobs.bosses.minions;

import org.generation.italy.sudProject.Entity;
import org.generation.italy.sudProject.map.Room;

public class UndeadCat extends Entity {

    public UndeadCat(String name, int minStatValue, int maxStatValue, int indexClassStat, int classStat, int hp,
                     int maxHp, int BaseAtk, Room entityPosition, int indexEntityPosition, boolean canBeAttacked,
                     int inventoryCap, int money, int xp) {
        super(name, minStatValue, maxStatValue, indexClassStat, classStat, hp, maxHp, BaseAtk, entityPosition,
                indexEntityPosition, canBeAttacked, inventoryCap, money, xp);
    }

    @Override
    public void attack(Entity target) {
        if(target.isCanBeAttacked()){
            target.setHp(target.getHp() - this.getAtk());
        }
        if(isDead(target)){
            target.die();
        }
    }
}
