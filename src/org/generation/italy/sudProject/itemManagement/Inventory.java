package org.generation.italy.sudProject.itemManagement;

import org.generation.italy.sudProject.items.Item;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> itemsStored;

    // /--CONSTRUCTORS--/
    public Inventory(int capacity){
        this.itemsStored = new ArrayList<>();
    }
    // /--METHODS--/
    private void addCapacity(int numOfNewItems, Item item){
        for(int i=0; i<numOfNewItems; i++){
            itemsStored.add(null);
        }
    }
}
