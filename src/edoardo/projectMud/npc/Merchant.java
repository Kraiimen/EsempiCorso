package edoardo.projectMud.npc;

import edoardo.projectMud.items.Item;

import java.util.ArrayList;

public class Merchant extends Npc {
    private ArrayList<Item> itemsToSell;

    public Merchant(String name, int strength, int maxHp, double money) {
        super(name, strength, maxHp, money);
    }

    public Merchant(){
        super();
    }

    //    public Item sellItem() {
//
//    }
}
