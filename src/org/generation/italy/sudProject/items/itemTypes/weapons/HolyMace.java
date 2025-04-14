package org.generation.italy.sudProject.items.itemTypes.weapons;

import org.generation.italy.sudProject.items.itemTypes.Weapon;
import static org.generation.italy.sudProject.Entity.WISDOM_INDEX;

public class HolyMace extends Weapon {
    private final static int ATTRIBUTE_SCALING = WISDOM_INDEX;
    private static String name ="Holy_Mace";
    private static String description ="Una mazza sacra";
    private static int dmg = 8;


    // /--CONSTRUCTORS--/
    public HolyMace(int value, boolean dropped) {
        super(name, value, dropped, description, dmg, ATTRIBUTE_SCALING);
    }
}
