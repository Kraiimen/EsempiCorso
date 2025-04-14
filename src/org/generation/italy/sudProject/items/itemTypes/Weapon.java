package org.generation.italy.sudProject.items.itemTypes;

import org.generation.italy.sudProject.items.Item;

public abstract class Weapon extends Item {
    private int dmg;
    private int attributeIndex;

    // /--CONSTRUCTORS--/
    public Weapon(String itemName, int value, boolean dropped, String item_description, int dmg, int attributeIndex) {
        super(itemName, value, dropped, item_description);
        this.dmg = dmg;
        this.attributeIndex = attributeIndex;
    }
}
