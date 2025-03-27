package org.generation.italy.fantasyGame.startup;

import org.generation.italy.fantasyGame.entity.Entity;
import org.generation.italy.fantasyGame.entity.Npc;
import org.generation.italy.fantasyGame.entity.player.Wizard;

public class Start {
    public static void main(String[] args){
      //  Entity x = new Entity("Heike", 100);
      //  System.out.println(x.getName());
      //  Npc y = new Npc("Tizio" , 90, 10, false);
        Npc s = new Npc("Slime", 30, 5, 10, true);
        Wizard magomerlino = new Wizard("Merlino", 40, "Marcello");
        magomerlino.attack(s);
      //  y.giveInstructions(x.getHealthPoints(), x.getMaxHp());
    }
}
