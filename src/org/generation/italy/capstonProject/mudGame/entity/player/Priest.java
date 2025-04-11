package org.generation.italy.capstonProject.mudGame.entity.player;

import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

public class Priest extends Player{
    private static final int MIN_STAMINA = 5;

    public Priest(String charName, Room currentRoom, String playerName) {
        super(charName, currentRoom, playerName, PlayerRole.PRIEST);
        setIntelligence(rand.nextInt(getMAX_INTELLIGENCE() + 1));
        setStrength(rand.nextInt(getMAX_STRENGTH() + 1));
        setAgility(rand.nextInt(getMAX_AGILITY() + 1));
        setStamina(rand.nextInt(MIN_STAMINA, getMAX_STAMINA() + 1));
    }
}
