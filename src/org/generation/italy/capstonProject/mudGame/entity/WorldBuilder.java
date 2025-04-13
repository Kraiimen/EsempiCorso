package org.generation.italy.capstonProject.mudGame.entity;

import org.generation.italy.capstonProject.mudGame.entity.items.*;
import org.generation.italy.capstonProject.mudGame.entity.npc.*;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

public class WorldBuilder {
    public static void populateWorld(){
        Room templeSquare = Room.getRoomByName("Temple Square");
        Room temple = Room.getRoomByName("Temple");
        Room marketSquare = Room.getRoomByName("Market Square");
        Room armory = Room.getRoomByName("Armory");
        Room bakery = Room.getRoomByName("Bakery");
        Room gardenA = Room.getRoomByName("Garden A");
        Room gardenB = Room.getRoomByName("Garden B");
        Room gardenC = Room.getRoomByName("Garden C");
        Room cityDoors = Room.getRoomByName("City Doors");
        Room woods1 = Room.getRoomByName("Woods 1");

        Npc guard1 = new Guard("Giovanni", 60, templeSquare);
        Npc cat1 = new Cat("Whiskers", 20, templeSquare);
        Npc cat2 = new Cat("Kitty Purry", 20, temple);
        Npc cat3 = Cat.generateCat("Micio" ,35, temple);
        Npc cat4 = Cat.generateCat("Fuffy" ,35, armory);
        Npc cat5 = Cat.generateCat("Cat with a family of 5 (please don't kill this one. Think of the children)" ,27, armory);
        Npc cat6 = Cat.generateCat("Dorothy" ,25, bakery);
        Npc cat7 = Cat.generateCat("Michelle" ,40, gardenA);
        Npc cat8 = Cat.generateCat("Franco" ,28, gardenB);
        Npc cat9 = Cat.generateCat("Miao" ,20, gardenB);
        Npc cat10 = Cat.generateCat("Frederick" ,15, cityDoors);
        Npc guard4 = Guard.generateGuard("Bob", 60, cityDoors);
        Npc guard5 = Guard.generateGuard("Frank", 60, cityDoors);
        Npc guard6 = Guard.generateGuard("Susan", 60, bakery);
        Npc guard7 = Guard.generateGuard("Ajax", 60, gardenB);
        Npc enemy2 = Enemy.generateEnemy("uuuhhhhh", 30, gardenB);
        Npc enemy3 = Enemy.generateEnemy("josh", 35, gardenA);
        Npc enemy4 = Enemy.generateEnemy("josh", 25, bakery);
        Npc enemy5 = Enemy.generateEnemy("monster", 30, gardenC);

        Npc bigCato = new EnemyBoss("Big Cato", 100, 30, woods1, 0.5);
        Item ring = new Armor("The One Ring", 10, 10, 10);
        bigCato.getInventory().addItem(ring);

        guard1.getInventory().addItem(new Potion("Healing Potion", 0.5, 0));
        guard1.getInventory().addItem(new Weapon("Super sword", 6));
        guard1.getInventory().addItem(new Armor("Fancy boots", 1, 0, 3));
        guard1.getInventory().addItem(new Food("Avocado toast", 0.2));

        cat2.getInventory().addItem(new Weapon("Rusty Dagger", 3));

        Npc enemy1 = new Enemy("Very Mean Monster", 40, 7, gardenA, 0.3);
        Npc guard3 = new Guard("Guard 145", 60, marketSquare);
        enemy1.getInventory().addItem(new Armor("Wooden Shield", 3, 0, 0));
        enemy1.getInventory().addItem(new Food("Apple", 0.3));

        guard3.getInventory().addItem(new Food("Bread", 0.3));

        Vendor blacksmith = new Vendor("Blacksmith", 70, armory);

        Item weapon1 = new Weapon("Sword", 5);
        Item armor1 = new Armor("Helmet", 0, 2, 0);
        Item armor2 = new Armor("Iron Armor", 0, 0, 3);
        Item weapon2 = new Weapon("Silver Dagger", 7);
        Item weapon3 = new Weapon("Very big sword", 9);
        Item armor3 = new Armor("Boots", 4, 0, 1);

        blacksmith.inventory.addItem(weapon1);
        blacksmith.inventory.addItem(weapon2);
        blacksmith.inventory.addItem(weapon3);
        blacksmith.inventory.addItem(armor1);
        blacksmith.inventory.addItem(armor2);
        blacksmith.inventory.addItem(armor3);

        blacksmith.setPrice(weapon1, 3);
        blacksmith.setPrice(weapon2, 5);
        blacksmith.setPrice(weapon3, 9);
        blacksmith.setPrice(armor1, 4);
        blacksmith.setPrice(armor2, 2);
        blacksmith.setPrice(armor3, 6);

        Vendor baker = new Vendor("Baker", 70, bakery);

        baker.getInventory().addItem(new Food("Apple", 0.2));
        baker.getInventory().addItem(new Food("Banana Bread", 0.5));
        baker.getInventory().addItem(new Food("Bread", 0.3));
        baker.getInventory().addItem(new Food("Croissant", 0.4));
        baker.getInventory().addItem(new Food("Old Bread", 0.1));

        for(Item i : baker.getInventory().getAll().keySet()){
            baker.setPrice(i, (int)(Math.random() * 10));
        }


    }
}
