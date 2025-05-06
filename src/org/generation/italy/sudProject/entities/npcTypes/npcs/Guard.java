package org.generation.italy.sudProject.entities.npcTypes.npcs;

import org.generation.italy.sudProject.Entity;
import org.generation.italy.sudProject.entities.Npc;
import org.generation.italy.sudProject.map.Room;

import static org.generation.italy.sudProject.map.Room.PLAYER_INDEX;

public class Guard extends Npc {
    // /--ATTRIBUTES--/
    public static int numberOfGuards;
    private static final int HP_FIRST_SPAWN = 100;
    private static final int HP_MAX_FIRST_SPAWN = 100;
    private static final int XP_FOR_KILLER = 50;
    private static final int MONEY_FOR_KILLER = 200;

    // /--CONSTRUCTORS--/
    public Guard(String npcName, Room position, int indexGuardPosition) {
        super(npcName, CLASS_STARTING_P_VALUE, MAX_ATTRIBUTE_P_VALUE, STRENGTH_INDEX, 20, HP_FIRST_SPAWN, HP_MAX_FIRST_SPAWN, 20, position,
                indexGuardPosition, false, 2, MONEY_FOR_KILLER, XP_FOR_KILLER);
        numberOfGuards++;
    }

    // /--METHODS--/
    public static void deleteGuards(int num){
        numberOfGuards -= num;
    }
    @Override
    public void attack(Entity target) {
        if(target.isCanBeAttacked()){
            target.setHp(target.getHp() - this.getAtk() + this.getAtkBonusFromStat());
        }
        if(isDead(target) || target.getIndexEntityPosition()==PLAYER_INDEX){
            target.setHp(0);
            target.die();
        }
    }
    // /--GETTER-&-SETTER--/

    public static int getNumberOfGuards() {
        return numberOfGuards;
    }
}
