package org.generation.italy.edenGame.item;

import org.generation.italy.edenGame.entity.player.Player;
import org.generation.italy.ravenClaw.mud.objects.Item;

public class SpadaDiEden extends Item {
    public SpadaDiEden(String name, int value, int weight) {
        super(name, value, weight);
    }
    public void use(Player player){
        System.out.println("Trovi miracolosamente la leggendaria spada di eden. La impugni e ti senti invincibile");
        player.setDamage(300);
        player.setMaxHp(300);
        player.setHealthPoints(300);
    }
}
