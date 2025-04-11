package org.generation.italy.sudProject.entities.mobs;

public class Cat extends PeacefulMob{
    public static int numberOfCats;
    private static final int HP_FIRST_SPAWN = 2;
    private static final int HP_MAX_FIRST_SPAWN = 2;

    // /--CONSTRUCTORS--/
    public Cat(String catName) {
        super(catName, HP_FIRST_SPAWN, HP_MAX_FIRST_SPAWN);
        numberOfCats++;
    }
}
