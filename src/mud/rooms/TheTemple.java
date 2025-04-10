package mud.rooms;

import mud.characters.Entity;

public class TheTemple extends Room{
    public TheTemple() {
        super("The Temple");
    }

    @Override
    public void printEntrance() {
        System.out.println("Contemplate the deepness of the soul here at the Temple");
        getPresentEntities().forEach(e -> System.out.println(e.getName() + " the " + e.getClass().getSimpleName()));

    }
}
