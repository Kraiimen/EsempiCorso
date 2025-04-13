package sud.items;

public class Armor extends Item{
    private int damageReducer;
    private int cAMod;

    public Armor(int price,  String name, int damageReducer,int cAMod) {
        super(price, ItemType.ARMOR, name);
        this.damageReducer = damageReducer;
        this.cAMod = cAMod;
    }

    public int getDamageReducer() {
        return damageReducer;
    }

    public void setDamageReducer(int damageReducer) {
        this.damageReducer = damageReducer;
    }

    public int getcAMod() {
        return cAMod;
    }

    public void setcAMod(int cAMod) {
        this.cAMod = cAMod;
    }
}
