package org.generation.italy.fantasyGame.startup;

import org.generation.italy.fantasyGame.entity.Entity;
import org.generation.italy.fantasyGame.entity.Npc;

public class Start {
    public static void main(String[] args){
        Entity x = new Entity("Heike", 100);
        System.out.println(x.getName());
        Npc y = new Npc("Tizio" , 90, 10, false);
        y.giveInstructions(x.getHealthPoints(), x.getMaxHp());
    }
}
