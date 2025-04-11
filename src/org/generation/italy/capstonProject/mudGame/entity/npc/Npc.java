package org.generation.italy.capstonProject.mudGame.entity.npc;

import org.generation.italy.capstonProject.mudGame.entity.Entity;
import org.generation.italy.capstonProject.mudGame.entity.player.Player;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Npc extends Entity {
    private boolean isHostile;
    private List<String> messages;
    private NpcRole role;

    public Npc(String charName, int maxHP, int maxDamage, Room currentRoom, boolean isHostile, NpcRole role) {
        super(charName, maxHP, maxDamage, currentRoom);
        this.isHostile = isHostile;
        this.role = role;
        getCurrentRoom().addEntityToRoom(this);
        messages = new ArrayList<>();
    }

    public void putInRoom(Room room) {
        if(room != null){
            setCurrentRoom(room);
            getCurrentRoom().addEntityToRoom(this);
        }
    }

    @Override
    public void attack(Entity target) {
        int damage = this.calculateDamage();
        System.out.println(this.getCharName() + " is attacking.");
        System.out.println(this.getCharName() + " inflicts " + getDamage() + "/" + getMaxDamage() + " damage.");
        target.hasTakenDamage(damage);
        if(target instanceof Player player) {
            player.managePlayerInteraction(this, new Scanner(System.in));
        }
    }

    @Override
    public void manageInteraction(Entity target){
        if (isDead()) return;

        if(isHostile || getIsUnderAttack()){
            while(!target.isDead()){
                attack(target);
                if(target.isDead()){
                    setIsUnderAttack(false);
                    break;
                }
            }
        } else {
            System.out.println(this.getCharName() + " says: " + (messages.isEmpty() ? "Hi " + target.getCharName() + "!" : messages.getFirst()));
        }
    }

    public void respawn(){

    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public boolean isHostile() {
        return isHostile;
    }

    public void setHostile(boolean hostile) {
        isHostile = hostile;
    }

    @Override
    public String toString() {
        return "\nNpc{" +
                "\ncharName: '" + getCharName() + '\'' +
                ", \nrole: '" + role +
                ", \nhealthPoints: " + getHealthPoints() + "/" + getMaxHP() +
                ", \nmaxDamage: " + getMaxDamage() +
                ", \nisHostile: " + isHostile +
                ", \ninventory: " + inventory + '\'' +
                "\n}";
    }
}
