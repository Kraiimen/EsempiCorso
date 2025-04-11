package org.generation.italy.capstonProject.mudGame.entity.npc;

import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

public class Vendor extends Npc{
    public Vendor(String charName, int maxHP, int maxDamage, Room currentRoom, boolean isHostile, NpcRole role) {
        super(charName, maxHP, maxDamage, currentRoom, isHostile, role);
        getMessages().add("Ehi compare. Vuoi comprare una meridiana?");
    }

    public void seeShop() {

    }
}
