package edoardo.projectMud.npc;

import edoardo.projectMud.Entity;
import edoardo.projectMud.items.Item;

public abstract class Npc extends Entity {
    private int expToDeath;
    private double moneyToDeath;
    private Item itemToDeath; // potrei fare un arraylist static da cui far scegliere

    public Npc(String name, int strength, int maxHp, double money) {
        super(name, strength, maxHp, money);
    }
    public Npc(int strengthClassBonus, int startStrengthMax, int hpClassBonus, int startMaxHp, double moneyClassBonus, double moneyMaxBonus ){
        super();
        setStrength(randomizeStrength( strengthClassBonus, startStrengthMax));
        setHp(randomizeHealth(hpClassBonus, startMaxHp));
        moneyToDeath =  randomizeMoneyToDeath(moneyClassBonus, moneyMaxBonus);
    }

    public int getExpToDeath() {
        return expToDeath;
    }
    public double getMonetYoDeath(){
        return moneyToDeath;
    }

    public void setExpToDeath(int expToDeath) {
        this.expToDeath = expToDeath;
    }
    private double randomizeMoneyToDeath(double moneyClassBonus, double moneyMaxBonus){
        return getRandom().nextDouble(moneyMaxBonus-moneyClassBonus +1) + moneyClassBonus;
    }
    private int randomizeStrength( int strengthClassBonus, int startStrengthMax){
       return getRandom().nextInt(startStrengthMax-strengthClassBonus +1) + strengthClassBonus;
    }
    private int randomizeHealth( int hpClassBonus, int startMaxHp){
        return getRandom().nextInt(startMaxHp-hpClassBonus +1) + hpClassBonus;
    }
    private Item randomizeItem(){
        return new Item(0,"ciao");
    }

}
