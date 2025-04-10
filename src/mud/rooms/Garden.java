package mud.rooms;

public class Garden extends Room{
    public Garden(String name) {
        super(name);
    }

    @Override
    public void printEntrance() {
        System.out.println("This is " + getName() + ", enjoy some sun and fresh air!");
        getPresentEntities().forEach(e -> System.out.println(e.getName() + " the " + e.getClass().getSimpleName()));

    }
}
