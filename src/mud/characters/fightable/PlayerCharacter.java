package mud.characters.fightable;

import mud.CardinalPoints;
import mud.characters.fightable.monsters.Monster;
import mud.rooms.MagicMap;

public abstract class PlayerCharacter extends Character {


    public PlayerCharacter(String name, int minIntelligence, int minStrenght, int minAgility, int minStamina){
        super(name);
        setIntelligence(dice.nextInt(minIntelligence, MAX));
        setStrength(dice.nextInt(minStrenght, MAX));
        setAgility(dice.nextInt(minAgility, MAX));
        setStamina(dice.nextInt(minStamina, MAX));
        setActualRoom(MagicMap.getRooms().getFirst());
    }

    @Override
    public void changeRoom(CardinalPoints cardinal) {
        if (getActualRoom().getDirections().containsKey(cardinal)) {
            getActualRoom().leaveRoom(this);
            getActualRoom().getDirections().get(cardinal).enterInRoom(this);
            getActualRoom().printEntrance();
        } else {
            System.out.println("The road is closed. You're still at " + getActualRoom().getName());
        }
    }

    public void attack(Monster monster) {

    };

}
