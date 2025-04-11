package org.generation.italy.mud.codebreaker.inventory;

import org.generation.italy.mud.codebreaker.inventory.items.Item;

import java.util.ArrayList;

public class Inventory {
    private static int[] ITEM_CURRENTY_QTY = {0,0,0,0};
    private static final int MAX_ITEMS_FOR_TYPE = 3;
    private static final int MAX_SLOT_IN_INVENTORY = 4;
    private int quantity;
    private ArrayList<Item> itemSlot = new ArrayList<>();


    public void manageAddItems(Item foundItem){
        if(addItemToArray(foundItem)){
            System.out.println("Hai trovato: " + foundItem );
        }
        if(increaseItemQty(foundItem)){
            System.out.println("Hai aggiunto una: " + foundItem + " al tuo inventario");
        }
        if(!increaseItemQty(foundItem) && !addItemToArray(foundItem)){
            System.out.println("Il tuo inventario è pieno");
        }


    }
    public boolean addItemToArray(Item foundItem){
        if(itemSlot.size() <= MAX_SLOT_IN_INVENTORY){
            itemSlot.add(foundItem);
            return true;
        } else {
            return false;
        }

    }

    public boolean increaseItemQty(Item foundItem) {
        for (int i = 1; i <= MAX_SLOT_IN_INVENTORY; i++) {
            if(itemSlot.get(i).getName().equals(foundItem.getName()) && ITEM_CURRENTY_QTY[i] <= MAX_ITEMS_FOR_TYPE) {
                ITEM_CURRENTY_QTY[i]++;
                return true;
            }
        }
        return false;
    }

    public void decreaseItemQty(Item usedItem){
        for(int i = 1; i <= MAX_SLOT_IN_INVENTORY; i++){
            if(usedItem.getName().equals(itemSlot.get(i).getName())){
                ITEM_CURRENTY_QTY[i]--;
                removeItem(i);

            }
        }
    }

    public void removeItem(int index){
        if(ITEM_CURRENTY_QTY[index] == 0){
        itemSlot.remove(index);
        }
    }




}
