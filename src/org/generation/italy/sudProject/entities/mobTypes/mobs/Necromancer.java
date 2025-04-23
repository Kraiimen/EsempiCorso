package org.generation.italy.sudProject.entities.mobTypes.mobs;

import org.generation.italy.sudProject.Entity;
import org.generation.italy.sudProject.items.itemTypes.UniqueItem;
import org.generation.italy.sudProject.map.Room;

public class Necromancer extends Entity {
    private static final int XP_FOR_KILLER = 1000;
    private static final int MONEY_FOR_KILLER = 1000;
    public static int numberOfNecromancers;
    private String medallionDescription = "Un medaglione che rappresenta una mezzaluna crescente";


    // /--CONSTRUCTORS--/
    public Necromancer(Room entityPosition, int indexEntityPosition) {
        super("Necromancer", 16, 20, INTELLIGENCE_INDEX, 20, 100, 100, 15, entityPosition,
                indexEntityPosition, true, 2, MONEY_FOR_KILLER, XP_FOR_KILLER);
        this.entityInventory.addItemToInventory(new UniqueItem("Necromancer_medallion", 50, false, medallionDescription));
        numberOfNecromancers++;
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
