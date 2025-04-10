package sud.entity;

import sud.items.*;
import sud.rooms.*;
import sud.dices;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Mob extends Entity{
    private int damagereduction;
    private ArrayList<Item> carriedItems = new ArrayList<>();
    private int level = 1 ;
    public static Map<String, Mob> mobMap = new HashMap<>();

    public Mob(Room currentroom, String name, int maxHp, int attackDamage, int xpOnDeath, int damagereduction, ArrayList<Item> carriedItems, int level){
        super( name, maxHp, attackDamage, currentroom, xpOnDeath, Entity.colorR);
        this.carriedItems = carriedItems;
        this.damagereduction = damagereduction;
        this.level = level;
    }

    public Mob(String name, int maxHp, int attackDamage, int xpOnDeath, int damagereduction, ArrayList<Item> carriedItems, int level) {
        super( name, maxHp, attackDamage, null, xpOnDeath, Entity.colorR);
        this.damagereduction = damagereduction;
        this.carriedItems = carriedItems;
        this.setAttackDamage((getAttackDamage()* this.level) + dices.rd10()-5);
    }

    static{
        ArrayList<Item> vuoto = new ArrayList<>();
        Mob critter = new Mob("Critter", 10, 5, 10, 0, vuoto, 0);
        mobMap.put("Critter", critter);
        Mob goblin = new Mob("Goblin", 15, 10, 20, 0, vuoto, 1);
        mobMap.put("Goblin", goblin);
        Mob bugBear = new Mob("Bugbear", 30, 15, 40, 3, vuoto, 2);
        mobMap.put("Bugbear", bugBear);
        Mob ogre = new Mob("Ogre", 50, 15, 100, 5, vuoto, 3);
        mobMap.put("Ogre", ogre);
        Mob boss = new Mob("Landrodol The Warlord", 100, 20, 200, 5, vuoto, 4);
        mobMap.put("Boss", boss);
    }

    public int getDamagereduction() {
        return damagereduction;
    }

    public void setDamagereduction(int damagereduction) {
        this.damagereduction = damagereduction;
    }

    public ArrayList<Item> getCarriedItems() {
        return carriedItems;
    }

    public void setCarriedItems(ArrayList<Item> carriedItems) {
        this.carriedItems = carriedItems;
    }

    public static Map<String, Mob> getMobMap() {
        return mobMap;
    }
}
