package org.generation.italy.capstonProject.mudGame.entity.player;

import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

public class Paladin extends Player{
    private boolean isVirgin;

    private static final int MIN_STRENGTH = 5;

    public Paladin(String charName, Room currentRoom, String playerName, boolean isVirgin) {
        super(charName, currentRoom, playerName, PlayerRole.PALADIN);
        setIntelligence(rand.nextInt(getMAX_INTELLIGENCE() + 1));
        setStrength(rand.nextInt(MIN_STRENGTH, getMAX_STRENGTH() + 1));
        setAgility(rand.nextInt( getMAX_AGILITY() + 1));
        setStamina(rand.nextInt(getMAX_STAMINA() + 1));
        this.isVirgin = isVirgin;
    }

    @Override
    public int calculateDamage() {
        int weaponBonusDamage = (getEquippedWeapon() !=null) ? getEquippedWeapon().getBonusDamage() : 0;
        int baseDamage = rand.nextInt(getMaxDamage() + 1);
        if(isVirgin){
            baseDamage += 3;
        }
        damage = baseDamage + weaponBonusDamage;
        return damage;
    }
}
