package org.generation.italy.sudProject.classes;

import org.generation.italy.sudProject.Player;

public class Wizard extends Player {
    // /--ATTRIBUTES--/

    // /--CONSTRUCTORS--/
    public Wizard(String firstName, String lastName, String email, String password, String playerName, int indexClassStat, int classStat) {
        super(firstName, lastName, email, password, playerName, INTELLIGENCE_INDEX, dice.nextInt(CLASS_STARTING_P_VALUE, MAX_ATTRIBUTE_P_VALUE));
    }
}
