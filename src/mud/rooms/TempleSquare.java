package mud.rooms;

import mud.CardinalPoints;
import mud.characters.Entity;

public class TempleSquare extends Room{
    public TempleSquare() {
        super("Temple Square");
    }

    @Override
    public void printEntrance() {
        System.out.println("Welcome to the Temple Square");
        printEntities();
    }
}
