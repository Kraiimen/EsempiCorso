package sud.items;

public class Armor extends Item{
    private int damageReducer;

    public Armor(int price,  String name, int damageReducer) {
        super(price, ItemType.ARMOR, name);
        this.damageReducer = damageReducer;
    }

    public int getDamageReducer() {
        return damageReducer;
    }

    public void setDamageReducer(int damageReducer) {
        this.damageReducer = damageReducer;
    }
}
