package org.generation.italy.capstonProject.mudGame.entity.npc;

import org.generation.italy.capstonProject.mudGame.entity.items.Item;
import org.generation.italy.capstonProject.mudGame.entity.items.Weapon;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

public class Cat extends Npc{

    public Cat(String charName, int maxHP, Room currentRoom) {
        super(charName, maxHP, 5, currentRoom, false, NpcRole.CAT);
        getMessages().add("Please spare me");
    }

    public void showGratitude(){
        System.out.println("Thank you, kind being. Not many of your kind are this nice to small creatures like me. When the Cat Revolution will come, we will remember your kindness.");
    }

    public static Cat generateCat(String charName, int maxHP, Room currentRoom) {
        Cat cat = new Cat(charName, maxHP, currentRoom);

        int chanceToHaveWeapon = (int)(Math.random() * 5);
        if (chanceToHaveWeapon == 0) {
            Item weapon = new Weapon("Sword", (int)(Math.random() * 5));
            cat.getInventory().addItem(weapon);
        }

        return cat;
    }

}
