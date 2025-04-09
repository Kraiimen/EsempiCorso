package mud.characters.fightable;

import mud.CardinalPoints;
import mud.characters.Entity;

import java.util.Random;

public abstract class Character extends Entity {

//- Un programma che permette al giocatore di creare un suo personaggio -> mago, paladino, sacerdote o ladro
//- I personaggi avranno delle statistiche sulle loro abilità -> intelligenza, forza, agilità e stamina (tutte da 0 a 20)
//- Alla creazione del personaggio le statistiche verranno create in maniera random, tenendo presente la classe del personaggio

    public static Random dice = new Random();
    public static final int MIN = 0;
    public static final int MAX = 20;
    private int intelligence;
    private int strength;
    private int agility;
    private int stamina;
    private int exp;

    public Character(String name){
        super(name);
    }
    public Character(String name, int minIntelligence, int minStrength, int minAgility, int minStamina){
        super(name);
        this.intelligence = dice.nextInt(minIntelligence, MAX);
        this.strength = dice.nextInt(minStrength, MAX);
        this.agility = dice.nextInt(minAgility, MAX);
        this.stamina = dice.nextInt(minStamina, MAX);

    }

    public void changeRoom(CardinalPoints cardinal){
        if(getActualRoom().getDirections().containsKey(cardinal)) {
            getActualRoom().getPresentEntities().remove(this);
            getActualRoom().getDirections().get(cardinal).enterInRoom(this);
        }
    }


    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strenght) {
        this.strength = strenght;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
