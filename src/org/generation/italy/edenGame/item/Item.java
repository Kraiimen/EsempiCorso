package org.generation.italy.edenGame.item;

import org.generation.italy.edenGame.entity.player.Player;

public abstract class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }
    public abstract void use(Player player);
}