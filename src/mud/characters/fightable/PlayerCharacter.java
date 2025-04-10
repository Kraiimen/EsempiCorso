package mud.characters.fightable;

import mud.CardinalPoints;
import mud.rooms.MagicMap;

public abstract class PlayerCharacter extends Character {

    private static final int STARTING_STAM = 5;
    private static final int MAX_RESPAWN = 5;
    private int killsCounter;
    private int respawnCounter;


    public PlayerCharacter(String name, int minIntelligence, int minStrength, int minAgility, int minStamina){
        super(name);
        setIntelligence(dice.nextInt(minIntelligence, MAX));
        setStrength(dice.nextInt(minStrength, MAX));
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
                heal(2);
            }
        } else {
            System.out.println("The road is closed. You're still at " + getActualRoom().getName());
        }
    }

    public void respawn(){
        if(respawnCounter < MAX_RESPAWN){
            setIsAlive();
            respawnCounter++;
            setActualRoom(MagicMap.getRooms().getFirst());
            System.out.printf("Welcome back! You are now in %s and you have %d respawn possibilities left!",
                    MagicMap.getRooms().getFirst().getName(),MAX_RESPAWN-respawnCounter);
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

}
