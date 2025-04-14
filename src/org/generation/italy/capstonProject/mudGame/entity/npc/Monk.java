package org.generation.italy.capstonProject.mudGame.entity.npc;

import org.generation.italy.capstonProject.mudGame.entity.Entity;
import org.generation.italy.capstonProject.mudGame.entity.player.Player;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

public class Monk extends Npc{

    public Monk(String charName, Room currentRoom) {
        super(charName, 80, 10, currentRoom, false, NpcRole.MONCH);
        getMessages().add("\033[0;33m" + "Your body can grow through your spirit. Here you can meditate in peace." + "\033[0m");
    }

    @Override
    public void manageInteraction(Entity target){
        if (isDead()) return;

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
            if(target instanceof Player player && player.getExperience() > player.getMaxExperience()){
                System.out.println("\033[0;33m" + "Your aura is strong, and I can see your Hearth is full of courage. It's time for an upgrade!" + "\033[0m");
                player.levelUp();
            }
        }
    }

}
