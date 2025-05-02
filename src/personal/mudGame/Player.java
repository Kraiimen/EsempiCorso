package personal.mudGame;

import personal.mudGame.items.Item;
import personal.mudGame.items.ItemType;
import personal.mudGame.items.Shield;
import personal.mudGame.items.Weapon;

import java.util.ArrayList;

public class Player extends Entity {
    private String playerName;
    private int exp = 0;
    private int protection = 0;
    private ArrayList<Item> inventory = new ArrayList<Item>();

    //COSTRUTTORE
    public Player(String name, int maxHP, int power, String playerName){
        super(name, maxHP, power);
        this.playerName = playerName;
    }


    public void pickItem(Item item){
        inventory.add(item);
        if (item.getItemType() == ItemType.WEAPON){
            Weapon weapon = (Weapon)item;
            addPowerPlus(weapon);
        } else if(item.getItemType() == ItemType.SHIELD){
            Shield shield = (Shield)item;
            addProtection(shield);
        }
    }

    //FUNZIONI BOOST DAGLI ITEM
    public void addExp(NPC npc){
        exp += npc.getExpGiven();
    }
    public void addPowerPlus(Weapon weapon){
        setPower(getPower()+ weapon.getPowerPlus());
    }
    public void addProtection(Shield shield){
        setProtection(getProtection() + shield.getPlusProtection());
    }

    //GETTER E SETTER
    public String getPlayerName(){ return playerName; }

    public int getExp(){ return exp; }
    public void setExp(int exp){ this.exp = exp; }

    public int getProtection(){ return protection; }
    public void setProtection(int protection){ this.protection = protection; }

    public ArrayList getInventory(){ return inventory; }
}
