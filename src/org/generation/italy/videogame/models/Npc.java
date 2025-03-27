package org.generation.italy.videogame.models;

public class Npc extends Entity{
    private long expGivenWhenKilled;
    private boolean canBeAttacked;

    // COSTRUTTORE
    public Npc(String name, int maxHP, int hpValue, int expGivenWhenKilled, boolean canBeAttacked){
        super(name, maxHP, hpValue);
        this.expGivenWhenKilled = expGivenWhenKilled;
        this.canBeAttacked = canBeAttacked;
    }

    // Menù delle interazioni con l'NPC
    public void showActionsMenu(){
        if(canBeAttacked){
            System.out.println("NPC: "+getName());
            System.out.println("----------------");
            System.out.println("| 1. Attack    |");
            System.out.println("| 2. Run AWAY! |");
            System.out.println("----------------");
        } else{
            System.out.println("NPC: "+getName());
            System.out.println("----------------");
            System.out.println("| 1. Talk      |");
            System.out.println("| 2. Leave     |");
            System.out.println("----------------");
        }
    }
}
