package org.generation.italy.capstoneProject.models.npc.monsters.normal;

import org.generation.italy.capstoneProject.models.npc.monsters.Monster;

public class Vampire extends Monster {
    public Vampire() {
        super("Vampire", 100, 20);
    }

    @Override
    public void takeAction() {
        System.out.println();
    }
}
