package org.generation.italy.edenGame.item;

import org.generation.italy.edenGame.entity.player.Player;
import org.generation.italy.ravenClaw.mud.objects.Item;

public class ErbaDiGatto extends Item {
    public ErbaDiGatto(String name, int value, int weight) {
        super(name, value, weight);
    }
    //TODO più vita
    public void use(Player player){
        System.out.println("Mangi della deliziosa erba gatta e recuperi 20 hp");
        player.setHealthPoints(player.getHealthPoints() + 5);
    }
}
