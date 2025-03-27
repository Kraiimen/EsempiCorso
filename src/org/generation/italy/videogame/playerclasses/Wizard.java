package org.generation.italy.videogame.playerclasses;

import org.generation.italy.videogame.models.EntityType;
import org.generation.italy.videogame.models.Player;

public class Wizard extends Player {
    private final int MIN_INTEL_VALUE = 0;
    private final int MAX_INTEL_VALUE = 100;
    private int intelValue;

    public Wizard(String playerName, EntityType entityType, int hpValue, int intelValue){
        super(playerName, entityType, hpValue);
        this.intelValue = intelValue;
    }

    public void castFireBall(){
        System.out.println(getPlayerName() + " is casting Fire Ball!!");
    }

}
