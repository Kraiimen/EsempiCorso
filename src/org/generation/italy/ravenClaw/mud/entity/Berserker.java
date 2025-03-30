package org.generation.italy.ravenClaw.mud.entity;

import java.util.Random;

public class Berserker extends Player{

    public Berserker(String name, int maxHp, int attackDamage, String playerName,String color){
        super(name, maxHp, attackDamage, playerName,color);
    }

    private int berserk(){
        int berserkChance = 10;
        int damageMade = getAttackDamage();
        Random dice = new Random();
        int x = dice.nextInt(berserkChance);
        if(x == 0){
            damageMade *= 2;
            System.out.printf("%sBerserk mode activated.%s\n",getEntityColor(),getResetColor());
        }
        return damageMade;
    }

    @Override
    public void attack(Entity attacked){
        int damageMade = berserk();
        attacked.hurt(damageMade);
        System.out.printf("%s%s is attacking %s for %d damage%s\n",getEntityColor(), getName(), attacked.getName(), damageMade, getResetColor());
    }
    @Override
    public void printSheet(){
        System.out.printf("%syour name is %s the Berserker, you've got %d HP and your base damage is %d%s\n",getEntityColor(), this.getName(),this.getHealthPoints(),this.getAttackDamage(),getResetColor());
    }
}
