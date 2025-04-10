package mud.rooms;

import mud.CardinalPoints;
import mud.characters.npcs.Merchant;

public class Armory extends Room{
    public Armory() {
        super("The Armory");
        getPresentEntities().add(new Merchant("Isildur"));
    }


    @Override
    public void printEntrance() {

        getPresentEntities().forEach(e -> System.out.println(e.getName() + " the " + e.getClass().getSimpleName()));

    }
}
