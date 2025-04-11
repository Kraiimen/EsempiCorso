package org.generation.italy.capstonProject.mudGame.entity.player;

import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

public class Thief extends Player{

    private static final int MIN_AGILITY = 5;

    public Thief(String charName, Room currentRoom, String playerName) {
        super(charName, currentRoom, playerName, PlayerRole.THIEF);
        setIntelligence(rand.nextInt(getMAX_INTELLIGENCE() + 1));
        setStrength(rand.nextInt(getMAX_STRENGTH() + 1));
        setAgility(rand.nextInt(MIN_AGILITY, getMAX_AGILITY() + 1));
        setStamina(rand.nextInt(getMAX_STAMINA() + 1));
    }
}
