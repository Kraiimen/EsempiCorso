package org.generation.italy.videogame.playerclasses;

import org.generation.italy.videogame.models.EntityType;
import org.generation.italy.videogame.models.Player;

public class Paladin extends Player {
    private boolean isVirgin;

    public Paladin(String playerName, EntityType entityType, int hpValue, boolean isVirgin){
        super(playerName, entityType, hpValue);
        this.isVirgin = isVirgin;
    }

    public void attackWithSpear(){
        System.out.println(getPlayerName() + " is attacking using the Spear!");
    }
}
