package org.generation.italy.capstonProject.mudGame.entity.npc;

import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

public class Guard extends Npc{
    public Guard(String charName, int maxHP, Room currentRoom) {
        super(charName, maxHP, 10, currentRoom, false, NpcRole.GUARD);
    }

}
