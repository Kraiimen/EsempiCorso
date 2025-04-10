package mud.characters.npcs;

import mud.characters.Entity;
import mud.rooms.MagicMap;

import java.util.ArrayList;
import java.util.List;

import static mud.characters.fightable.Character.dice;

public class Civilian extends Entity {
    private static final int CIVILIAN_POSSIBLE_ROOM = 5;
    private List<String> greetings;
    public Civilian(String name) {
        super(name);
        greetings = new ArrayList<>();
        greetings.add("Be careful of the woods! You never know what hides in there...");
        greetings.add("If you want some good food, you should check Tom's Bakery!");
        greetings.add("Hello Adventurer! You're new around here, aren't you?");
        greetings.add("The monsters are getting scarier and the guards are more nervous by the day...");
        setActualRoom(MagicMap.getRooms().get(dice.nextInt(CIVILIAN_POSSIBLE_ROOM)));
    }

    @Override
    public void greet(){
        System.out.println(greetings.get(dice.nextInt(greetings.size())));
    }
}
