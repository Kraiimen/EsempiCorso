package org.generation.italy.videogame.playerclasses;

import org.generation.italy.videogame.models.EntityType;
import org.generation.italy.videogame.models.Player;

import java.util.Random;

public class Berserker extends Player {

    public Berserker(String playerName, EntityType entityType, int hpValue){
        super(playerName, entityType, hpValue);
    }

    public void goBerserker(){

    }

    public int checkForLuck(){
        Random random = new Random();
        return random.nextInt(10);
    }
}
