package edoardo.projectMud.rooms;


import edoardo.projectMud.Directions;

public class Gardens extends Room {
    private static int counterNordGardens = 0;
    public Gardens() {
       initialize();
    }

    public Gardens(Directions dir, Room r) {
        super(dir, r);
        initialize();
    }

    @Override
    protected void initialize() {
        setName("Gardens");
        setDescription("""
                Tucked between cobbled streets and stone buildings,
                the city gardens offer a peaceful retreat from the daily bustle.
                Neatly kept paths wind through flowerbeds and shaded benches,
                while the soft sound of a fountain brings a sense of calm.
                Locals stroll, rest, and gather here, surrounded by greenery in the heart of the city.""");

    }

    public static int getCounterSudGardens() {
        return counterNordGardens;
    }

    public static void updateCounterSudGardens() {
        Gardens.counterNordGardens++;
    }
}
