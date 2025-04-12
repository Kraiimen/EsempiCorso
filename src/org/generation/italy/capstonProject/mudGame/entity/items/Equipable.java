package org.generation.italy.capstonProject.mudGame.entity.items;

import org.generation.italy.capstonProject.mudGame.entity.player.Player;

public interface Equipable {
    void equip(Player player);
    void unequip(Player player);
}
