package org.generation.italy.capstonProject.mudGame.entity.items;

import org.generation.italy.capstonProject.mudGame.entity.player.Player;

import java.util.Objects;

public abstract class Item {
    private String name;

    public Item(String name){
        this.name = name;
    }

    public void applyEffect(Player player){
        player.heal(0.5);
    }

    public void inspect(){
        System.out.println(this);
    }

    public String getName() {
        return name;
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
                "\nname: '" + name + '\'' +
                "\n}";
    }
}
