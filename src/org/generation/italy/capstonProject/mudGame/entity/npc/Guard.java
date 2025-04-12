package org.generation.italy.capstonProject.mudGame.entity.npc;

import org.generation.italy.capstonProject.mudGame.entity.items.Armor;
import org.generation.italy.capstonProject.mudGame.entity.items.Item;
import org.generation.italy.capstonProject.mudGame.entity.items.Weapon;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

public class Guard extends Npc{
    public Guard(String charName, int maxHP, Room currentRoom) {
        super(charName, maxHP, 10, currentRoom, false, NpcRole.GUARD);
    }

    public static Guard generateGuard(String charName, int maxHP, Room currentRoom) {
        Guard guard = new Guard(charName, maxHP, currentRoom);

        Item weapon = new Weapon("Sword1", (int)(Math.random() * 5));
        guard.getInventory().addItem(weapon);

        int chanceToHaveWeapon = (int)(Math.random() * 3);
        if (chanceToHaveWeapon == 0) {
            Item weapon2 = new Weapon("Sword2", (int)(Math.random() * 7));
            guard.getInventory().addItem(weapon2);
        }

        int chanceToHaveArmor = (int)(Math.random() * 2);
        if (chanceToHaveArmor == 0) {
            Item armor = new Armor("Shield", (int)(Math.random() * 4), (int)(Math.random() * 2), 0);
            guard.getInventory().addItem(armor);
        }

        return guard;
    }
}
