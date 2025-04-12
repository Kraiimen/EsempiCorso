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
        System.out.println("You eat the " + getName());
        System.out.println("Food is important for your health! You ate and now have " + player.getHealthPoints() + "/" + player.getMaxHP() + " HP.");
    }

    public double getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(double healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public String toString() {
        return "  Food{" +
                "   \nname: " + getName() +
                ",      \nhealth points: " + healAmount +
                "\n}";
    }
}
