package org.generation.italy.sudProject.entities.mobs;

import org.generation.italy.sudProject.map.Room;

public class Cat extends PeacefulMob{
    public static int numberOfCats;
    private static final int HP_FIRST_SPAWN = 2;
    private static final int HP_MAX_FIRST_SPAWN = 2;

    // /--CONSTRUCTORS--/
    public Cat(String catName, Room position, int indexCatPosition) {
        super(catName, HP_FIRST_SPAWN, HP_MAX_FIRST_SPAWN, position, indexCatPosition);
        numberOfCats++;
    }

    // /--GETTER-&-SETTER--/
}
