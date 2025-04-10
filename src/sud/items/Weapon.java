package sud.items;
import sud.dices;
public class Weapon extends Item{
    private int weaponeDamageDiceFaces;
    public Weapon(int price, String name, int damageDiceFaces) {
        super(price, ItemType.WEAPON, name);
        this.weaponeDamageDiceFaces = damageDiceFaces;
    }
    static{
        Weapon dagger = new Weapon(20,"Dagger",4);
        Weapon sword = new Weapon(30,"Sword",6);
        Weapon grateSword = new Weapon(60,"Grate sword",12);
        Weapon grateaxe = new Weapon(60,"Grate axe",12);
    }
    public int rollDamage(){
        return dices.roll(weaponeDamageDiceFaces);
    }

}
