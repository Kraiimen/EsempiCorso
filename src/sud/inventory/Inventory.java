package sud.inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Inventory {
    Map<Item, Integer> itemToQuantity;

    public Inventory() {
        this.itemToQuantity = new HashMap<>();
    }

    public void addItem(Item item) {

        itemToQuantity.put(item, itemToQuantity.getOrDefault(item, 0) + 1);
        //if the value was initialised, get its value and add 1.
        //if it wasn't initialised, default it to 0 and add 1.
    }

    public void addItem(Item item, int amount) {

        itemToQuantity.put(item, itemToQuantity.getOrDefault(item, 0) + amount);
        //if the value was initialised, get its value and add 1.
        //if it wasn't initialised, default it to 0 and add 1.
    }

    public void removeItem(Item item) {
        if (!itemToQuantity.containsKey(item)) {
            return;
        }
        if (itemToQuantity.get(item) <= 1) {
            itemToQuantity.remove(item);
            return;
        }

        itemToQuantity.put(item, itemToQuantity.get(item) - 1);
    }

    public Map<Item, Integer> getHashMap() {
        return itemToQuantity;
    }

    public void print() {
        System.out.println("The bag contains: ");
        for (Map.Entry<Item, Integer> entry : itemToQuantity.entrySet()) {
            System.out.println(entry.getKey() + " x " + entry.getValue());
        }
    }

    public boolean isEmpty() {
        return itemToQuantity.isEmpty();
    }

    public Stream<Map.Entry<Item, Integer>> stream() {
        return itemToQuantity.entrySet().stream();
    }

    public Optional<Item> getItemWithName(String name) {
        return stream()
                .filter(entry -> entry.getKey().getName().toLowerCase().equals(name.toLowerCase()))
                .map(entry -> entry.getKey())
                .findFirst();
    }
}
