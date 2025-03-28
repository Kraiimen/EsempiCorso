package org.generation.italy.videogame.playerclasses;

import org.generation.italy.videogame.models.Player;

public class Paladin extends Player {
    private boolean isVirgin;

    // COSTRUTTORE
    public Paladin(String name, int maxHP, int hpValue, String playerName, boolean isVirgin){
        super(name, maxHP, hpValue, playerName);
        this.isVirgin = isVirgin;
    }

    // Il paladino usa la lancia per attaccare
    public void attackWithSpear(){
        System.out.println(getPlayerName() + " is attacking using the Spear!");
    }
}
