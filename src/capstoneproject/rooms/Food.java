package capstoneproject.rooms;

public class Food extends Item {
    private int healAmount;

    public Food(String name, String description, double weight, int cost, int healAmount) {
        super(name, description, weight, cost);
        this.healAmount = healAmount;
    }

    Food apple = new Food("Mela", "Frutto rosso e croccante", 0.2, 1, 10);
    Food bread = new Food("Pane", "Pane fresco e fragrante", 0.5, 2, 50);
    Food steak = new Food("Bistecca", "Taglio di carne succulento", 1.0, 5, 100);


    public int getHealAmount(){
        return healAmount;
    };
}
