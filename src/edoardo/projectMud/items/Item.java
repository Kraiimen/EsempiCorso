package edoardo.projectMud.items;

public class Item {
    private String name;
    private double value;

    public Item(double value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public double getValue() {
        return value;
    }
}
