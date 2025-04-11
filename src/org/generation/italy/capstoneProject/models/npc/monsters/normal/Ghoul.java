package org.generation.italy.capstoneProject.models.npc.monsters.normal;

import org.generation.italy.capstoneProject.models.npc.monsters.Monster;

public class Ghoul extends Monster {
    public Ghoul() {
        super("Ghoul", 50, 10);
    }

    @Override
    public void takeAction() {
        System.out.println();
    }
}
