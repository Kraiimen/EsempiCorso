package mud.characters.fightable.monsters;

import mud.characters.fightable.Character;
import mud.rooms.MagicMap;

public class Dragon extends Monster {
    private static final int MIN_DRAGON = 18;
    private static final int DRAGON_EXP = 20;
    private static final int DRAGON_EXP_GIVEN = 4;
    private static final int DRAGON_POSSIBLE_ROOM = 8;

    public Dragon(String name){
        super(name);
        setStrength(dice.nextInt(MIN_DRAGON, MAX));
        setAgility(dice.nextInt(MIN_DRAGON, MAX));
        setStamina(dice.nextInt(MAX));
        setExp(DRAGON_EXP);
        setExpGiven(DRAGON_EXP_GIVEN);
        setActualRoom(MagicMap.getRooms().get(DRAGON_POSSIBLE_ROOM));
        setHp(MAX_HP);
    }
    @Override
    public void respawn() {
        if(!checkIfAlive()) {
            setIsAlive();
            setHp(MAX_HP);
            setActualRoom(MagicMap.getRooms().get(DRAGON_POSSIBLE_ROOM));
        }
    }

}
