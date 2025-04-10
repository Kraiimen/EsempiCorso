package sud.items;
import sud.dices;
public class Weapon extends Item{
    private int weaponeDamageDiceFaces;
    public Weapon(int price, ItemType type, String name, int damageDiceFaces) {
        super(price, type, name);
        this.weaponeDamageDiceFaces = damageDiceFaces;
    }

    public int rollDamage(){
        return dices.roll(weaponeDamageDiceFaces);
    }

}
