package mud.characters.fightable.monsters;

import mud.characters.fightable.Character;
import mud.characters.fightable.PlayerCharacter;
import mud.rooms.MagicMap;

import static mud.GameUtil.player;

public class Guard extends Monster {
    public static final int GUARD_POSSIBLE_ROOM = 8;

    public Guard(String name) {
        super(name);
        setStrength(dice.nextInt(MAX));
        setAgility(dice.nextInt(MAX));
        setActualRoom(MagicMap.getRooms().get(dice.nextInt(GUARD_POSSIBLE_ROOM)));
        setHp(MAX_HP);
    }

    public void killForTheCat(){
        System.out.println(getName() + " the Guard says: HEY! WHAT ARE YOU DOING? I'LL SHOW YOU WHAT HAPPENS TO CRIMINALS LIKE YOU!");
        player.die();
    }

    @Override
    public void respawn() {
        if(!checkIfAlive()){
            setIsAlive(true);
            setHp(MAX_HP);
            setActualRoom(MagicMap.getRooms().get(dice.nextInt(GUARD_POSSIBLE_ROOM)));
        }
    }
}
