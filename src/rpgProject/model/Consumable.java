package rpgProject.model;

public class Consumable {
    private String name;
    private int quantity;
    private int efficiency;

    public Consumable() {
    }

    public Consumable(String name, int quantity, int efficiency) {
        this.name = name;
        this.quantity=quantity;
        this.efficiency=efficiency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }
}