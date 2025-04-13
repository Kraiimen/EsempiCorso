package org.generation.italy.sudProject.items.itemTypes;

import org.generation.italy.sudProject.items.Item;

public class Food extends Item {
    private int hpValue;


    // /--CONSTRUCTORS--/
    public Food(String itemName, int value, boolean dropped, String item_description, int hpValue) {
        super(itemName, value, dropped, item_description);
        this.hpValue = hpValue;
    }
    // /--GETTER-&-SETTER--/

    public int getHpValue() {
        return hpValue;
    }

    public void setHpValue(int hpValue) {
        this.hpValue = hpValue;
    }
}
