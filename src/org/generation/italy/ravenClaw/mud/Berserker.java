package org.generation.italy.ravenClaw.mud;

import java.util.Random;

public class Berserker extends Player{
    public Berserker(String name, int maxHp, int attackDamage, String playerName){
        super(name, maxHp, attackDamage, playerName);
    }

    @Override
    public void attack(Entity attacked){
        int berserkChance = 10;
        int damageMade = getAttackDamage();
        Random dice = new Random();
        int x = dice.nextInt(berserkChance);
        if(x == 0){
            damageMade *= 2;
            System.out.println("Berserk mode activated.");
        }
        attacked.hurt(damageMade);
        System.out.printf("%s is attacking %s for %d damage", getName(), attacked.getName(), damageMade);
    }
}
