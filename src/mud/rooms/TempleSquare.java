package mud.rooms;

import mud.characters.Entity;

public class TempleSquare extends Room{
    public TempleSquare() {
        super("Temple Square");
    }

    @Override
    public void addRandomNPC() {

    }

    @Override
    public void printEntrance() {
        System.out.println("Welcome to the Temple Square");
        getPresentEntities().forEach(e -> System.out.println(e.getName() + " is a " + e.getClass() + "his is id " +e.getCharacterId()));
        //da sistemare il get class che stampa tutto il package, forse un enum con i tipi di creatura?
    }
}
