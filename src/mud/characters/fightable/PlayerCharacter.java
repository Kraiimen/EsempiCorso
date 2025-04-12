package mud.characters.fightable;

import mud.CardinalPoints;
import mud.items.Food;
import mud.items.Item;
import mud.items.Weapon;
import mud.rooms.MagicMap;
import mud.rooms.Room;

public abstract class PlayerCharacter extends Character {
    public static final int MAX_RESPAWN = 5;
    private static final int STARTING_STAM = 5;
    private static final int STARTING_STRENGTH = 3;

    private int killsCounter;
    private int respawnCounter;
    private int expCounter;


    public PlayerCharacter(String name, int minIntelligence, int minAgility, int minStamina){
        super(name);
        setIntelligence(dice.nextInt(minIntelligence, MAX));
        setStrength(STARTING_STRENGTH);
        setAgility(dice.nextInt(minAgility, MAX));
        setStamina(dice.nextInt(minStamina, STARTING_STAM));
        setActualRoom(MagicMap.getRooms().getFirst());
        killsCounter = 0;
        setHp(MAX_HP);
    }

    @Override
    public void changeRoom(CardinalPoints cardinal) {
        if (getActualRoom().getDirections().containsKey(cardinal)) {
            getActualRoom().leaveRoom(this);
            getActualRoom().getDirections().get(cardinal).enterInRoom(this);
            getActualRoom().printEntrance();
            //per ora lascio qui la guarigione del tempio, ma forse sta meglio nel tempio? dopo vedo
            if(getActualRoom().equals(MagicMap.getRooms().get(1))){
                System.out.println("The Temple's magical air heals you. +2 hp points.");
                heal(2);
            }
        } else {
            System.out.println("The road is closed. You're still at " + getActualRoom().getName());
        }
    }

    public void eat(Item item){
        if(item instanceof Food food){
            if (food.getHpGiven()<0){
                hurt(-food.getHpGiven());
                System.out.printf("This %s is poisoned! You lose %d hp!%n", food.getName(), -food.getHpGiven());
            } else {
                System.out.printf("You ate %s and you got +%d hp.%n", food.getName(), food.getHpGiven());
                heal(food.getHpGiven());
            }
        } else {
            System.out.println("You can't eat this!");
        }
    }

    public void respawn(){
        if(!checkIfAlive() && respawnCounter < MAX_RESPAWN){
            setHp(MAX_HP);
            setIsAlive(true);
            respawnCounter++;
            setActualRoom(MagicMap.getRooms().getFirst());
            System.out.printf("Welcome back! You are now in %s and you have %d respawn possibilities left!%n",
                    MagicMap.getRooms().getFirst().getName(),MAX_RESPAWN-respawnCounter);
        }
    }

    //ogni 5 punti esperienza gli do un punto stamina
    public void addExp(int exp){
        setExp(getExp() + exp);
        if(getExp()/5>expCounter){
            setStamina(getStamina() + 1);
            expCounter++;
        }
    }

    public void printStats(){
        System.out.printf("Here are %s's statistics:%n", getName());
        System.out.println("Exp: " + getExp());
        System.out.println("HP: " + getHp() + "/" + MAX_HP);
        System.out.println("Intelligence: " + getIntelligence() + "/" + MAX);
        System.out.println("Strength: " + getStrength() + "/" + MAX);
        System.out.println("Agility: " + getAgility() + "/" + MAX);
        System.out.println("Stamina: " + getStamina() + "/" + MAX);
        System.out.println("Respawns Left: " + (MAX_RESPAWN-respawnCounter));
    }
    @Override
    public void pickItem(Item item){
            getInventory().put(item.getName(), item);
            System.out.println("You have picked " + item.getName());
    }

    public void addStrength(int addedStrength){
        if((getStrength() + addedStrength) <= MAX && addedStrength > 0){
            setStrength(getStrength() + addedStrength);
            System.out.printf("You have %d strength points now.", getStrength());
        } else if ((getStrength() + addedStrength) > MAX){
            setStrength(MAX);;
            System.out.println("You are at MAX strength.");
        }
    }

    //FUNZIONI DEL KILL'S COUNTER
    public void addKillsCounter(){
        killsCounter++;
        if(killsCounter == 5){
            setStamina(getStamina() + 1);
            killsCounter = 0;
        }
    }
    public int getKillsCounter(){
        return killsCounter;
    }

    public int getRespawnCounter() {
        return respawnCounter;
    }
    public void setRespawnCounter(int respawnCounter) {
        this.respawnCounter = respawnCounter;
    }

}
