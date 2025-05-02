package personal.mudGame.items;

import personal.mudGame.Player;

public abstract class Weapon extends Item {
    private int powerPlus;

    public Weapon(int powerPlus){
        super(ItemType.WEAPON);
        this.powerPlus = powerPlus;
    }

    public int getPowerPlus(){ return powerPlus; }
    public void givePowerPlus(Player player){
        player.setPower(player.getPower() + powerPlus);
    }
}
