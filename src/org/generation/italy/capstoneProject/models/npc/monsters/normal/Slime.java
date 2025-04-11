package org.generation.italy.capstoneProject.models.npc.monsters.normal;

import org.generation.italy.capstoneProject.models.npc.monsters.Monster;

public class Slime extends Monster {
    public Slime() {
        super("Slime", 20, 4);
    }

    @Override
    public void takeAction() {
        System.out.println();
    }
}
