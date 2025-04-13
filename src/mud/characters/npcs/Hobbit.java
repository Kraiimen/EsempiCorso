package mud.characters.npcs;

import mud.characters.Entity;
import mud.rooms.MagicMap;

import java.util.ArrayList;
import java.util.List;

import static mud.GameUtil.*;
import static mud.characters.fightable.Character.dice;

public class Hobbit extends Entity {
    private static final int HOBBIT_POSSIBLE_ROOM = 7;
    private List<String> greetings;

    public Hobbit(String name) {
        super(name);
        greetings = new ArrayList<>();
        greetings.add("Be careful of the woods! You never know what hides in there...");
        greetings.add("If you want some good food, you should check Tom's Bakery!");
        greetings.add("Hello Adventurer! You're new around here, aren't you?");
        greetings.add("The monsters are getting scarier and the guards are more nervous by the day...");
        greetings.add("Let's have a pint together sometimes!");
        setActualRoom(MagicMap.getRooms().get(dice.nextInt(HOBBIT_POSSIBLE_ROOM)));
    }

//    public Hobbit(String name, boolean hasQuest){
//        this(name);
//        setHasQuest(hasQuest);
//    }

    @Override
    public void greet(){
        //CAPIAMO SE VOGLIO IMPLEMENTARE LE ALTRE QUEST DOPO CHE HO FINITO TUTTO, IDEA: CREARE L'OGGETTO QUEST
    //    if(doesHaveQuest()){
            //METODO IN CUI CHIEDO SE ACCETTA LA QUEST
            //IF(ACCETTA)
            //System.out.println("QUEST QUEST QUEST BLABLABLA");
    //    } else{
            System.out.println(BLUE + greetings.get(dice.nextInt(greetings.size())) + RESET);
            delay(800);
    //    }

    }
}
