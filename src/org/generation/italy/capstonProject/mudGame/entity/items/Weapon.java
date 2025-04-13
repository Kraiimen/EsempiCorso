package org.generation.italy.capstonProject.mudGame.entity.items;

import org.generation.italy.capstonProject.mudGame.entity.player.Player;

public class Weapon extends Item implements Equipable{
    private int bonusDamage;

    public Weapon(String name, int bonusDamage) {
        super(name);
        this.bonusDamage = bonusDamage;
    }

    @Override
    public void equip(Player player) {
        player.setEquippedWeapon(this);
    }

    @Override
    public void unequip(Player player) {
        player.removeEquippedWeapon();
    }

    public int getBonusDamage() {
        return bonusDamage;
    }

    public void setBonusDamage(int bonusDamage) {
        this.bonusDamage = bonusDamage;
    }

    @Override
    public String toString() {
        return "\n     Weapon{" +
                "\n          name: " + getName() +
                ",\n          damage points: " + bonusDamage +
                "\n     }";
    }
}
