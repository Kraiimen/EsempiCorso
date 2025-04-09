package org.generation.italy.sudProject;

public class Entity {
    // /--ATTRIBUTES--/
    private static final int MAX_ATTRIBUTE_VALUE = 20;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    // /--CONSTRUCTORS--/
    public Entity(int[] stats){
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
