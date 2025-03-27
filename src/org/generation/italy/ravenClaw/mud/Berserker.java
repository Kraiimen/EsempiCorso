package org.generation.italy.ravenClaw.mud;

import java.util.Random;

public class Berserker extends Player{
    public Berserker(String name, int maxHp, int attackDamage, String playerName){
        super(name, maxHp, attackDamage, playerName);
    }

    private int berserk(){
        int berserkChance = 10;
        int damageMade = getAttackDamage();
        Random dice = new Random();
        int x = dice.nextInt(berserkChance);
        if(x == 0){
            damageMade *= 2;
            System.out.println("Berserk mode activated.");
        }
        return damageMade;
    }

    @Override
    public void attack(Entity attacked){
        int damageMade = berserk();
        attacked.hurt(damageMade);
        System.out.printf("%s is attacking %s for %d damage", getName(), attacked.getName(), damageMade);
    }
}
