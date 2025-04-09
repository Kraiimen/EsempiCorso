package sud.items;

public class Weapon extends Item{
    private int damageMod;
    public Weapon(int price, ItemType type, String name, int damageMod) {
        super(price, type, name);
        this.damageMod = damageMod;
    }

    public int getDamageMod() {
        return damageMod;
    }

    public void setDamageMod(int damageMod) {
        this.damageMod = damageMod;
    }
}
