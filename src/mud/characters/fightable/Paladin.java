package mud.characters.fightable;

import personal.mudGame.Player;

public class Paladin extends PlayerCharacter {
    private static int minIntelligence = 5;
    private static int minStrength = 8;
    private static int minAgility = 10;
    private static int minStamina = 10;

    public Paladin(String name) {
        super(name, minIntelligence, minStrength, minAgility, minStamina);
    }
}
