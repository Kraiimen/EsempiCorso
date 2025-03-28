package org.generation.italy.gryffindor.mud.startup;

import org.generation.italy.gryffindor.mud.game.*;

public class Start {
    public static void main(String[] args){
        Paladin p = new Paladin("Paladin", 200, 10, "Spalmen", true);
        Wizard w = new Wizard("Wizard", 80, 10, "Pagapollo", 99);
        Berserker b = new Berserker("Berserker", 120, 10, "Heracles");
        Npc villager = new Npc("Villager", 10000000, 100000, 0, false, NpcInstruction.SPEAK);
        Npc goblin = new Npc("Goblin", 35, 6, 5, true, NpcInstruction.ATTACK);

        System.out.println("Inizia il combattimento nel villaggio\n");
        p.attack(goblin);
        p.attackWithLance();

        w.attack(goblin);
        w.castFireBall();

        b.attack(villager);
        villager.giveInstructions();

        goblin.giveInstructions();
        goblin.attack(p);
        System.out.println();

        goblin.attack(p);
        p.attack(goblin);
        w.attack(goblin);
        b.attack(w);
        System.out.println();

        System.out.println("Paladin exp: " + p.getCurrentExpPoint());
        System.out.println("Wizard exp: " + w.getCurrentExpPoint());
        System.out.println("Berserk exp: " + b.getCurrentExpPoint());
        System.out.println();

        System.out.println("Paladin Max HP: " + p.getMaxHealthPoint());
        System.out.println("Paladin HP: " + p.getCurrentHealthPoint());
        System.out.println();

        System.out.println("Wizard Max HP: " + w.getMaxHealthPoint());
        System.out.println("Wizard HP: " + w.getCurrentHealthPoint());
        System.out.println();

        System.out.println("Berserk Max HP: " + b.getMaxHealthPoint());
        System.out.println("Berserk HP: " + b.getCurrentHealthPoint());
        System.out.println();

        System.out.println("il party va a mangiare");
        System.out.println();
        p.eat();
        w.eat();
        b.eat();

        System.out.println("Paladin Max HP: " + p.getMaxHealthPoint());
        System.out.println("Paladin HP: " + p.getCurrentHealthPoint());
        System.out.println();

        System.out.println("Wizard Max HP: " + w.getMaxHealthPoint());
        System.out.println("Wizard HP: " + w.getCurrentHealthPoint());
        System.out.println();

        System.out.println("Berserk Max HP: " + b.getMaxHealthPoint());
        System.out.println("Berserk HP: " + b.getCurrentHealthPoint());
        System.out.println();

        System.out.println("il party va a dormire");
        System.out.println();
        p.sleep();
        w.sleep();
        b.sleep();

        System.out.println("Paladin Max HP: " + p.getMaxHealthPoint());
        System.out.println("Paladin HP: " + p.getCurrentHealthPoint());
        System.out.println();

        System.out.println("Wizard Max HP: " + w.getMaxHealthPoint());
        System.out.println("Wizard HP: " + w.getCurrentHealthPoint());
        System.out.println();

        System.out.println("Berserk Max HP: " + b.getMaxHealthPoint());
        System.out.println("Berserk HP: " + b.getCurrentHealthPoint());
        System.out.println();

    }
}
