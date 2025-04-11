package org.generation.italy.capstonProject.mudGame.entity.player;

import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

public class Paladin extends Player{

    private static final int MIN_STRENGTH = 5;

    public Paladin(String charName, Room currentRoom, String playerName) {
        super(charName, currentRoom, playerName, PlayerRole.PALADIN);
        setIntelligence(rand.nextInt(getMAX_INTELLIGENCE() + 1));
        setStrength(rand.nextInt(MIN_STRENGTH, getMAX_STRENGTH() + 1));
        setAgility(rand.nextInt( getMAX_AGILITY() + 1));
        setStamina(rand.nextInt(getMAX_STAMINA() + 1));
    }
}
