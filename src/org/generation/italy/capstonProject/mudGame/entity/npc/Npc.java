package org.generation.italy.capstonProject.mudGame.entity.npc;

import org.generation.italy.capstonProject.mudGame.entity.Entity;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

import java.util.ArrayList;
import java.util.List;

public class Npc extends Entity {
    private boolean isHostile;
    private List<String> messages;
    private String role;

    public Npc(String charName, int maxHP, int maxDamage, Room currentRoom, boolean isHostile, String role) {
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
        target.hasTakenDamage(this.getDamage());
    }

    @Override
    public void manageInteraction(Entity target){
        if(isHostile){
            while(!target.isDead()){
                attack(target);
                if(target.isDead()){
                    setIsUnderAttack(false);
                    break;
                }
            }
            attack(target);
        } else if (getIsUnderAttack()){
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
        return "Npc{" +
                "charName: '" + getCharName() + '\'' +
                ", role: '" + role +
                ", healthPoints: " + getHealthPoints() + "/" + getMaxHP() +
                ", maxDamage: " + getMaxDamage() +
                ", isHostile: " + isHostile +
                ", inventory: " + inventory + '\'' +
                '}';
    }
}
