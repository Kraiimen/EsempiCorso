package org.generation.italy.videogame.playerclasses;

import org.generation.italy.videogame.models.Player;

public class Wizard extends Player {
    private int intelValue;

    // COSTRUTTORE
    public Wizard(String name, int maxHP, int hpValue, String playerName, int intelValue){
        super(name, maxHP, hpValue, playerName);
        this.intelValue = intelValue;
    }

    // Lo stregone lancia una palla di fuoco per attaccare
    public void castFireBall(){
        System.out.println(getPlayerName() + " is casting Fire Ball!!");
    }

}
