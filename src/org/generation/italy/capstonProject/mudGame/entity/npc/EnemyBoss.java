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

        damage = this.calculateDamage();
        int finalDamage = damage;

        if(target instanceof Player) {
            System.out.println("\033[0;31m" + this.getCharName() + " is attacking you!" + "\033[0m");
        }

        if(Math.random() < getCriticalChance()){
            System.out.println("\033[0;31m" + this.getCharName() + "strike a critical attack!" + "\033[0m");
            finalDamage *= 2;
        }

        System.out.println("\033[0;31m" + this.getCharName() + " inflicts " + finalDamage + "/" + getMaxDamage() + " damage." + "\033[0m");
        target.hasTakenDamage(finalDamage);

        if(target instanceof Player player) {
            player.managePlayerInteraction(this, new Scanner(System.in));
        }
    }

    @Override
    public void manageInteraction(Entity target){
        if (isDead()) return;

        if(target instanceof Player player && !player.isHasKilledKitties()){
            System.out.println("\033[0;33m" + "You showed mercy to my kind, for this reason you will be spared. I know what your heart desire the most and I will just give it to you. Happy birthday!" + "\033[0m");
            for(Item item : inventory.getAll().keySet()){
                int quantity = inventory.getAll().get(item);
                for(int i = 0; i < quantity; i++){
                    this.getCurrentRoom().addItemToRoom(item);
                }
            }
            System.out.println("\033[0;33m" + this.getCharName() + " dropped the One Ring"  + "\033[0m");
            inventory.getAll().clear();
            return;
        }

        if(isHostile() || getIsUnderAttack()){
            while(!target.isDead()){
                attack(target);
                if(target.isDead()){
                    setIsUnderAttack(false);
                    break;
                }
            }
        } else {
            System.out.println("\033[0;33m" + this.getCharName() + " says: " + (getMessages().isEmpty() ? "Hi " + target.getCharName() + "!" : getMessages().getFirst())  + "\033[0m");
        }
    }
}


