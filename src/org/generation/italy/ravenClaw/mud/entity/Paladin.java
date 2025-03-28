package org.generation.italy.ravenClaw.mud.entity;

import java.util.Random;

public class Paladin extends Player {
    private boolean isVirgin = false;

    public Paladin(String name, int maxHp, int attackDamage, String playerName,String color){
        super(name,  maxHp,  attackDamage, playerName,color);

    }
    //attacco con lancia che dipende dal fatto che sia corrotto o meno
    @Override
    public void attack(Entity attacked){
        int damageMade = getAttackDamage();  //variabile modificabile che prende come minimo il danno dell'attaccante
        if (hasAttackSucceeded()) {
            attacked.hurt(damageMade);
            System.out.printf("%s%s is attacking with spear %s for %d damage%s\n",getEntityColor(), getName(), attacked.getName(), getAttackDamage(),getResetColor());
        }
        else {
            System.out.printf("%s%s failed to attack %s with spear because his heart is corrupted%s\n",getEntityColor(), getName(), attacked.getName(),getResetColor());
        }
    }
    //chance di colpire al 50% se corrotto
    private boolean hasAttackSucceeded(){
        if (isVirgin){
            return true;
        }
        int diceFaces = 2;
        Random random = new Random();
        return random.nextInt(diceFaces) > 0;
    }

    private void getCorrupted(){
        isVirgin = false;
        System.out.printf("%sThe heart of %s has been corrupted, there is no turning back%s\n ",getEntityColor(), getName(),getResetColor());
    }
    // se ha meno del 20% di vita viene corrotto
    public void attemptedCorruption(Npc npc){
        System.out.printf("%s%s is attempting to corrupt %s%s",getEntityColor(), npc.getName(), getName(),getResetColor());
        if (getHealthPoints() <= getMaxHp() * 0.2){
            getCorrupted();
        } else {
            System.out.printf("%sThe heart of %s remains pure... today.%s\n",getEntityColor() ,getName(),getResetColor());
        }
    }
    @Override
    public void printSheet(){
        String virgin;
        if(isVirgin){
            virgin = "you are a virgin";
        }else{
            virgin = "you are not a virgin";
        }
        System.out.printf("%syour name is %s the Paladin, you've got %d HP and your base damage is %d %s%s\n",getEntityColor() , this.getName(),this.getHealthPoints(),this.getAttackDamage(),virgin,getResetColor());
    }

    public boolean isVirgin() {
        return isVirgin;
    }


}
