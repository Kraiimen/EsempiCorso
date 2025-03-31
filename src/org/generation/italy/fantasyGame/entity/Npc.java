package org.generation.italy.fantasyGame.entity;

public abstract class Npc extends Entity{
    private int expGain;
    private boolean canBeAttacked;
    private String generalInstructions;

    public Npc(String name, int maxHp, int damage, int expGain, boolean canBeAttacked,String generalInstructions){
        super(name, maxHp, damage);
        this.expGain = expGain;
        this.canBeAttacked = canBeAttacked;
        this.generalInstructions = generalInstructions;
    }
    public void giveInstructions(Entity target){
        if(canBeAttacked){
            System.out.println("Let's fight");
        } else if(target.isSeriouslyDamaged()){
            System.out.println("You should eat");
        } else{
            System.out.println(generalInstructions);
        }
    }
}
