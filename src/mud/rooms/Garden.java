package mud.rooms;

import mud.items.Tree;

import java.util.ArrayList;
import java.util.List;

public class Garden extends Room{

    public Garden(String name) {
        super(name);
    }

    @Override
    public void printEntrance() {
        System.out.println("This is " + getName() + ", enjoy some sun and fresh air!");
        printEntities();
    }
}
