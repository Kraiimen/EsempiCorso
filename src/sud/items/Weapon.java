package sud.items;
import sud.dices;
public class Weapon extends Item{
    private int weaponeDamageDiceFaces;
    public Weapon(int price, String name, int damageDiceFaces) {
        super(price, ItemType.WEAPON, name);
        this.weaponeDamageDiceFaces = damageDiceFaces;
    }
    public int rollDamage(){
        return dices.roll(weaponeDamageDiceFaces);
    }

}
