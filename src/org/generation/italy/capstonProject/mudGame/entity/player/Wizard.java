package org.generation.italy.capstonProject.mudGame.entity.player;

import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

public class Wizard extends Player{
    private static final int MIN_INTELLIGENCE = 5;

    public Wizard(String charName, Room currentRoom, String playerName) {
        super(charName, currentRoom, playerName, PlayerRole.WIZARD);
        this.setIntelligence(rand.nextInt(MIN_INTELLIGENCE, getMAX_INTELLIGENCE() + 1));
        this.setStrength(rand.nextInt(getMAX_STRENGTH() + 1));
        this.setAgility(rand.nextInt(getMAX_AGILITY() + 1));
        this.setStamina(rand.nextInt(getMAX_STAMINA() + 1));
    }
}
