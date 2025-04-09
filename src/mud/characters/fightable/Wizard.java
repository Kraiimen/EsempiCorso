package mud.characters.fightable;

import personal.mudGame.Player;

public class Wizard extends PlayerCharacter {
    private static int minIntelligence = 15;
    private static int minStrenght = 8;
    private static int minAgility = 5;
    private static int minStamina = 12;

    public Wizard(String name){
        super(name, minIntelligence, minStrenght, minAgility, minStamina);
    }

}
