package org.generation.italy.sudProject;

import org.generation.italy.sudProject.entities.Npc;
import org.generation.italy.sudProject.entities.mobTypes.mobs.Cat;
import org.generation.italy.sudProject.entities.mobTypes.PeacefulMob;
import org.generation.italy.sudProject.entities.mobTypes.mobs.Cultist;
import org.generation.italy.sudProject.entities.npcTypes.npcs.Guard;
import org.generation.italy.sudProject.itemManagement.Inventory;
import org.generation.italy.sudProject.map.Room;

import java.io.Console;
import java.util.Random;

import static org.generation.italy.sudProject.map.Room.*;


public abstract class Entity {
    // /--ATTRIBUTES--/
    protected static final int MAX_ATTRIBUTE_P_VALUE = 21;
    protected static final int MIN_ATTRIBUTE_P_VALUE = 8;
    protected static final int CLASS_STARTING_P_VALUE = 13;

    public static final int STRENGTH_INDEX = 0;
    public static final int DEXTERITY_INDEX = 1;
    public static final int CONSTITUTION_INDEX = 2;
    public static final int INTELLIGENCE_INDEX = 3;
    public static final int WISDOM_INDEX = 4;
    public static final int CHARISMA_INDEX = 5;

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public static Random dice = new Random();
    public Console console = System.console();


    public static int numberOfEntities;
    private Room entityPosition;
    private int indexEntityPosition;
    private String name;
    private int hp;
    private int maxHp;
    private int atk;
    private boolean canBeAttacked;
    protected Inventory entityInventory;
    protected int money;



    // /--CONSTRUCTORS--/
    public Entity(String name, int minStatValue, int maxStatValue, int indexClassStat, int classStat, int hp, int maxHp,
                  int BaseAtk, Room entityPosition, int indexEntityPosition, boolean canBeAttacked, int inventoryCap, int money){
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
        this.atk = BaseAtk;
        this.entityPosition = entityPosition;
        this.indexEntityPosition = indexEntityPosition;
        this.canBeAttacked = canBeAttacked;
        entityInventory = new Inventory(inventoryCap);
        this.money = money;
    }

    //--METHODS--/
    private static int[] getRandomStats(int[] stats, int minValue, int maxValue){
        for(int n : stats){
            n = dice.nextInt(minValue, maxValue);
        }
        return stats;
    }
    public void die(){
        entityPosition.getRoomEntities().get(CORPSE_INDEX).add(this);
        numberOfEntities--;
        entityPosition.getRoomEntities().get(indexEntityPosition).removeLast();
        switch (indexEntityPosition){
            case CAT_INDEX:
                Cat.numberOfCats--;
                PeacefulMob.numberOfPeacefulMobs--;
                break;
            case GUARD_INDEX:
                Guard.numberOfGuards--;
                Npc.numberOfNpcs--;
                break;
            case CULTIST_INDEX:
                Cultist.numberOfCultists--;
                break;
            default:
                System.out.println("Sei Morto");
                break;
        }
    }
    protected void regenerateHp(int amount){
        hp += amount;
        if(hp > maxHp){
            hp = maxHp;
        }
    }


    public boolean isDead(Entity e){
        return (e.getHp() <= 0);
    }
    public abstract void attack(Entity target);



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

    public Room getEntityPosition() {
        return entityPosition;
    }

    public int getIndexEntityPosition() {
        return indexEntityPosition;
    }

    public int getAtk() {
        return atk;
    }

    public boolean isCanBeAttacked() {
        return canBeAttacked;
    }

    public Inventory getEntityInventory() {
        return entityInventory;
    }
}
