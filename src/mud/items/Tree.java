package mud.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tree extends Item {
    private HashMap<String, Food> fruits;

    public Tree(String name, String fruitName, int hpGiven) {
        super(name);
        fruits = new HashMap<>();
        fruits.put(fruitName, new Food(fruitName, hpGiven));
        fruits.put(fruitName, new Food(fruitName, hpGiven));
        fruits.put(fruitName, new Food(fruitName, hpGiven));
    }
}
