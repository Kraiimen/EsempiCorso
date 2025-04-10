package sud.entity;

import sud.rooms.Room;
import sud.dices;

import java.util.Random;

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
        }
    }


        public void levelUp(){
        // @todo implementare i threshold per i livelli
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
}

