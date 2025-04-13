package sud.items;

import sud.dices;

import java.util.HashMap;
import java.util.Map;

public class Item {
    private int price;
    private ItemType type;
    private String name;
    public static Map<String,Item> itemMap = new HashMap();

    public Item(int price, ItemType type, String name) {
        this.price = price;
        this.type = type;
        this.name = name;
    }
    static{
        Food bread= new Food(2, "Bread", 5);
        itemMap.put("bread",bread);
        Food apple= new Food(1, "Apple", 1);
        itemMap.put("apple",apple);
        Food cupcake= new Food(5, "Cute Cat Cupcake :3", 10);
        itemMap.put("cupcake",cupcake);
        Food chickenLeg = new Food(2, "Chicken Leg", 5);
        itemMap.put("chicken",chickenLeg);
        Food tea = new Food(2, "tea", 2);
        itemMap.put("tea",tea);
        Item fineWine = new Item(dices.rd20(), ItemType.FOOD, "Fine wine");
        itemMap.put("wine",fineWine);
        Item Cheapwine = new Item(dices.rd20(), ItemType.FOOD, "Cheap wine");
        itemMap.put("cheapwine",Cheapwine);
        Armor leatherArmor = new Armor(50, "Leather armor",5,1);
        itemMap.put("leatherarmor",leatherArmor);
        Armor chainMail = new Armor(80, "Chain mail",8,2);
        itemMap.put("chainmail",chainMail);
        Armor fullplate = new Armor(120, "Full plate armor",10,4);
        itemMap.put("fullplate",fullplate);
        Weapon dagger = new Weapon(20,"Dagger",4);
        itemMap.put("dagger",dagger);
        Weapon sword = new Weapon(30,"Sword",6);
        itemMap.put("sword",sword);
        Weapon grateSword = new Weapon(60,"Grate sword",12);
        itemMap.put("gratesword",grateSword);
        Weapon grateaxe = new Weapon(60,"Grate axe",12);
        itemMap.put("grateaxe",grateaxe);
        Potion healingP = new HealingPotion(10,"Healing potion",15);
        itemMap.put("healingp",healingP);
        Potion manaP = new ManaPotion(10,"Mana potion",dices.rd6());
        itemMap.put("manap",manaP);
        Potion tpP = new TeleportPotion(25,"Teleport potion");
        itemMap.put("tpp",tpP);
        Item coins = new Item(dices.rd6(), ItemType.JUNK, "Gold Coins");
        itemMap.put("coins",coins);
        Item crittersSkin = new Item(4, ItemType.JUNK, "Critter's Skin");
        itemMap.put("crittersskin",crittersSkin);
        Item goblinTeeth = new Item(2,ItemType.JUNK, "Goblin Teeth");
        itemMap.put("goblinteeth",goblinTeeth);
        Item goblinDoll = new Item(6, ItemType.JUNK, "Goblin Doll");
        itemMap.put("goblindoll",goblinDoll);
        Item goblinWeapon = new Item(5, ItemType.JUNK, "Goblin's weapon");
        itemMap.put("goblinweapon",goblinWeapon);
        Item bugBearArmor = new Item(10, ItemType.JUNK,"BugBear's broken Armor");
        itemMap.put("bugbearbrokenarmor",bugBearArmor);
        Item ogresFang = new Item(25, ItemType.JUNK,"Ogre's broken Fang");
        itemMap.put("ogrefang",ogresFang);
        Item THEMAGICRING  = new Item(10000,ItemType.JUNK,"THE MAGIC RING OF THE EVIL WARLORD");
        itemMap.put("ring",THEMAGICRING);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
