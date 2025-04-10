package org.generation.italy.sudProject.classes;

import org.generation.italy.sudProject.Player;

public class Rogue extends Player {
    // /--ATTRIBUTES--/

    // /--CONSTRUCTORS--/
    public Rogue(String firstName, String lastName, String email, String password, String playerName, int indexClassStat, int classStat) {
        super(firstName, lastName, email, password, playerName, DEXTERITY_INDEX, dice.nextInt(CLASS_STARTING_P_VALUE, MAX_ATTRIBUTE_P_VALUE));
    }
}