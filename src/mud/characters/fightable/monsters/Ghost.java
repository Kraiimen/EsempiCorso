package mud.characters.fightable.monsters;

import mud.characters.fightable.Character;
import mud.rooms.MagicMap;

import static mud.characters.fightable.Character.dice;

public class Ghost extends Monster {
    private static final int MIN_GHOST = 10;
    private static final int MAX_GHOST = 18;
    private static final int GHOST_EXP_GIVEN = 3;
    private static final int GHOST_POSSIBLE_ROOM_START = 6;
    private static final int GHOST_POSSIBLE_ROOM_END = 8;
    private static final int GHOST_HP = 20;
    private String greetmessage;

    public Ghost(String name) {
        super(name);
        setStrength(dice.nextInt(MIN_GHOST, MAX_GHOST));
        setAgility(dice.nextInt(MIN_GHOST, MAX_GHOST));
        setStamina(MAX_GHOST);
        setActualRoom(MagicMap.getRooms().get(dice.nextInt(GHOST_POSSIBLE_ROOM_START, GHOST_POSSIBLE_ROOM_END)));
        setExpGiven(GHOST_EXP_GIVEN);
        setHp(GHOST_HP);
    }
    public Ghost(String name, String greetmessage) {
        this(name);
        this.greetmessage = greetmessage;
    }

    @Override
    public void respawn() {
        if(!checkIfAlive()) {
            setIsAlive(true);
            setHp(GHOST_HP);
            setActualRoom(MagicMap.getRooms().get(dice.nextInt(GHOST_POSSIBLE_ROOM_START, GHOST_POSSIBLE_ROOM_END)));
        }
    }
    @Override
    public void greet(){
        System.out.println(getName() + " says : " + greetmessage);
    }
}
