package org.generation.italy.capstonProject.mudGame.entity;

import org.generation.italy.capstonProject.mudGame.entity.items.Item;

import java.util.*;

public class Inventory {

    private Map<Item, Integer> itemsList = new LinkedHashMap<>();
    private int maxQuantity;
    private final int MAX_ITEM_QUANTITY = 5;

    public Inventory(int maxQuantity){
    this.maxQuantity = maxQuantity;
    }

    public void addItem(Item item) {
        int currentTotal = itemsList.values().stream().mapToInt(Integer::intValue).sum();

        if (currentTotal >= maxQuantity) {
            System.out.println("Your inventory is full. Drop an item to collect new things.");
            return;
        }

        if (itemsList.containsKey(item)) {
            int currentCount = itemsList.get(item);
            if (currentCount < MAX_ITEM_QUANTITY) {
                itemsList.put(item, currentCount + 1);
                System.out.println("Added another " + item.getName() + " to your inventory.");
            } else {
                System.out.println("You can't carry more than " + MAX_ITEM_QUANTITY + " of " + item.getName());
            }
        } else {
            itemsList.put(item, 1);
            System.out.println(item.getName() + " has been added to your inventory.");
        }
    }

    public boolean removeItem(Item item){
        if(itemsList.containsKey(item)){
            int currentCount = itemsList.get(item);
            if (currentCount > 1) {
                itemsList.put(item, currentCount - 1);
                System.out.println("One " + item.getName() + " was removed from your inventory.");
            }else if (currentCount == 1) {
                itemsList.remove(item);
                System.out.println("All " + item.getName() + " have been removed from your inventory.");

            } else {
                itemsList.remove(item);
                System.out.println("There are no " + item.getName() + " left to remove.");
                return false;
            }
            return true;
        } else {
            System.out.println("You don't have any " + item.getName() + " in your inventory.");
            return false;
        }
    }

    public void useItem(Item item){
        itemsList.remove(item);
    }

    public void printAllItems(){
//        for (Map.Entry<Item, Integer> entry : itemsList.entrySet()) {
//            Item item = entry.getKey();
//            int quantity = entry.getValue();
//            System.out.println(item.getName() + " x" + quantity);
//        }
        itemsList.forEach((item, quantity) -> {
            System.out.println(item.getName() + " x" + quantity);
        });
    }

    public Map<Item, Integer> getAll(){
        return new HashMap<>(itemsList);
    }

    public boolean hasItem(Item item){
        return itemsList.containsKey(item);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "itemsList: " + itemsList +
                '}';
    }
}
