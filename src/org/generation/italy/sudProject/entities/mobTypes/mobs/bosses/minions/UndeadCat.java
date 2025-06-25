package org.generation.italy.sudProject.entities.mobTypes.mobs.bosses.minions;

import org.generation.italy.sudProject.Entity;
import org.generation.italy.sudProject.map.Room;

import static org.generation.italy.sudProject.map.Room.UNDEAD_CAT_INDEX;

public class UndeadCat extends Entity {
    private static final int HP_FIRST_SPAWN = 2;
    private static final int HP_MAX_FIRST_SPAWN = 2;
    private static final int XP_FOR_KILLER = 10;
    private static final int MONEY_FOR_KILLER = 1;

    public UndeadCat(Room position) {
        super("UndeadCat", 1, 2, DEXTERITY_INDEX, 2, HP_FIRST_SPAWN, HP_MAX_FIRST_SPAWN, 1, position,
                UNDEAD_CAT_INDEX, true, 0, MONEY_FOR_KILLER, XP_FOR_KILLER);
    }
    @Override
    public void attack(Entity target) {
        if(target.isCanBeAttacked()){
            target.setHp(target.getHp() - this.getAtk() + this.getAtkBonusFromStat());
        }
    }
}
