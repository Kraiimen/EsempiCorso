package capstoneproject.entity;

import capstoneproject.rooms.Item;

import java.util.*;

public class Inventory {
    private Map<String, List<Item>> items;

    public Inventory(){
        items = new HashMap<>();
    }

    public void addItem(Item i){
        List<Item> its = items.get(i.getName());
        if( its != null){
            its.add(i);
        } else{
            List<Item> newList = new ArrayList<>();
            newList.add(i);
            items.put(i.getName() , newList);
        }
    }

    public Optional<Item> removeItem(String itemName){
        List<Item> its = items.get(itemName);
        if(its == null){
            return Optional.empty();
        }
        Item removed = its.removeLast();
        if(its.isEmpty()){
            items.remove(itemName);
        }
        return Optional.of(removed);
    }

    @Override
    public String toString(){
        String result = " ";
        for(String chiave : items.keySet()){
            result = chiave + "->" + items.get(chiave).size() + "\n";
        }
        return result;
    }

}
