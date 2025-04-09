package org.generation.italy.capstoneProject.models.npc;

public class Gattino extends NPC {
    public Gattino() {
        super("Gattino randagio indifeso", 10, 2, false);
    }

    @Override
    public void takeAction() {
        System.out.println("Il gattino ti fissa con occhi innocenti.");
    }
}
