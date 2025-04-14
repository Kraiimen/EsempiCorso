package org.generation.italy.sudProject.items.itemTypes.weapons;

import org.generation.italy.sudProject.items.itemTypes.Weapon;
import static org.generation.italy.sudProject.Entity.INTELLIGENCE_INDEX;

public class Staff extends Weapon {
    private final static int ATTRIBUTE_SCALING = INTELLIGENCE_INDEX;
    private static String name ="Staff";
    private static String description ="Un bastone contenente segni di magia";
    private static int dmg = 8;

    // /--CONSTRUCTORS--/
    public Staff(int value, boolean dropped) {
        super(name, value, dropped, description, dmg, ATTRIBUTE_SCALING);
    }
}
