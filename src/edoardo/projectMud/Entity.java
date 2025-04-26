package edoardo.projectMud;


import edoardo.projectMud.items.Weapon;
import java.util.Random;


public abstract class Entity{
    private String name;
    private String classTipology;
    private Weapon weapon;
    private int strength;
    private int hp;
    private int maxHp;
    private double money;
    private Random random = new Random();
    public final static int MAX_BONUS = 11;
    private Genre genre;


    public Entity(String name, Genre genre){
        this.name = name;
        this.genre = genre;
    }
    public Entity(String name, int strength, int maxHp, double money){
        this.name = name;
        this.strength = strength;
        this.maxHp = maxHp;
        this.money = money;
        hp = maxHp;
    }

    public Entity() {
    }

    public void attack(Entity a) {
        int bonusAttack = random.nextInt(MAX_BONUS);
        int weaponBonus = 0;
        if (weapon != null){
            weaponBonus = weapon.getBonusPhysicalAttack();
        }
        int attack = strength+bonusAttack+weaponBonus;
        a.setHp(hp-attack);
        System.out.println("the " + classTipology + " " + name + " inflicts " + attack + " damage");
        System.out.println(a.name + "remaining hp: " + name );
    }

    public boolean isAlive(){
        return hp > 0;
    }

    @Override
    public String toString() {
        return "classTipology:'" + classTipology + '\'' +
                ", name:'" + name + '\'';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapons(Weapon weapon) {
        this.weapon = weapon;
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if(hp > maxHp){
            this.hp = maxHp;
        }
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    public String getClassTipology() {
        return classTipology;
    }
    public void setClassTipology(String classTipology) {
        this.classTipology = classTipology;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getStrength() {
        return strength;
    }

    public Random getRandom() {
        return random;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
    public Coin coinToss(){
        return Coin.values()[random.nextInt(2)];
    }
}
