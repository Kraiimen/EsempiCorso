package org.generation.italy.sudProject.entities.mobTypes.mobs;

import org.generation.italy.sudProject.Entity;
import org.generation.italy.sudProject.items.Item;
import org.generation.italy.sudProject.items.itemTypes.UniqueItem;
import org.generation.italy.sudProject.map.Room;

public class Cultist extends Entity {
    public static int numberOfCultists;
    private String medallionDescription = "Un medaglione con sopra inciso il simbolo di una luna nuova";

    // /--CONSTRUCTORS--/
    public Cultist(String name, Room entityPosition, int indexEntityPosition) {
        super(name, 10, 16, DEXTERITY_INDEX, 14, 20, 20, 5,
                entityPosition, indexEntityPosition, true, 1);
        numberOfCultists++;
        this.entityInventory.addItemToInventory(new UniqueItem("Cultist_Medallion", 10, false, medallionDescription));
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
}
