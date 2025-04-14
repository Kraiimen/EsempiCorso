package sud.entity.npc;

import sud.entity.player.Player;
import sud.inventory.Inventory;
import sud.inventory.Item;
import sud.start.Game;

import java.util.Optional;
import java.util.stream.Collectors;

public class Seller extends Npc implements InteractableNpc {
    Inventory inventory;
    String welcomePhrase;
    String goodbyePhrase;
    String productsPhrase;
    String pickItemPhrase;
    String outOfStockPhrase;
    String balanceIssuePhrase;
    String itemSoldPhrase;


    public Seller(String name) {
        super(name, 1, 0);
        this.inventory = new Inventory();
        this.welcomePhrase = "Hello. Welcome to my shop";
        this.productsPhrase = "Here are my wares";
        this.pickItemPhrase = "Which item would you like to buy?";
        this.outOfStockPhrase = "Sorry, I'm currently out of stock";
        this.balanceIssuePhrase = "You don't seem to have enough money for that";
        this.itemSoldPhrase = "Deal! Enjoy your item!";
        this.goodbyePhrase = "Goodbye! Come again";

    }

    @Override
    public void interact(Player player) {
        say(welcomePhrase);
        if (inventory.isEmpty()) {
            say(outOfStockPhrase);
            return;
        }
        say(productsPhrase);
        System.out.println(inventory.stream()
                .map(entry -> entry.getKey() + " x " + entry.getValue() + ": "
                        + entry.getKey().getCost() + "$ each")
                .collect(Collectors.joining("\n")));
        while (true) {
            say(pickItemPhrase);
            String wantedProductInput = Game.scanner.nextLine();
            if (Game.isQuitCommand(wantedProductInput)) {
                say(goodbyePhrase);
                return;
            }
            Optional<Item> wantedProduct = inventory.getItemWithName(wantedProductInput);
            if (wantedProduct.isEmpty()) {
                System.out.println("Product name not found. Try again");
                continue;
            }
            if (!player.hasMoneyAmount(wantedProduct.get().getCost())) {
                say(balanceIssuePhrase);
                continue;
            }
            say(itemSoldPhrase);
            player.getInventory().addItem(wantedProduct.get());
            inventory.removeItem(wantedProduct.get());
            player.removeMoney(wantedProduct.get().getCost());
            say(goodbyePhrase);
            break;
        }
    }

    public void say(String phrase) {
        System.out.println(getName() + ": " + phrase);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setWelcomePhrase(String welcomePhrase) {
        this.welcomePhrase = welcomePhrase;
    }

    public void setGoodbyePhrase(String goodbyePhrase) {
        this.goodbyePhrase = goodbyePhrase;
    }

    public void setOutOfStockPhrase(String outOfStockPhrase) {
        this.outOfStockPhrase = outOfStockPhrase;
    }

    public void setBalanceIssuePhrase(String balanceIssuePhrase) {
        this.balanceIssuePhrase = balanceIssuePhrase;
    }

    public void setItemSoldPhrase(String itemSoldPhrase) {
        this.itemSoldPhrase = itemSoldPhrase;
    }
}
