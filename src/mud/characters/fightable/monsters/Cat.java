package mud.characters.fightable.monsters;

import mud.characters.fightable.Character;
import mud.rooms.MagicMap;

public class Cat extends Monster {
    private static final int MAX_CAT = 2;
    private static final int CAT_EXP_GIVEN = 2;
    private static final int CAT_POSSIBLE_ROOM= 4;
    private static final int CAT_HP = 9;

    public Cat(String name){
        super(name);
        setStrength(dice.nextInt(MIN, MAX_CAT) + 1);
        setAgility(dice.nextInt(MIN, MAX_CAT));
        setStamina(MIN);
        setActualRoom(MagicMap.getRooms().get(dice.nextInt(CAT_POSSIBLE_ROOM)));
        setHp(CAT_HP);
    }

    @Override
    public void respawn() {
        if(!checkIfAlive()) {
            setIsAlive();
            setHp(CAT_HP);
            setActualRoom(MagicMap.getRooms().get(dice.nextInt(CAT_POSSIBLE_ROOM)));
        }
    }

    @Override
    public void greet(){
        System.out.println("Meow!");
    }
}

