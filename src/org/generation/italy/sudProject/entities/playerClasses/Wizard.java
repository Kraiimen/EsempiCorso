package org.generation.italy.sudProject.entities.playerClasses;

import org.generation.italy.sudProject.entities.Player;

public class Wizard extends Player {
    // /--ATTRIBUTES--/

    // /--CONSTRUCTORS--/
    public Wizard(String firstName, String lastName, String email, String password, String playerName) {
        super(firstName, lastName, email, password, playerName, INTELLIGENCE_INDEX, dice.nextInt(CLASS_STARTING_P_VALUE, MAX_ATTRIBUTE_P_VALUE));
    }
}
