package org.generation.italy.sudProject.items.itemTypes.foods;

import org.generation.italy.sudProject.items.itemTypes.Food;

public class Bread extends Food {
    private static String breadDescription = "Del semplice pane, appena sfornato";
    private static String name = "Bread";
    private static int hpValue = 10;

    // /--CONSTRUCTORS--/
    public Bread(int value, boolean dropped) {
        super(name, value, dropped, breadDescription, hpValue);
    }
}
