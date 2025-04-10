package mud.characters.fightable.monsters;

import mud.characters.fightable.Character;
import mud.rooms.MagicMap;

public class Goblin extends Monster {
    private static final int MIN_GOB = 2;
    private static final int MAX_GOB = 7;
    private static final int GOB_EXP_GIVEN = 2;
    private static final int GOB_POSSIBLE_ROOM_START= 5;
    private static final int GOB_POSSIBLE_ROOM_END= 7;
    private static final int GOB_HP = 15;

    public Goblin(String name) {
        super(name);
        setStrength(dice.nextInt(MIN_GOB, MAX_GOB));
        setAgility(dice.nextInt(MIN_GOB, MAX_GOB));
        setStamina(MAX_GOB);
        setActualRoom(MagicMap.getRooms().get(dice.nextInt(GOB_POSSIBLE_ROOM_START,GOB_POSSIBLE_ROOM_END)));
        setExp(GOB_EXP_GIVEN);
        setHp(GOB_HP);
    }
    @Override
    public void respawn() {
        if(!checkIfAlive()) {
            setIsAlive();
            setHp(GOB_HP);
            setActualRoom(MagicMap.getRooms().get(dice.nextInt(GOB_POSSIBLE_ROOM_START, GOB_POSSIBLE_ROOM_END)));
        }
    }
}
