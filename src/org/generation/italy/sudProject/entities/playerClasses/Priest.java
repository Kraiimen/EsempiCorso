package org.generation.italy.sudProject.entities.playerClasses;

import org.generation.italy.sudProject.entities.Player;

public class Priest extends Player {
    // /--ATTRIBUTES--/

    // /--CONSTRUCTORS--/
    public Priest(String firstName, String lastName, String email, String password, String playerName) {
        super(firstName, lastName, email, password, playerName, WISDOM_INDEX, dice.nextInt(CLASS_STARTING_P_VALUE, MAX_ATTRIBUTE_P_VALUE));
    }
}

