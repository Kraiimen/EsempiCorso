package mud.items;

public class Weapon extends Item {
    private String weaponType;
    public Weapon(String name) {
        super(name);
    }

    public String getWeaponType() {
        return weaponType;
    }
    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }
}
