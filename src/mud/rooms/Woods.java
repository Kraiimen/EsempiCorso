package mud.rooms;

import mud.items.Tree;

import java.util.List;

public class Woods extends Room{
    public Woods() {
        super("The Woods");
        getPresentItems().put("Treebeard", new Tree("Treebeard", "Magic fruit", 4));
        getPresentItems().put("Willow", new Tree("Willow", "Seeds", 3));
        getPresentItems().put("Apricot", new Tree("Apricot", "Apricot", 1));
    }

    @Override
    public void printEntrance() {
        System.out.println("You are now in the woods, are you sure you're ready for the monsters that live here?");
        printEntities();

    }

}
