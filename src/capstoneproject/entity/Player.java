package capstoneproject.entity;

import java.io.Console;


public abstract class Player extends Entity {
    private static final int MAX_INTELLIGENCE = 20;
    private static final int MAX_STAMINA = 20;
    private static final int MAX_AGILITY = 20;
    private static final int MAX_STRENGHT = 20;

    protected String playerName;
    protected int exp;
    protected int intelligence;
    protected int stamina;
    protected int agility;
    protected int strength;
    Console console;


    public Player(int maxHealt, int maxDamage, String playerName) {
        super(maxHealt, maxDamage);
        this.playerName = playerName;
        this.exp = exp;
        this.intelligence = intelligence;
        this.stamina = stamina;
        this.agility = agility;
        this.strength = strength;
    }

    public abstract void attack(Entity target);

    abstract void openInventory();

    public void runAway(){
        if(getHealthPoints() < 0.2){
            System.out.println("Lascia il combattimento");
        }
    };

    public void HealInTemple(){ //Funzione per ricaricarsi nel temple
        System.out.println("Healing in Temple");
        this.heal(5);
    }
    public void eat(){
        healMissingPercent(0.3);
        System.out.print("Ti sei ristorato" + getHealthPoints());
    }

    public void sleep(){
        healMissingPercent(0.2);
        System.out.print("Hai dormito" + getHealthPoints());
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

}
