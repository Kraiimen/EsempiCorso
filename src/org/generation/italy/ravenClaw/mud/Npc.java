package org.generation.italy.ravenClaw.mud;


public class Npc extends Entity{
    private int xpOnDeath;
    private boolean canBeAttacked;

    public Npc(String name, int maxHp, int attackDamage, int xpOnDeath, boolean canBeAttacked){
        super(name, maxHp, attackDamage);
        this.xpOnDeath = xpOnDeath;
        this.canBeAttacked = canBeAttacked;
    }
    public void giveInstructions(){
        if(canBeAttacked){
            System.out.println("Uccidimi ti prego attaccami fammi male");
        }else {
            System.out.println("noooo non uccidermi sono tuo amico ti voglio bene");
        }
    }

    public int getXpOnDeath() {
        return xpOnDeath;
    }

    public void setXpOnDeath(int xpOnDeath) {
        this.xpOnDeath = xpOnDeath;
    }

    public boolean getCanBeAttacked() {
        return canBeAttacked;
    }

    public void setCanBeAttacked(boolean canBeAttacked) {
        this.canBeAttacked = canBeAttacked;
    }
}
