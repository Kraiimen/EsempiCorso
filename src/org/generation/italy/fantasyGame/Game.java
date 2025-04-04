package org.generation.italy.fantasyGame;

import org.generation.italy.fantasyGame.entity.Entity;

public class Game {
    public void doCombat(Entity e1, Entity e2){
        e1.attack(e2);
        if(!e2.isDead()){
            e2.attack(e1);
        }
    }
}
