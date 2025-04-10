package org.generation.italy.fantasyGame;

import org.generation.italy.fantasyGame.entity.Entity1;

public class Game {
    public void doCombat(Entity1 e1, Entity1 e2){
        e1.attack(e2);
        if(!e2.isDead()){
            e2.attack(e1);
        }
    }
}
