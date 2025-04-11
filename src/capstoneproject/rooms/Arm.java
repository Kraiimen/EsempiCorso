package capstoneproject.rooms;

public class Arm extends Item{
    private int damage;

    public Arm(String name, String description, double weight, int cost, int damage) {
        super(name, description, weight, cost);
        this.damage = damage;
    }

    Arm sword = new Arm("Spada", "Una spada lunga e affilata", 3.0, 50, 25);
    Arm axe = new Arm("Ascia", "Un'ascia pesante con grande potere", 4.5, 75, 40);
    Arm bow = new Arm("Arco", "Un arco lungo con frecce precise", 2.0, 30, 20);

    public int getDamage(){
        return damage;
    }
}
