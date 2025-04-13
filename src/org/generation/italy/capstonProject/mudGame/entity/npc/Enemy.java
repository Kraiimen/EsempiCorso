package org.generation.italy.capstonProject.mudGame.entity.npc;

import org.generation.italy.capstonProject.mudGame.entity.Entity;
import org.generation.italy.capstonProject.mudGame.entity.items.Armor;
import org.generation.italy.capstonProject.mudGame.entity.items.Food;
import org.generation.italy.capstonProject.mudGame.entity.items.Item;
import org.generation.italy.capstonProject.mudGame.entity.items.Weapon;
import org.generation.italy.capstonProject.mudGame.entity.player.Player;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

import java.util.Scanner;

public class Enemy extends Npc{
    private double criticalChance;

    public Enemy(String charName, int maxHP, int maxDamage, Room currentRoom, double criticalChance) {
        super(charName, maxHP, maxDamage, currentRoom, true, NpcRole.MONSTER);
        this.criticalChance = criticalChance;
    }

    @Override
    public void attack(Entity target) {
        damage = this.calculateDamage();
        int finalDamage = damage;

        if(target instanceof Player) {
            System.out.println("\u001B[31m" + this.getCharName() + " is attacking you!" + "\033[0m");
        }

        if(Math.random() < criticalChance){
            System.out.println("\u001B[31m" + this.getCharName() + "strike a critical attack!" + "\033[0m");
            finalDamage *= 2;
        }

        System.out.println("\u001B[31m" + this.getCharName() + " inflicts " + finalDamage + "/" + getMaxDamage() + " damage." + "\033[0m");
        target.hasTakenDamage(finalDamage);

        if(target instanceof Player player) {
            player.managePlayerInteraction(this, new Scanner(System.in));
        }
    }

    public static Enemy generateEnemy(String charName, int maxHP, Room currentRoom) {
        Enemy enemy = new Enemy(charName, maxHP, (int)(Math.random() * 10), currentRoom, (int)(Math.random() * 1) );

        Item weapon = new Weapon("Sword1", (int)(Math.random() * 5));
        enemy.getInventory().addItem(weapon);

        int chanceToHaveWeapon = (int)(Math.random() * 3);
        if (chanceToHaveWeapon == 0) {
            Item weapon2 = new Weapon("Sword2", (int)(Math.random() * 7));
            enemy.getInventory().addItem(weapon2);
        }

        int chanceToHaveArmor = (int)(Math.random() * 3);
        if (chanceToHaveArmor == 0) {
            Item armor = new Armor("Shield", (int)(Math.random() * 4), (int)(Math.random() * 2), 0);
            enemy.getInventory().addItem(armor);
        }

        int chanceToHaveFood = (int)(Math.random() * 2);
        if (chanceToHaveFood == 0) {
            Item food = new Food("Bread", 0.3);
            enemy.getInventory().addItem(food);
        }

        return enemy;
    }

    public double getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(double criticalChance) {
        this.criticalChance = criticalChance;
    }
}
