package mud.rooms;

import mud.characters.Entity;
import mud.characters.npcs.Baker;
import mud.items.Food;
import mud.items.Weapon;


public class Bakery extends Room{
    public Bakery() {
        super("The Bakery");
    }


    @Override
    public void printEntrance() {
        System.out.println("Can you smell the fresh from the oven bread? You are at the Bakery now.");
        printEntities();

    }
}
