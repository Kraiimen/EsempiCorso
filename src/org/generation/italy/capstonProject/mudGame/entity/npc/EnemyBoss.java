package org.generation.italy.capstonProject.mudGame.entity.npc;

import org.generation.italy.capstonProject.mudGame.entity.Entity;
import org.generation.italy.capstonProject.mudGame.entity.items.Item;
import org.generation.italy.capstonProject.mudGame.entity.player.Player;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

import java.util.Scanner;

public class EnemyBoss extends Enemy{
    public EnemyBoss(String charName, int maxHP, int maxDamage, Room currentRoom, double criticalChance) {
        super(charName, maxHP, maxDamage, currentRoom, criticalChance);
    }

    @Override
    public void attack(Entity target) {
        if(target instanceof Player player && !player.isHasKilledKitties()){
            System.out.println("You showed mercy to my kind, for this reason you will be spared. I know what your heart desire the most and I will just give it to you. Happy birthday!");
            for(Item item : inventory.getAll().keySet()){
                int quantity = inventory.getAll().get(item);
                for(int i = 0; i < quantity; i++){
                    this.getCurrentRoom().addItemToRoom(item);
                }
            }
            System.out.println(this.getCharName() + " dropped the one ring");
            return;
        }
        damage = this.calculateDamage();
        int finalDamage = damage;

        if(target instanceof Player) {
            System.out.println(this.getCharName() + " is attacking you!");
        }

        if(Math.random() < getCriticalChance()){
            System.out.println(this.getCharName() + "strike a critical attack!");
            finalDamage *= 2;
        }

        System.out.println(this.getCharName() + " inflicts " + finalDamage + "/" + getMaxDamage() + " damage.");
        target.hasTakenDamage(finalDamage);

        if(target instanceof Player player) {
            player.managePlayerInteraction(this, new Scanner(System.in));
        }
    }
}
