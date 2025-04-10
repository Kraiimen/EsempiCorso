package sud.entity;

import sud.items.Armor;
import sud.items.Item;
import sud.items.ItemType;
import sud.items.Weapon;
import sud.rooms.Room;
import sud.dices;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Player extends Entity{
    private int intelligence;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intMod;
    private int strMod;
    private int dexMod;
    private int conMod;
    private int xp;
    private int coins;
    private int level;

    public Player(String name, int maxHp, String entityColor, String chosenClass) {
        super(name, maxHp, 0, Room.getRoomPointerFromName("castle"), entityColor);
        switch (chosenClass){
            case "wizard" ->{
                this.intelligence = isScoreOk(10+dices.rd10());
                this.strength = isScoreOk(dices.rd6()+dices.rd6()+dices.rd6());
                this.dexterity = isScoreOk(dices.rd6()+dices.rd6()+dices.rd6());
                this.constitution = isScoreOk(dices.rd6()+dices.rd6()+dices.rd6());
            }
            case "fighter" ->{
                this.strength = isScoreOk(10+dices.rd10());
                this.intelligence = isScoreOk(dices.rd6()+dices.rd6()+dices.rd6());
                this.dexterity = isScoreOk(dices.rd6()+dices.rd6()+dices.rd6());
                this.constitution = isScoreOk(dices.rd6()+dices.rd6()+dices.rd6());
            }
            case "rogue" ->{
                this.dexterity = isScoreOk(10+dices.rd10());
                this.intelligence = isScoreOk(dices.rd6()+dices.rd6()+dices.rd6());
                this.strength = isScoreOk(dices.rd6()+dices.rd6()+dices.rd6());
                this.constitution = isScoreOk(dices.rd6()+dices.rd6()+dices.rd6());
            }
            case "barbarian" ->{
                this.constitution = isScoreOk(10+dices.rd10());
                this.intelligence = isScoreOk(dices.rd6()+dices.rd6()+dices.rd6());
                this.dexterity = isScoreOk(dices.rd6()+dices.rd6()+dices.rd6());
                this.strength = isScoreOk(dices.rd6()+dices.rd6()+dices.rd6());
            }
        }
        this.conMod = (this.constitution - 10)/2;
        this.intMod = (this.intelligence - 10)/2;
        this.strMod = (this.strength - 10)/2;
        this.dexMod = (this.dexterity - 10)/2;
        this.setAttackDamage(1+strMod);
        this.setMaxHp(maxHp+conMod);
        this.level =1;

    }

    private int isScoreOk (int score){
        if(score < 0 || score >20){
            return 10;
        }else{
            return score;
        }
    }

    @Override
    public void attack (Entity attacked) {
        int damage = 0;
        int roll = dices.rd20();
        if (roll == 20) {
            damage = this.getEquipedWeapon().rollDamage() * 2;
        } else if (roll == 1) {
            System.out.printf(this.getEntityColor() + "Your attack was soo weak %s uses the opportunity and attacks you" + resetColor, attacked.getName());
            attacked.attack(this);
        } else if (doesAttackRollHit(attacked, roll)) {
            damage = this.getEquipedWeapon().rollDamage();
        }

        System.out.printf(this.getEntityColor() + "%s is attacking %s for %d damage\n " + resetColor, this.getName(), attacked.getName(), damage);
        attacked.hurt(damage + this.strMod);
        if (attacked.isDead()) {
            System.out.println(this.getEntityColor() + attacked.getName() + " has died by that hit\n " + resetColor);
            this.setXp(this.getXp()+attacked.getXpOnDeath());
        }
    }


        public void levelUp() {
            if (xp >= 50) {
                if (level < 2) {
                    level = 2;
                }
            } else if (xp >= 100) {
                if (level < 3) {
                    level = 3;
                }
            } else if (xp >= 200) {
                if (level < 4) {
                    level = 4;
                }
            } else if (xp >= 400) {
                if (level < 5) {
                    level = 5;
                }
            }
        }

        @Override
        public void pickUpItem (Item item, Boolean wantToEquip){
            switch (item.getType()){
                case ARMOR -> {
                    AtomicInteger numOfItem= new AtomicInteger();
                    this.getInventory().forEach(item1 -> {
                        if (item1.getType() == ItemType.ARMOR) {
                            numOfItem.getAndIncrement();
                        }
                    });

                    if(numOfItem.get()<=2)
                    {
                        if(wantToEquip){this.setEquipedArmor((Armor)item);}
                        this.getInventory().add(item);
                        Item.itemMap.remove(item.getName());
                    }
                }
                case WEAPON -> {
                    AtomicInteger numOfItem= new AtomicInteger();
                    this.getInventory().forEach(item1 -> {
                        if (item1.getType() == ItemType.WEAPON) {
                            numOfItem.getAndIncrement();
                        }
                    });
                    if(numOfItem.get()<=3){
                        if(wantToEquip){this.setEquipedWeapon((Weapon)item);}
                        this.getInventory().add(item);
                        Item.itemMap.remove(item.getName());
                    }

                }
                case FOOD -> {
                    AtomicInteger numOfItem= new AtomicInteger();
                    this.getInventory().forEach(item1 -> {
                        if (item1.getType() == ItemType.FOOD) {
                            numOfItem.getAndIncrement();
                        }
                    });
                    if(numOfItem.get()<=5){this.getInventory().add(item);}
                    Item.itemMap.remove(item.getName());
                }

                case POTION -> {
                    AtomicInteger numOfItem= new AtomicInteger();
                    this.getInventory().forEach(item1 -> {
                        if (item1.getType() == ItemType.POTION) {
                            numOfItem.getAndIncrement();
                        }
                    });
                    if(numOfItem.get()<=5){this.getInventory().add(item);}
                    Item.itemMap.remove(item.getName());
                    }
                case JUNK -> {
                    AtomicInteger numOfItem= new AtomicInteger();
                    this.getInventory().forEach(item1 -> {
                        if (item1.getType() == ItemType.JUNK) {
                            if(item1.getName().equalsIgnoreCase("coins")){
                                this.coins += item1.getPrice();
                            }
                            numOfItem.getAndIncrement();
                        }
                    });
                    if(numOfItem.get()<=10){
                        this.getInventory().add(item);
                        Item.itemMap.remove(item.getName());
                    }

                }
            }

        }

    public int getIntMod() {
        return intMod;
    }

    public void setIntMod(int intMod) {
        this.intMod = intMod;
    }

    public int getStrMod() {
        return strMod;
    }

    public void setStrMod(int strMod) {
        this.strMod = strMod;
    }

    public int getDexMod() {
        return dexMod;
    }

    public void setDexMod(int dexMod) {
        this.dexMod = dexMod;
    }

    public int getConMod() {
        return conMod;
    }

    public void setConMod(int conMod) {
        this.conMod = conMod;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

