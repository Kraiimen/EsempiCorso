package org.generation.italy.capstonProject.mudGame.entity.npc;

import org.generation.italy.capstonProject.mudGame.entity.GameMenuUtils;
import org.generation.italy.capstonProject.mudGame.entity.items.Item;
import org.generation.italy.capstonProject.mudGame.entity.player.Player;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Vendor extends Npc{
    private Map<Item, Integer> prices;

    public Vendor(String charName, int maxHP, Room currentRoom) {
        super(charName, maxHP, 7, currentRoom, false, NpcRole.VENDOR);
        getMessages().add("\033[0;33m" +  "Ehi compare. Vuoi comprare una meridiana?" + "\033[0m");
        this.prices = new HashMap<>();
    }

    public void seeShop(Player player, Scanner scanner) {
        System.out.println("\033[0;33m" +  "Welcome to my shop! Take a look around:" + "\033[0m");
        if (inventory.getAll().isEmpty()) {
            System.out.println("\033[0;33m" + "Sorry, looks like I need to do a restock. Shop is closed for the day." + "\033[0m");
        } else {
            GameMenuUtils.displayShopMenu(this, player, scanner);
        }
    }

    public void sell(Player player, Item item){
        if(inventory.getAll().containsKey(item) && prices.containsKey(item)){
            inventory.removeItem(item);
            player.pay(prices.get(item));
            player.getInventory().addItem(item);
            System.out.println("\033[0;32m" + "You bought: " + item.getName() + ". You can find it in your inventory." + "\033[0m");
        } else {
            System.out.println("Sorry, item out of stock.");
        }
    }

    public void setPrice(Item item, int price){
        if(inventory.getAll().containsKey(item)){
            prices.put(item, price);
        } else {
            System.out.println("This item is not in the vendor's inventory.");
        }
    }

    public Map<Item, Integer> getPrices() {
        return prices;
    }
}
