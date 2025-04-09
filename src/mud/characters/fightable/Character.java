package mud.characters.fightable;

import mud.characters.Entity;

import java.util.Random;

public abstract class Character extends Entity {

//- Un programma che permette al giocatore di creare un suo personaggio -> mago, paladino, sacerdote o ladro
//- I personaggi avranno delle statistiche sulle loro abilità -> intelligenza, forza, agilità e stamina (tutte da 0 a 20)
//- Alla creazione del personaggio le statistiche verranno create in maniera random, tenendo presente la classe del personaggio

    public static Random dice = new Random();
    private static final int MAX = 20;
    private String name;
    private int intelligence;
    private int strenght;
    private int agility;
    private int stamina;
    private int exp;

    public Character(String name, int minIntelligence, int minStrenght, int minAgility, int minStamina){
        this.name = name;
        this.intelligence = dice.nextInt(minIntelligence, MAX);
        this.strenght = dice.nextInt(minStrenght, MAX);
        this.agility = dice.nextInt(minAgility, MAX);
        this.stamina = dice.nextInt(minStamina, MAX);

    }



}
