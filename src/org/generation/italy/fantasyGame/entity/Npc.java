package org.generation.italy.fantasyGame.entity;

public class Npc extends Entity{
    private int expGain;
    private boolean canBeAttacked;

    public Npc(String name, int maxHp, int damage, int expGain, boolean canBeAttacked){
        super(name, maxHp, damage);
        this.expGain = expGain;
        this.canBeAttacked = canBeAttacked;
    }
    public void giveInstructions(int healthPoints, int maxHp){
        if(canBeAttacked){
            System.out.println("Let's fight");
        } else if(healthPoints < (maxHp * 0.5)){
            System.out.println("You should eat");
        } else{
            System.out.println("Fuck");
        }
    }
}
