package mud.characters.fightable;

import mud.CardinalPoints;
import mud.characters.Entity;
import mud.characters.fightable.monsters.Monster;
import mud.items.Item;

import java.util.Random;

public abstract class Character extends Entity {

//- Un programma che permette al giocatore di creare un suo personaggio -> mago, paladino, sacerdote o ladro
//- I personaggi avranno delle statistiche sulle loro abilità -> intelligenza, forza, agilità e stamina (tutte da 0 a 20)
//- Alla creazione del personaggio le statistiche verranno create in maniera random, tenendo presente la classe del personaggio

    public static Random dice = new Random();
    public static final int MIN = 0;
    public static final int MAX = 20;
    public static final int MAX_HP = 30;
    private int hp;
    private int intelligence;
    private int strength;
    private int agility;
    private int stamina;
    private int exp;
    private boolean isAlive = true;

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

    public void hurt(int damage){
        if((this.hp - damage) <= MIN){
            die();
        }
        this.hp = this.hp - damage;
    }
    public void heal(int heal) {
        if (heal > MIN) {
            if ((hp + heal) <= MAX_HP) {
                setHp(hp + heal);
            }
            setHp(MAX_HP);
            System.out.println("You're at full health.");
        }
    }

    public abstract void attack(Character character);

    public boolean tryToDodge() {
        if(dice.nextInt(MAX - getAgility() + 1)==0){
            return true;
        }
        return false;
    }

    public void die(){
        setHp(MIN);
        isAlive = false;
        getActualRoom().getPresentEntities().remove(this);
        System.out.println(getName() + " is dead.");
    }

    public abstract void respawn();


    //GETTER E SETTER

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        if(hp > MIN && hp <= MAX_HP){
        this.hp = hp;
        }
    }

    public boolean checkIfAlive() {
        return isAlive;
    }
    public void setIsAlive(boolean isAlive){
        this.isAlive = isAlive;
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
