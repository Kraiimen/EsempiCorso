package mud.characters.fightable.monsters;


import mud.items.Ring;

import java.util.ArrayList;
import java.util.List;

public class MonsterMap {
    static private List<Monster> monsters = new ArrayList<>();
    static {
        //GATTI
        monsters.add(new Cat("Fluffy"));
        monsters.add(new Cat("Kitty"));
        monsters.add(new Cat("Peach"));
        monsters.add(new Cat("Lily"));

        //GOBLIN

        //FANTASMI

        //DRAGHI

        //DRAGO CON L'UNICO ANELLO
        Monster smaug = new Dragon("Smaug");
        smaug.getInventory().add(new Ring());
        monsters.add(smaug);

    }
}
