package org.generation.italy.sudProject.items.itemTypes.weapons;

import org.generation.italy.sudProject.items.itemTypes.Weapon;

import static org.generation.italy.sudProject.Entity.DEXTERITY_INDEX;

public class Sword extends Weapon {
    private final static int ATTRIBUTE_SCALING = DEXTERITY_INDEX;
    private static String name ="Sword";
    private static String description ="Una semplice spada";
    private static int dmg = 8;

    // /--CONSTRUCTORS--/
    public Sword(int value, boolean dropped) {
        super(name, value, dropped, description, dmg, ATTRIBUTE_SCALING);
    }
}
