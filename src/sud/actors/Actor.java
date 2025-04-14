package sud.actors;

import sud.Die;
import sud.Loot;
import sud.environment.CardinalDirection;
import sud.environment.WorldMap;
import sud.environment.rooms.Room;
import sud.items.Armor;
import sud.items.Item;
import sud.items.Weapon;

import java.util.Map;
import java.util.Random;

public abstract class Actor {
    // /-----------/ CAMPI /-----------/
    //private static int lastId = 0;
    //private  int id;

    private static final int MAX_STAT_VALUE = 20;
    private static final int MIN_STAT_VALUE = 0;

    private String name;
    private boolean dead;

    //BASIC STATS
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    //DERIVATED STATS
    private int currentHealthPoints;
    private int maxHealthPoint;

    //private int constitutionDice = constitution - 11 > 0 ? (((constitution-10) / 2) * 2) + Dice.D4.getDiceValue(): Dice.D4.getDiceValue();

    private int strengthModifier;
    private int dexterityModifier;
    private int intelligenceModifier;
    private int wisdomModifier;
    private int charismaModifier;

    private Map<Integer, Item> inventory;   //una volta fatti gli oggetto, va cambiata la chiave in un Enum per gli oggetti?
    private Armor armor;
    private Weapon weapon;

    private Room position;

    private Random r = new Random();

    // /-----------/ CONSTRUCTORS /-----------/
    public Actor(String name) {
        this.name = name;
        position = WorldMap.getSpawnPosition();
        //passo i valori random all'altro costruttore qui o chiamo l'altro costruttore da fuori con valori random?
    }

    public Actor(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma){
        //checkValuesValidity(new int[]{strength, dexterity, constitution, intelligence, wisdom, charisma});
        this(name);
        dead = false;

        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;

        maxHealthPoint = getConstitutionDice().getValue();
    }

    public Actor(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, Room spawnPoint){
        this(name, strength, dexterity, constitution, intelligence, wisdom, charisma);
        dead = false;

        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;

        maxHealthPoint = getConstitutionDice().getValue();

        position = spawnPoint;
    }

    // /-----------/ METHODS /-----------/

    public void move(Room newPosition){
        if(newPosition.isAdjacent(position)){
            position = newPosition;
        }
    }

//    public void checkValuesValidity(int[] nums) throws InvalidAttributesException{
//        for(int num : nums){
//            if(num < MIN_STAT_VALUE || num > MAX_STAT_VALUE){
//                throw new InvalidAttributesException();
//            }
//        }
//    }

    public abstract Die getConstitutionDice();//{
//        return constitution - 11 > 0 ?
//                Dice.valueOf((((constitution - 10) / 2) * 2) + Dice.D4.getDiceValue()) :
//                Dice.D4;
//    }

    //TODO da spostare in figlia
//    public void updateMaxHealthPoint(boolean defaultHealth) {
//        this.maxHealthPoint += defaultHealth ? getConstitutionDice().getDiceValue() / 2 : getConstitutionDice().roll();
//        this.maxHealthPoint += getModifier(constitution);
//    }


    private void regenHP(double percent){
        int regenHP = (int)(maxHealthPoint * percent);
        currentHealthPoints += regenHP;
    }

    //ATTACK
    public void attack(Actor target){
        if(canNotAttack(target)) {
            System.out.println("non puoi attaccare questo bersaglio!");
            return;
        }
        System.out.print(name +  " attacca " + target.name);
        target.recieveDamage(getDamage());

    }

    public void recieveDamage (int dmg){
        System.out.println(": " + dmg + " danni");
        currentHealthPoints -= dmg;

        dead = currentHealthPoints <= 0;
        if(isDead()){
            handleDeath();
        }
        //TODO effetto oggetti (equip)

    }
    protected boolean canNotAttack(Actor target){
        return target == null || target.isDead();
    }

    public int getDamage(){//TODO effetto oggetti (equip)
        return weapon.getDamageDice().roll() + (weapon.isStrenghtBased() ? strengthModifier : dexterityModifier);
    }
    //-------------------------------------

    //DEATH
    public boolean isDead(){
        return dead;
    }
    protected void handleDeath(){
        death();
    }
    protected Loot death(){
        System.out.println(name + " è morto");
        return null;
        //@TODO
    }
    //--------------------------------

    public void pickItem(Item i){
        inventory.put(i.hashCode(), i);//TODO da gestire
    }
    public void useItem(Item i){
        //TODO da gestire utilizzo oggetto
        removeItem(i);//TODO da gestire la presenza di molteplici oggetti consumabili uguali con un counter
    }
    private void removeItem(Item i){
        inventory.remove(i.hashCode(), i);//TODO da gestire
    }

    public int getModifier(int stat) {
        return (stat-10) / 2;
    }

    // /-----------/GETTER & SETTER /-----------/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //BASIC STATS
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }
    public int getConstitution() {
        return constitution;
    }
    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public int getWisdom() {
        return wisdom;
    }
    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }
    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    //DERIVATED STATS
    public int getCurrentHealthPoints() {
        return currentHealthPoints;
    }
    protected void setCurrentHealthPoints(int currentHealthPoints) {
        this.currentHealthPoints = currentHealthPoints;
    }

    public int getMaxHealthPoint() {
        return maxHealthPoint;
    }
    protected void setMaxHealthPoint(int maxHP) {
        maxHealthPoint = maxHP;
    }

    //STAT MODIFIERS
    public int getStrengthModifier() {
        return getModifier(strength);
    }
    public int getDexterityModifier() {
        return getModifier(dexterity);
    }
    public int getIntelligenceModifier() {
        return getModifier(intelligence);
    }
    public int getWisdomModifier() {
        return getModifier(wisdom);
    }
    public int getCharismaModifier() {
        return getModifier(charisma);
    }

    public Room getPosition() {
        return position;
    }
}