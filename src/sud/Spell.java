package sud;

public class Spell {
    private String name;
    private int damage;
    private int level;
    private int damageDiceFaces;

    public Spell(String name, int level, int damageDiceFaces) {
        this.name = name;
        this.level = level;
        this.damageDiceFaces = damageDiceFaces;
        for (int i = 0; i < level ; i++) {
            this.damage += dices.roll(damageDiceFaces);
        }
    }

    public String getName() {
        return name;
    }

    public Spell() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDamageDiceFaces() {
        return damageDiceFaces;
    }

    public void setDamageDiceFaces(int damageDiceFaces) {
        this.damageDiceFaces = damageDiceFaces;
    }
}
