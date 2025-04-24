package org.generation.italy.customProjects.mud.entities;

import org.generation.italy.customProjects.mud.engine.Position;
import org.generation.italy.customProjects.mud.world.Place;

public abstract class Animal extends Entity implements Position {

    //   /-----/-CONSTRUCTORS-/-----/
    public Animal(String name, int currentHealth, int maxHealthPoint, Place currentPlace) {
        super(name, currentHealth, maxHealthPoint, currentPlace);
    }

}
