package org.generation.italy.customProjects.mud.world;

import java.util.EnumMap;
import java.util.Map;
import java.util.Random;

public class Place {
    //   /-----/-STATE-/-----/
    private String placeName;
    private String placeDescription;
    private Map<Direction, Place> directions;
    Random entityNumber;

    //   /-----/-CONSTRUCTORS-/-----/
    public Place(String placeName, String placeDescription, Place northRoom, Place eastRoom, Place southRoom, Place westRoom, Random entityNumber) {
        this.directions = new EnumMap<>(Direction.class);
        this.placeName = placeName;
        this.placeDescription = placeDescription;
        this.entityNumber = entityNumber;
        directions.put(Direction.NORTH, northRoom);
        directions.put(Direction.EAST, eastRoom);
        directions.put(Direction.SOUTH, southRoom);
        directions.put(Direction.WEST, westRoom);
    }

    //   /-----/-METHODS-/-----/




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
    public Random getEntityNumber() {
        return entityNumber;
    }
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }
    public void setDirections(Map<Direction, Place> directions) {
        this.directions = directions;
    }
    public void setEntityNumber(Random entityNumber) {
        this.entityNumber = entityNumber;
    }
}
