package edoardo.projectMud.rooms;

import edoardo.projectMud.Directions;

public class CityDoors extends Room {
    public CityDoors() {
       initialize();
    }

    public CityDoors(Directions dir, Room r) {
        super(dir, r);
        initialize();
    }


    @Override
    protected void initialize() {
        setName("City Doors");
        setDescription("""
               Beyond the towering iron-bound gates of the city lies the Shadowmire Forest,
               a dense woodland shrouded in perpetual twilight.
               The massive gates, adorned with intricate carvings of forgotten heraldry,
               stand as the final barrier between the relative safety of the castle walls and the untamed wilderness beyond.
               Legends whisper of creatures lurking beneath the forest's canopy,
               their eyes gleaming in the darkness, waiting for unwary travelers to cross the threshold.
               """);
    }
}
