package org.generation.italy.sudProject.entities.mobTypes.mobs.bosses;

import org.generation.italy.sudProject.Entity;
import org.generation.italy.sudProject.entities.mobTypes.mobs.bosses.minions.UndeadCat;
import org.generation.italy.sudProject.items.itemTypes.UniqueItem;
import org.generation.italy.sudProject.map.Room;

import static org.generation.italy.sudProject.entities.mobTypes.mobs.Cat.numberOfCats;
import static org.generation.italy.sudProject.map.Room.BOSS_INDEX;
import static org.generation.italy.sudProject.map.Room.UNDEAD_CAT_INDEX;
import static org.generation.italy.sudProject.map.WorldMap.numberOfDeadCats;

public class Necromancer extends Entity {
    private static final int XP_FOR_KILLER = 1000;
    private static final int MONEY_FOR_KILLER = 1000;
    private String medallionDescription = "Un medaglione che rappresenta una mezzaluna crescente";
    private boolean timeToAttack = false;
    private int numberOfSummons = numberOfDeadCats;

    // /--CONSTRUCTORS--/
    public Necromancer(Room entityPosition) {
        super("Necromancer", 16, 20, INTELLIGENCE_INDEX, 20, 100, 100, 15, entityPosition,
                BOSS_INDEX, true, 2, MONEY_FOR_KILLER, XP_FOR_KILLER);
        this.entityInventory.addItemToInventory(new UniqueItem("Necromancer_medallion", 50, false, medallionDescription));
    }

    // /--METHODS--/
    @Override
    public void attack(Entity target) {
        if(!timeToAttack && numberOfDeadCats > 0){
            //evoca
            this.getEntityPosition().getRoomEntities().get(UNDEAD_CAT_INDEX).add(new UndeadCat(this.getEntityPosition(), UNDEAD_CAT_INDEX));
            numberOfSummons--;
            timeToAttack = true;
        }else{
            if(target.isCanBeAttacked()){
                target.setHp(target.getHp() - this.getAtk());
            }
            if(isDead(target)){
                numberOfSummons = numberOfDeadCats;
                target.die();
            }
        }
    }
}
