package org.generation.italy.videogame.start;

import org.generation.italy.videogame.models.Npc;
import org.generation.italy.videogame.playerclasses.Berserker;
import org.generation.italy.videogame.playerclasses.Paladin;
import org.generation.italy.videogame.playerclasses.Wizard;

public class Main {
    public static void main(String[] args) {
        Berserker b = new Berserker("Gigging", 2000, 2000,"Kaiman");
        Wizard w = new Wizard("Francs", 1000,1000, "ILoveBoobs", 80085);
        Paladin p = new Paladin("Gesa", 33,1,"Jesus", true);
        Npc npc = new Npc("NPC", 1,1,10000000, true);
        Npc npc2 = new Npc("NPC2", 1,1,1, false);

        b.logIn();
        w.logIn();
        p.logIn();
        System.out.println();

        p.healHP(1000000);
        b.attackEntity(w);
        w.sleep();
        b.takeDamage(1000);
        b.eat();
        System.out.println();

        npc.showActionsMenu();
        npc2.attackEntity(npc);
        npc2.showActionsMenu();
        System.out.println();

        b.logOut();
        w.logOut();
        p.logOut();
    }
}
