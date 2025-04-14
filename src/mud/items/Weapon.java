package mud.items;

public class Weapon extends Item {
    private String weaponType;
    private int strengthGiven;
    public Weapon(String name, int strengthGiven) {
        super(name);
        this.strengthGiven = strengthGiven;
    }

    public String getWeaponType() {
        return weaponType;
    }
    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public int getStrengthGiven() {
        return strengthGiven;
    }
    public void setStrengthGiven(int strengthGiven) {
        this.strengthGiven = strengthGiven;
    }
}
