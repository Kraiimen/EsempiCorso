package org.generation.italy.sudProject.entities.mobTypes.mobs;

import org.generation.italy.sudProject.Entity;
import org.generation.italy.sudProject.map.Room;

public class Cultist extends Entity {
    public static int numberOfCultists;


    // /--CONSTRUCTORS--/
    public Cultist(String name, Room entityPosition, int indexEntityPosition) {
        super(name, 10, 16, DEXTERITY_INDEX, 14, 20, 20, 5,
                entityPosition, indexEntityPosition, true, 1);
        numberOfCultists++;
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
