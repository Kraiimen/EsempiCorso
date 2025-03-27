package org.generation.italy.videogame.models;

public class Npc extends Entity{
    private int expGivenWhenKilled;
    private boolean canBeAttacked;

    public Npc(EntityType entityType, int hpValue, int expGivenWhenKilled, boolean canBeAttacked){
        super(entityType, hpValue);
        this.expGivenWhenKilled = expGivenWhenKilled;
        this.canBeAttacked = canBeAttacked;
    }

    public void showActionsMenu(){
        if(canBeAttacked){
            System.out.println("----------------");
            System.out.println("| 1. Attack    |");
            System.out.println("| 2. Run AWAY! |");
            System.out.println("----------------");
        } else{
            System.out.println("----------------");
            System.out.println("| 1. Talk      |");
            System.out.println("| 2. Leave     |");
            System.out.println("----------------");
        }
    }
}
