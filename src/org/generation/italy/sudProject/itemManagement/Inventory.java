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
    }
    // /--METHODS--/
    private void addCapacity(int numOfNewItems){
        for(int i=0; i<numOfNewItems; i++){
            itemsStored.add(null);
        }
        inventoryCapacity += numOfNewItems;
    }
    public void addItemToInventory(Item item){
        if(inventoryCapacity > 0){
            for (int i = 0; i < itemsStored.size(); i++) {
                if (itemsStored.get(i) == null) {
                    itemsStored.set(i, item);
                    inventoryCapacity--;
                    break;
                }
            }
        }else{
            System.out.println("Inventario pieno, impossibile aggiungere oggetti");
        }
    }
    public Item getItemFromInventory(String itemName){
        String name = itemName.toUpperCase();
        Item item = null;
        if(!itemsStored.isEmpty()){
            for(Item i : itemsStored){
                if(i != null){
                    if(name.equals(i.getItemName().toUpperCase())){
                        item = i;
                        itemsStored.remove(i);
                        inventoryCapacity++;
                        break;
                    }
                }
            }
        }
        return item;
    }

    public void showItemsInInventory(){
        System.out.println("Oggetti:");
        for(Item i : itemsStored){
            if(i!=null){
                System.out.print(i.getItemName()+" ");
            }
        }
        System.out.println();
    }

    //metodo getItem ma senza rimozione dell'oggetto dall'inventario (per visualizzare l'oggetto)
    public Item viewItemFromInventory(String itemName){
        String name = itemName.trim().toUpperCase();
        Item item = null;
        if(!itemsStored.isEmpty()){
            for(Item i : itemsStored){
                if(i != null){
                    if(name.equals(i.getItemName().trim().toUpperCase())){
                        item = i;
                        break;
                    }
                }
            }
        }
        return item;
    }

    public boolean IsInventoryFull(){
        return inventoryCapacity == 0;
    }

    public void deleteItemFromInventory(String itemname){
        for(int i = 0; i < itemsStored.size(); i++){
            Item item = itemsStored.get(i);
            if(item != null && item.getItemName().equals(itemname)){
                itemsStored.set(i, null);
                inventoryCapacity++;
                break;
            }
        }
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
