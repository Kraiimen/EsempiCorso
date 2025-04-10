package sud.items;

public class Item {
    private int price;
    private ItemType type;
    private String name;

    public Item(int price, ItemType type, String name) {
        this.price = price;
        this.type = type;
        this.name = name;
    }
    static{
        Food bread= new Food(1, "Bread", 5);
        Food apple= new Food(1, "Apple", 1);
        Food cupcake= new Food(5, "Cute Cat Cupcake :3", 10);
        Food chickenLeg = new Food(2, "Chicken Leg", 5);
        Armor leatherArmor = new Armor(50, "Leather armor",5);
        Armor chainMail = new Armor(80, "Chain mail",8);
        Armor fullplate = new Armor(120, "Full plate armor",10);
        Weapon dagger = new Weapon(20,"Dagger",4);
        Weapon sword = new Weapon(30,"Sword",6);
        Weapon grateSword = new Weapon(60,"Grate sword",12);
        Weapon grateaxe = new Weapon(60,"Grate axe",12);
        Item coins = new Item(5, ItemType.JUNK, "5 Gold Coins");
        Item goblinTeeth = new Item(2,ItemType.JUNK, "Goblin Teeth");
        Item goblinDoll = new Item(6, ItemType.JUNK, "Goblin Doll");
        Item crittersSkin = new Item(4, ItemType.JUNK, "Critter's Skin");
        Item goblinWeapon = new Item(5, ItemType.JUNK, "Goblin's weapon");
        Item bugBearArmor = new Item(10, ItemType.JUNK,"BugBear's broken Armor");
        Item ogresFang = new Item(25, ItemType.JUNK,"Ogre's broken Fang");

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
