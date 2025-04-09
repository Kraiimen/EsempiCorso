package mud.characters.fightable;

public class Thief extends PlayerCharacter {
    private static int minIntelligence = 12;
    private static int minStrength = 7;
    private static int minAgility = 13;
    private static int minStamina = 8;

    public Thief(String name){
        super(name, minIntelligence, minStrength, minAgility, minStamina);
    }

}
