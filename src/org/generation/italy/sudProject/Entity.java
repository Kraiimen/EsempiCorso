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

    protected int strength;
    protected int dexterity;
    protected int constitution;
    protected int intelligence;
    protected int wisdom;
    protected int charisma;
    public static Random dice = new Random();

    // /--CONSTRUCTORS--/
    public Entity(int[] stats, int indexClassStat, int classStat){
        stats[indexClassStat] = classStat;
        strength = stats[STRENGTH_INDEX];
        dexterity = stats[DEXTERITY_INDEX];
        constitution = stats[CONSTITUTION_INDEX];
        intelligence = stats[INTELLIGENCE_INDEX];
        wisdom = stats[WISDOM_INDEX];
        charisma = stats[CHARISMA_INDEX];
    }

    //--METHODS--/


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
}
