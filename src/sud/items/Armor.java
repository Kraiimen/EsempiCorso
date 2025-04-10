package sud.items;

public class Armor extends Item{
    private int damageReducer;

    public Armor(int price,  String name, int damageReducer) {
        super(price, ItemType.ARMOR, name);
        this.damageReducer = damageReducer;
    }

    static {
        Armor leatherArmor = new Armor(50, "Leather armor",5);
        Armor chainMail = new Armor(80, "Chain mail",8);
        Armor fullplate = new Armor(120, "Full plate armor",10);
    }
    public int getDamageReducer() {
        return damageReducer;
    }

    public void setDamageReducer(int damageReducer) {
        this.damageReducer = damageReducer;
    }
}
