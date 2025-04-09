package mud.rooms;

import mud.characters.Entity;

public class TheTemple extends Room{

    public TheTemple() {
        super("The Temple");
    }

    @Override
    public void addRandomNPC() {

    }

    @Override
    public void printEntrance() {
        System.out.println("Contemplate the deepness of the soul here at the Temple");
        for(Entity e : getPresentEntities()){
            System.out.println(e.getName());
        }

    }
}
