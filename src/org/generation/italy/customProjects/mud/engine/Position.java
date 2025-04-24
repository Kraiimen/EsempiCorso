package org.generation.italy.customProjects.mud.engine;

import org.generation.italy.customProjects.mud.world.Place;

public interface Position {
    Place getCurrentPlace();
    void setCurrentPlace(Place currentPlace);
}
