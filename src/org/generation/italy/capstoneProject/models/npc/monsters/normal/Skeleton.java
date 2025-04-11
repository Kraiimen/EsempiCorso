package org.generation.italy.capstoneProject.models.npc.monsters.normal;

import org.generation.italy.capstoneProject.models.npc.monsters.Monster;

public class Skeleton extends Monster {
    public Skeleton() {
        super("Skeleton", 30, 8);
    }

    @Override
    public void takeAction() {
        System.out.println();
    }
}
