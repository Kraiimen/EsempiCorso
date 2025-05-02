package personal.mudGame;

import personal.mudGame.items.*;

public class Wizard extends Player {
    private int mana;
    private final static int MAX_MANA = 100;
    private final static int START_MANA = 20;

    public Wizard(String name, int maxHP, int power, String playerName) {
        super(name, maxHP, power, playerName);
        mana = START_MANA;
    }
    public void addMana(Wand wand){
        mana += wand.getManaPlus();
    }

    @Override
    public void pickItem(Item item){
        getInventory().add(item);
        if (item.getItemType() == ItemType.WEAPON){
            Weapon weapon = (Weapon)item;
            addPowerPlus(weapon);
            if(weapon instanceof Wand){
                Wand wand = (Wand)weapon;
                addMana(wand);
            }
        } else if(item.getItemType() == ItemType.SHIELD){
            Shield shield = (Shield)item;
            addProtection(shield);
        }
    }
}
