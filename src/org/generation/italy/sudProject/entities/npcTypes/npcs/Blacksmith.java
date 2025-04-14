package org.generation.italy.sudProject.entities.npcTypes.npcs;

import org.generation.italy.sudProject.entities.npcTypes.CanNotBeAttackedNpc;
import org.generation.italy.sudProject.items.itemTypes.weapons.Dagger;
import org.generation.italy.sudProject.items.itemTypes.weapons.HolyMace;
import org.generation.italy.sudProject.items.itemTypes.weapons.Staff;
import org.generation.italy.sudProject.items.itemTypes.weapons.Sword;
import org.generation.italy.sudProject.map.Room;

public class Blacksmith extends CanNotBeAttackedNpc {

    // /--CONSTRUCTORS--/
    public Blacksmith(String npcName, Room npcPosition, int indexNpcPosition) {
        super(npcName, 5, 10, STRENGTH_INDEX, 13, 50,
                50, 10, npcPosition, indexNpcPosition, 4);
        forge();
    }
    // /--METHODS--/
    private void forge(){
        this.entityInventory.addItemToInventory(new Dagger(25,false));
        this.entityInventory.addItemToInventory(new Dagger(25,false));
        this.entityInventory.addItemToInventory(new HolyMace(50,false));
        this.entityInventory.addItemToInventory(new Sword(50,false));
        this.entityInventory.addItemToInventory(new Staff(50,false));
    }
}
