package org.generation.italy.capstonProject.mudGame.entity.items;

import org.generation.italy.capstonProject.mudGame.entity.player.Player;

public class Potion extends Item implements Consumable{
    private double healAmount;
    private int expAmount;

    public Potion(String name, double healAmount, int expAmount) {
        super(name);
        this.healAmount = healAmount;
        this.expAmount = expAmount;
    }

    @Override
    public void consume(Player player) {
        System.out.println("You used the " + getName());
        if(this.healAmount > 0){
            player.heal(healAmount);
            System.out.println("This is magic for your health! You drank this magic potion and now have " + player.getHealthPoints() + "/" + player.getMaxHP() + " HP.");
        }
        if(this.expAmount > 0){
            player.setExperience(player.getExperience() + expAmount);
            if(player.getExperience() >= player.getMaxExperience()){
                player.levelUp();
            }
            System.out.println("You gained experience! You drank this magic potion and now have " + player.getExperience() + "/" + player.getMaxExperience() + " experience.");
        }

    }

    public double getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(double healAmount) {
        this.healAmount = healAmount;
    }

    public int getExpAmount() {
        return expAmount;
    }

    public void setExpAmount(int expAmount) {
        this.expAmount = expAmount;
    }

    @Override
    public String toString() {
        return " \n     Potion{" +
                "\n          name: " + getName() +
                (healAmount > 0 ? ",    \n          health points: " + healAmount : "") +
                (expAmount > 0 ? ",     \n          experience points: " + expAmount : "") +
                "\n     }";
    }
}
