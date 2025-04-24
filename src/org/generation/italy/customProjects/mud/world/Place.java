package org.generation.italy.customProjects.mud.world;

import org.generation.italy.customProjects.mud.entities.Entity;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Place {
    //   /-----/-STATE-/-----/
    private String placeName;
    private String placeDescription;
    private Map<Direction, Place> directions;
    private List<Entity> entities = new ArrayList<>();

    //   /-----/-CONSTRUCTORS-/-----/
    public Place(String placeName, String placeDescription) {
        this.directions = new EnumMap<>(Direction.class);
        this.placeName = placeName;
        this.placeDescription = placeDescription;
    }

    //   /-----/-METHODS-/-----/
    public void setExit(Direction direction, Place nextPlace) {
        directions.put(direction, nextPlace);
    }
    public void addEntities(Entity entity, int entityNum) {
        for (int i = entityNum; i > 0; i--) {
            entities.add(entity);
        }
    }



    //   /-----/-METHODS-/-GET-&-SET-/-----/
    public String getPlaceName() {
        return placeName;
    }
    public String getPlaceDescription() {
        return placeDescription;
    }
    public Map<Direction, Place> getDirections() {
        return directions;
    }
    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }
}
