package capstoneproject.rooms;

public class Arm extends Item{
    private int damage;

    public Arm(String name, String description, double weight, int cost, int damage) {
        super(name, description, weight, cost);
        this.damage = damage;
    }
//    public int getDamage(){
//    }
}
