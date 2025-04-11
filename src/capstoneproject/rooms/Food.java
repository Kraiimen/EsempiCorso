package capstoneproject.rooms;

public class Food extends Item {
    private int healAmount;

    public Food(String name, String description, double weight, int cost, int healAmount) {
        super(name, description, weight, cost);
        this.healAmount = healAmount;
    }

    public int getHealAmount(){
        return healAmount;
    };
}
