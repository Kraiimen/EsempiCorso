package org.generation.italy.capstonProject.mudGame.entity.items;

import org.generation.italy.capstonProject.mudGame.entity.player.Player;

import java.util.Objects;

public class Item {
    private String name;
    private boolean reusable;

    public Item(String name, boolean isReusable){
        this.name = name;
        this.reusable = isReusable;
    }

    public void applyEffect(Player player){
        player.healMissingHP(0.5);
    }

    public String getName() {
        return name;
    }

    public boolean isReusable() {
        return reusable;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(this.name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name: '" + name + '\'' +
                ", reusable: " + reusable +
                '}';
    }
}
