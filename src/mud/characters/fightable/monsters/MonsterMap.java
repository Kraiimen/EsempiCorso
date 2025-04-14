package mud.characters.fightable.monsters;


import mud.items.Food;
import mud.items.Ring;
import mud.items.Weapon;

import java.util.ArrayList;
import java.util.List;

public class MonsterMap {
    static private List<Monster> monsters = new ArrayList<>();
    static private List<Monster> guards = new ArrayList<>();
    static {
        //GATTI
        Monster fluffy = new Cat("Fluffy");
        monsters.add(fluffy);
        monsters.add(new Cat("Kitty"));
        monsters.add(new Cat("Peach"));
        monsters.add(new Cat("Lily"));
        monsters.add(new Cat("Minnie"));

        //GOBLIN
        Monster krenko = new Goblin("Krenko");
        monsters.add(krenko);
        monsters.add(new Goblin("Ardoz"));
        monsters.add(new Goblin("Goro-Goro"));
        monsters.add(new Goblin("Squee"));
        monsters.add(new Goblin("Hobgoblin"));

        //FANTASMI

        monsters.add(new Ghost("Filippo", "Isn't it a bit excessive trying to kill a ghost?"));
        monsters.add(new Ghost("Elvis", "I don't remember much of how I died, but I'd been writing code for 70 hours..."));
        monsters.add(new Ghost("Edoardo", "Has anybody seen my D&D dices?"));
        monsters.add(new Ghost("Lorenzo", "AO"));
        monsters.add(new Ghost("Nico", "Devastating, I can walk through walls!"));

        //DRAGHI
        monsters.add(new Dragon("Niv-Mizzet"));
        monsters.add(new Dragon("Ugin"));
        monsters.add(new Dragon("Nicol Bolas"));
        monsters.add(new Dragon("Neriv"));

        //DRAGO CON L'UNICO ANELLO
        Monster smaug = new Dragon("Smaug");
        smaug.pickItem(new Ring("The One Ring"));
        monsters.add(smaug);

        //GUARDIE
        guards.add(new Guard("Strawberry"));
        guards.add(new Guard("Watermelon"));
        guards.add(new Guard("Banana"));
        guards.add(new Guard("Cheesecake"));
        guards.add(new Guard("Blueberry"));

        //do gli oggetti a qualche mostro
        fluffy.pickItem(new Food("Dead mouse", 2));
        krenko.pickItem(new Weapon("Rusty sword", 1));

    }

    public static List<Monster> getGuards() {
        return guards;
    }
}
