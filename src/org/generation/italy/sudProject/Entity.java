package org.generation.italy.sudProject;

import java.util.Random;

public abstract class Entity {
    // /--ATTRIBUTES--/
    protected static final int MAX_ATTRIBUTE_P_VALUE = 21;
    protected static final int MIN_ATTRIBUTE_P_VALUE = 8;
    protected static final int CLASS_STARTING_P_VALUE = 13;

    protected static final int STRENGTH_INDEX = 0;
    protected static final int DEXTERITY_INDEX = 1;
    protected static final int CONSTITUTION_INDEX = 2;
    protected static final int INTELLIGENCE_INDEX = 3;
    protected static final int WISDOM_INDEX = 4;
    protected static final int CHARISMA_INDEX = 5;

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    public static Random dice = new Random();
    public static int numberOfEntities;

    private String name;
    private int hp;
    private int maxHp;


    // /--CONSTRUCTORS--/
    public Entity(String name, int minStatValue, int maxStatValue, int indexClassStat, int classStat, int hp, int maxHp){
        int[] stats = getRandomStats(new int[6], minStatValue, maxStatValue);
        if(indexClassStat >= 0){
            stats[indexClassStat] = classStat;
        }
        strength = stats[STRENGTH_INDEX];
        dexterity = stats[DEXTERITY_INDEX];
        constitution = stats[CONSTITUTION_INDEX];
        intelligence = stats[INTELLIGENCE_INDEX];
        wisdom = stats[WISDOM_INDEX];
        charisma = stats[CHARISMA_INDEX];
        this.name = name;
        numberOfEntities++;
        this.hp = hp;
        this.maxHp = maxHp;
    }

    //--METHODS--/
    private static int[] getRandomStats(int[] stats, int minValue, int maxValue){
        for(int n : stats){
            n = dice.nextInt(minValue, maxValue);
        }
        return stats;
    }

    // /--GETTER-&-SETTER--/

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public static int getNumberOfEntities() {
        return numberOfEntities;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }
}
