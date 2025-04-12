package rpgProject.start;

import rpgProject.model.*;

public class Start {
    public static void main(String[] args) {
        // Create player
        Warrior warrior = new Warrior("Achille", 200, 1);
        Mage mage = new Mage("Aphrodite", 100, 1);
        Paladin paladin = new Paladin("Cupid",150,1);
        Pet fenrir = new Pet("Fenrir",100,50,"Pet");
        Pet doggo = new Pet("Doggo",50,20,"Pet");

        //Create Consumable
        Consumable carrot = new Consumable("Carrot",1,20);
        Consumable goldenApple = new Consumable("Golden Apple",1,200);

        // Create enemy
        Orc orc = new Orc("Orc", 50, 1, 20);
        Orc orc2 = new Orc("Orc", 50, 1, 20);

        // Stats
        warrior.displayInfo();
        mage.displayInfo();
        orc.displayInfo();
        fenrir.displayInfo();
        doggo.displayInfo();

        // Battle
        System.out.println("=== Battle Begins! ===");
        warrior.displayInfo();
        mage.displayInfo();
        paladin.cure(warrior);
        paladin.cure(mage);
        paladin.cure(paladin);
        mage.castFireball(orc);
        paladin.use(carrot);
        paladin.use(goldenApple);
        paladin.salvation(orc);
        fenrir.attackHeal(orc2,warrior);
        doggo.attackHeal(orc2,paladin);
        orc.displayInfo();
        warrior.displayInfo();


    }
}

