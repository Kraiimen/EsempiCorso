package org.generation.italy.capstonProject.mudGame.entity.npc;

import org.generation.italy.capstonProject.mudGame.entity.items.Item;
import org.generation.italy.capstonProject.mudGame.entity.items.Potion;
import org.generation.italy.capstonProject.mudGame.entity.items.Weapon;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

public class Cat extends Npc{

    public Cat(String charName, int maxHP, Room currentRoom) {
        super(charName, maxHP, 5, currentRoom, false, NpcRole.CAT);
        getMessages().add("\033[0;33m" + "Please spare me" + "\033[0m");
    }

    public void showGratitude(){
        System.out.println("\033[0;33m" + "Thank you, kind being. Not many of your kind are this nice to small creatures like me. When the Cat Revolution will come, we will remember your kindness." + "\033[0m");
    }

    public static Cat generateCat(String charName, int maxHP, Room currentRoom) {
        Cat cat = new Cat(charName, maxHP, currentRoom);

        int chanceToHaveWeapon = (int)(Math.random() * 5);
        if (chanceToHaveWeapon == 0) {
            Item weapon = new Weapon("Sword", (int)(Math.random() * 5));
            cat.getInventory().addItem(weapon);
        }

        int chanceToHavePotion = (int)(Math.random() * 4);
        if (chanceToHavePotion == 0) {
            Item potion = new Potion("Heath Potion", (Math.random() * 1), 0);
            cat.getInventory().addItem(potion);
        }

        return cat;
    }

}
