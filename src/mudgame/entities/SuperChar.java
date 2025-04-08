package mudgame.entities;

public class SuperChar extends Player{
    private int defense;
    private int attack;

    public SuperChar(String name, int hp, String characterName, int def, int atk) {
        super(name, hp, characterName);
        defense = def;
        attack = atk;
    }
}
