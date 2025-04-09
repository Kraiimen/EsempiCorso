package mud.characters.fightable;

public abstract class Monster extends Character {
    private int minExpToFight;

    public Monster(String name) {
        super(name);
    }
//    per i mostri piu deboli o metto un massimo di forza o decido direttamente quanto sono forti
//    public Monster(String name, int maxIntelligence, int maxStrenght, int maxAgility, int maxStamina) {
//        super(name);
//            setIntelligence(dice.nextInt(MIN, MAX));
//            setStrenght(dice.nextInt(MIN, MAX));
//            setAgility(dice.nextInt(MIN, MAX));
//            setStamina(dice.nextInt(MIN, MAX));
//         }
}
