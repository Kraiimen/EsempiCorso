package org.generation.italy.edenGame.entity.Enemies;

import org.generation.italy.edenGame.entity.Entity;
import org.generation.italy.edenGame.entity.player.Player;

public class Enemies extends Entity {

    public Enemies(String name, int maxHp, int healthPoints, int damage, int exp) {
        super(name, maxHp, healthPoints, damage, exp);
    }

    @Override
    public void dead() {
    }


}
