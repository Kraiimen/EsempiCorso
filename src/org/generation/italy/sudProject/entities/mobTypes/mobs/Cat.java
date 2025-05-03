package org.generation.italy.sudProject.entities.mobTypes.mobs;

import org.generation.italy.sudProject.entities.mobTypes.PeacefulMob;
import org.generation.italy.sudProject.items.itemTypes.Food;
import org.generation.italy.sudProject.map.Room;

public class Cat extends PeacefulMob {
    public static int numberOfCats;
    private static final int HP_FIRST_SPAWN = 2;
    private static final int HP_MAX_FIRST_SPAWN = 2;
    private static final int XP_FOR_KILLER = 10;
    private static final int MONEY_FOR_KILLER = 1;


    private String meatDescription = "Ha un sapore simile al pollo, ma con un retrogusto particolare";

    // /--CONSTRUCTORS--/
    public Cat(String catName, Room position, int indexCatPosition) {
        super(catName, HP_FIRST_SPAWN, HP_MAX_FIRST_SPAWN, position, indexCatPosition, 1, MONEY_FOR_KILLER, XP_FOR_KILLER);
        numberOfCats++;
        this.entityInventory.addItemToInventory(new Food("Carne_di_gatto", 1, false, meatDescription, 1));
    }

    // /--GETTER-&-SETTER--/

    public static int getNumberOfCats() {
        return numberOfCats;
    }
}
