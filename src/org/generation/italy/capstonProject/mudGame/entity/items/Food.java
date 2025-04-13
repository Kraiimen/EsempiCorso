package org.generation.italy.capstonProject.mudGame.entity.items;

import org.generation.italy.capstonProject.mudGame.entity.player.Player;

public class Food extends Item implements Consumable{
    private double healAmount;

    public Food(String name, double healAmount) {
        super(name);
        this.healAmount = healAmount;
    }

    @Override
    public void consume(Player player) {
        player.heal(healAmount);
        System.out.println("\033[0;32m" + "You eat the " + getName() + "\033[0m");
        System.out.println("\033[0;32m" + "Food is important for your health! You ate and now have " + player.getHealthPoints() + "/" + player.getMaxHP() + " HP." + "\033[0m");
    }

    public double getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(double healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public String toString() {
        return "\n     Food{" +
                "\n          name: " + getName() +
                ",\n          health points: " + healAmount +
                "\n     }";
    }
}
