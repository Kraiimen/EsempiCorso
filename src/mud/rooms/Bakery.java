package mud.rooms;

import mud.characters.npcs.Baker;

public class Bakery extends Room{
    public Bakery() {
        super("The Bakery");
        getPresentEntities().add(new Baker("Tom Bombadil"));
    }


    @Override
    public void printEntrance() {
        System.out.println("Can you smell the fresh from the oven bread? You are at the Bakery now.");
        getPresentEntities().forEach(e -> System.out.println(e.getName() + " the " + e.getClass().getSimpleName()));

    }
}
