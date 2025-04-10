package mud.characters.fightable.monsters;

import mud.characters.fightable.Character;
import mud.characters.fightable.PlayerCharacter;

public class Guard extends Monster {
    public Guard(String name) {
        super(name);
    }

    public void killForTheCat(PlayerCharacter player){
        System.out.println(getName() + " the Guard says: HEY! WHAT ARE YOU DOING? I'LL SHOW YOU WHAT HAPPENS TO CRIMINALS LIKE YOU!");
        player.die();
    }
}
