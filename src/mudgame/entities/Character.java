package mudgame.entities;

public class Character extends Player{
    private int defense;
    private int attack;

    public Character(String name, int hp, String characterName, int def, int atk) {
        super(name, hp, characterName);
        defense = def;
        attack = atk;
    }
}
