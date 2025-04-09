package sud.items;

public class CombatPotion extends Potion{
    private int attackMod;

    public CombatPotion(int price, ItemType type, String name, int attackMod) {
        super(price, type, name);
        this.attackMod = attackMod;
    }

    public int getAttackMod() {
        return attackMod;
    }

    public void setAttackMod(int attackMod) {
        this.attackMod = attackMod;
    }
}
