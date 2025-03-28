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
            System.out.println("Berserk mode activated.\n");
        }
        return damageMade;
    }

    @Override
    public void attack(Entity attacked){
        int damageMade = berserk();
        attacked.hurt(damageMade);
        System.out.printf("%s is attacking %s for %d damage\n", getName(), attacked.getName(), damageMade);
    }
    @Override
    public void printSheet(){
        System.out.printf("your name is %s the Berserker, you've got %d HP and your base damage is %d\n", this.getName(),this.getHealthPoints(),this.getAttackDamage());
    }
}
