package org.generation.italy.sudProject.entities.mobTypes.mobs;

import org.generation.italy.sudProject.Entity;
import org.generation.italy.sudProject.items.itemTypes.UniqueItem;
import org.generation.italy.sudProject.map.Room;

public class Cultist extends Entity {
    public static int numberOfCultists;
    private String medallionDescription = "Un medaglione con sopra inciso il simbolo di una luna nuova";
    private static final int XP_FOR_KILLER = 25;
    private static final int MONEY_FOR_KILLER = 12;

    // /--CONSTRUCTORS--/
    public Cultist(String name, Room entityPosition, int indexEntityPosition) {
        super(name, 10, 16, DEXTERITY_INDEX, 14, 20, 20, 5,
                entityPosition, indexEntityPosition, true, 1, MONEY_FOR_KILLER, XP_FOR_KILLER);
        numberOfCultists++;
        this.entityInventory.addItemToInventory(new UniqueItem("Cultist_medallion", 10, false, medallionDescription));
    }
    // /--METHODS--/
    @Override
    public void attack(Entity target) {
        if(target.isCanBeAttacked()){
            target.setHp(target.getHp() - this.getAtk() + this.getAtkBonusFromStat());
        }
        if(isDead(target)){
            target.die();
        }
    }
}
