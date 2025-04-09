package org.generation.italy.capstoneProject.models.npc;

public class Guard extends NPC {
    public Guard() {
        super("City guard", 100, 20, false);
    }

    @Override
    public void takeAction() {
        System.out.println("The guard is glaring you.");
    }
}
