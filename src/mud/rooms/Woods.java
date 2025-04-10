package mud.rooms;

public class Woods extends Room{
    public Woods() {
        super("The Woods");
    }

    @Override
    public void printEntrance() {
        System.out.println("You are in the woods, are you sure you're ready for the monsters that live here?");
        getPresentEntities().forEach(e -> System.out.println(e.getName() + " the " + e.getClass().getSimpleName()));

    }
}
