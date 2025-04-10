package org.generation.italy.customProjects.mud.world;

import java.util.EnumMap;
import java.util.Map;

public class Place {
    //   /-----/-STATE-/-----/
    private String placeName;
    private String placeDescription;
    private Map<Direction, Place> directions;

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
