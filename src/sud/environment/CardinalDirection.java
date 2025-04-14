package sud.environment;

import sud.GameChoicesEnums.MainChoice;

import java.util.ArrayList;
import java.util.List;

public enum CardinalDirection {
    NORTH("nord"),
    EAST("est"),
    SOUTH("sud"),
    WEST("ovest");

    private final String value;
    private static final List<String> compass = new ArrayList<>();

    static {
        compass.add(CardinalDirection.NORTH.value);
        compass.add(CardinalDirection.EAST.value);
        compass.add(CardinalDirection.SOUTH.value);
        compass.add(CardinalDirection.WEST.value);
    }

    private CardinalDirection(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    public static CardinalDirection getOppositeDirection(CardinalDirection direction) {
        return switch (direction) {
            case NORTH -> SOUTH;
            case EAST -> WEST;
            case SOUTH -> NORTH;
            case WEST -> EAST;
            default -> null;
        };
    }

    public static List<String> getCompass() {
        return compass;
    }
}
