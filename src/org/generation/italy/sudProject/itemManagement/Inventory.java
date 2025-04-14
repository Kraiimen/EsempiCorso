package org.generation.italy.sudProject.itemManagement;

import org.generation.italy.sudProject.items.Item;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> itemsStored;
    private int inventoryCapacity;

    // /--CONSTRUCTORS--/
    public Inventory(int capacity){
        this.itemsStored = new ArrayList<>();
        addCapacity(capacity);
        inventoryCapacity = capacity;
    }
    // /--METHODS--/
    private void addCapacity(int numOfNewItems){
        for(int i=0; i<numOfNewItems; i++){
            itemsStored.add(null);
        }
    }
    public void addItemToInventory(Item item){
        if(inventoryCapacity != 0){
            for(Item i : itemsStored){
                if(i == null){
                    i = item;
                    inventoryCapacity--;
                    break;
                }
            }
        }else{
            System.out.println("Inventario pieno, impossibile aggiungere oggetti");
        }
    }
    private Item getItemFromInventory(String itemName){
        String name = itemName.toUpperCase();
        Item item = null;
        for(Item i : itemsStored){
            if(name.equals(i.getItemName().toUpperCase())){
                item = i;
                i = null;
                inventoryCapacity++;
                break;
            }
        }
        return item;
    }
    private void showItemsInInventory(){
        System.out.println("Oggetti:");
        for(Item i : itemsStored){
            if(i!=null){
                System.out.print(i.getItemName()+" ");
            }
        }
        System.out.println();
    }

    // /--GETTER-&-SETTER--/

    public ArrayList<Item> getItemsStored() {
        return itemsStored;
    }

    public int getInventoryCapacity() {
        return inventoryCapacity;
    }

    public void setInventoryCapacity(int inventoryCapacity) {
        this.inventoryCapacity = inventoryCapacity;
    }
}
