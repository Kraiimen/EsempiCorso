package org.generation.italy.capstoneProject.models.npc.monsters;

import org.generation.italy.capstoneProject.models.npc.NPC;

public abstract class Monster extends NPC {
    public Monster(String nome, int hp, int str) {
        super(" ", 10, 2, true);
    }

    @Override
    public void takeAction() {
        System.out.println(" ");
    }
}
