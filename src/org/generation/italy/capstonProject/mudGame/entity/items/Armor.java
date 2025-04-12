package org.generation.italy.capstonProject.mudGame.entity.items;

import org.generation.italy.capstonProject.mudGame.entity.player.Player;

public class Armor extends Item implements Equipable{
    private int bonusAgility;
    private int bonusIntelligence;
    private int bonusStamina;

    public Armor(String name, int bonusAgility, int bonusIntelligence, int bonusStamina) {
        super(name);
        this.bonusAgility = bonusAgility;
        this.bonusIntelligence = bonusIntelligence;
        this.bonusStamina = bonusStamina;
    }

    @Override
    public void equip(Player player) {
        player.setEquippedArmor(this);
    }

    @Override
    public void unequip(Player player) {
        player.removeEquippedArmor();
    }

    public int getBonusAgility() {
        return bonusAgility;
    }

    public void setBonusAgility(int bonusAgility) {
        this.bonusAgility = bonusAgility;
    }

    public int getBonusIntelligence() {
        return bonusIntelligence;
    }

    public void setBonusIntelligence(int bonusIntelligence) {
        this.bonusIntelligence = bonusIntelligence;
    }

    public int getBonusStamina() {
        return bonusStamina;
    }

    public void setBonusStamina(int bonusStamina) {
        this.bonusStamina = bonusStamina;
    }

    @Override
    public String toString() {
        return "  Armor{" +
                "   \nname: " + getName() +
                (bonusAgility > 0 ? ",      \nagility points: " + bonusAgility : "") +
                (bonusIntelligence > 0 ? ",     \nintelligence points: " + bonusIntelligence : "") +
                (bonusStamina > 0 ? ",      \nstamina points: " + bonusStamina : "") +
                "\n}";
    }
}
