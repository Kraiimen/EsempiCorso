package org.generation.italy.ravenClaw.mud;

import java.util.Random;

public class Paladin extends Player {
    private boolean isVirgin = false;

    public Paladin(String name, int maxHp, int attackDamage, String playerName){
        super(name,  maxHp,  attackDamage, playerName);

    }
    //attacco con lancia che dipende dal fatto che sia corrotto o meno
    @Override
    public void attack(Entity attacked){
        int damageMade = getAttackDamage();  //variabile modificabile che prende come minimo il danno dell'attaccante
        if (hasAttackSucceeded()) {
            attacked.hurt(damageMade);
            System.out.printf("%s is attacking with spear %s for %d damage\n", getName(), attacked.getName(), getAttackDamage());
        }
        else {
            System.out.printf("%s failed to attack %s with spear because his heart is corrupted\n", getName(), attacked.getName());
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
        System.out.printf("The heart of %s has been corrupted, there is no turning back\n ",getName());
    }
    // se ha meno del 20% di vita viene corrotto
    public void attemptedCorruption(Npc npc){
        System.out.printf("%s is attempting to corrupt %s\n", npc.getName(), getName());
        if (getHealthPoints() <= getMaxHp() * 0.2){
            getCorrupted();
        } else {
            System.out.printf("The heart of %s remains pure... today.\n", getName());
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
        System.out.printf("your name is %s a Paladin, you've got %d HP and your base damage is %d %s\n", this.getName(),this.getHealthPoints(),this.getAttackDamage(),virgin);
    }

    public boolean isVirgin() {
        return isVirgin;
    }


}
