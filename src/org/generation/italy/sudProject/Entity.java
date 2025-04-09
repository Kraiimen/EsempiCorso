package org.generation.italy.sudProject;

import java.util.Random;

public abstract class Entity {
    // /--ATTRIBUTES--/
    protected static final int MAX_ATTRIBUTE_P_VALUE = 21;
    protected static final int MIN_ATTRIBUTE_P_VALUE = 8;
    protected static final int CLASS_STARTING_P_VALUE = 13;
    protected int strength;
    protected int dexterity;
    protected int constitution;
    protected int intelligence;
    protected int wisdom;
    protected int charisma;
    public static Random dice = new Random();

    // /--CONSTRUCTORS--/
    public Entity(int[] stats, indice, valore){
        stats[indice] = valore;
        strength = stats[0];
        dexterity = stats[1];
        constitution = stats[2];
        intelligence = stats[3];
        wisdom = stats[4];
        charisma = stats[5];
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
