package mud.characters.fightable.monsters;


import mud.items.Ring;

import java.util.ArrayList;
import java.util.List;

public class MonsterMap {
    static private List<Monster> monsters = new ArrayList<>();
    static private List<Monster> guards = new ArrayList<>();
    static {
        //GATTI
        monsters.add(new Cat("Fluffy"));
        monsters.add(new Cat("Kitty"));
        monsters.add(new Cat("Peach"));
        monsters.add(new Cat("Lily"));
        monsters.add(new Cat("Minnie"));

        //GOBLIN
        monsters.add(new Goblin("Krenko"));
        monsters.add(new Goblin("Ardoz"));
        monsters.add(new Goblin("Goro-Goro"));
        monsters.add(new Goblin("Squee"));
        monsters.add(new Goblin("Hobgoblin"));

        //FANTASMI

        monsters.add(new Ghost("Filippo"));
        monsters.add(new Ghost("Elvis"));
        monsters.add(new Ghost("Edoardo"));
        monsters.add(new Ghost("Lorenzo"));
        monsters.add(new Ghost("Nicolò"));

        //DRAGHI
        monsters.add(new Dragon("Niv-Mizzet"));
        monsters.add(new Dragon("Ugin"));
        monsters.add(new Dragon("Nicol Bolas"));
        monsters.add(new Dragon("Neriv"));

        //DRAGO CON L'UNICO ANELLO
        Monster smaug = new Dragon("Smaug");
        smaug.getInventory().add(new Ring("The One Ring"));
        monsters.add(smaug);

        //GUARDIE
        guards.add(new Guard("Strawberry"));
        guards.add(new Guard("Watermelon"));
        guards.add(new Guard("Banana"));
        guards.add(new Guard("Cheesecake"));
        guards.add(new Guard("Blueberry"));

    }

    public static List<Monster> getGuards() {
        return guards;
    }
}
