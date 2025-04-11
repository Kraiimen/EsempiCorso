package org.generation.italy.edenGame.entity.npc;

import org.generation.italy.edenGame.entity.Entity;
import org.generation.italy.edenGame.entity.player.Player;

public class Npc extends Entity {
    public Npc(String name, int maxHp, int healthPoints, int damage, int exp) {
        super(name, maxHp, healthPoints, damage, exp);
    }

    @Override
    public void dead() {
    }

    public void speak(Player player) {
    }

}
