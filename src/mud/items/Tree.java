package mud.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static mud.GameUtil.player;

public class Tree extends Item {
    private List<Food> fruits;

    public Tree(String name, String fruitName, int hpGiven) {
        super(name);
        fruits = new ArrayList<>();
        fruits.add(new Food(fruitName, hpGiven));
        fruits.add(new Food(fruitName, hpGiven));
        fruits.add(new Food(fruitName, hpGiven));
    }

    public void pickFruit(){
        if(fruits.isEmpty()){
            System.out.println("You've already picked all the fruits from this tree.");
        } else{
            System.out.println("You are picking a fruit from " + getName());
            player.pickItem(fruits.getLast());
            fruits.removeLast();
        }
    }
}
