package org.generation.italy.ravenClaw.mud;

import org.generation.italy.ravenClaw.mud.entity.*;
import org.generation.italy.ravenClaw.mud.objects.Item;
import org.generation.italy.ravenClaw.mud.objects.Weapon;

import java.io.Console;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        System.out.println();
        Console console = System.console();
        Random dice = new Random();
        String choice;
        Player player = null;  // POLYMORPHIC VARIABLE
        int fightRound =0;
        String wizardColor = "\033[34m";
        String paladinColor = "\033[33m";
        String berserkerColor = "\033[31m";
        String playerClass = console.readLine("Which class do you want to play? Wizard, Berserker, Paladin: ");
        String playerName = console.readLine("What do you want to name your hero? ");
        String realPlayerName = console.readLine("Player, what is your name? ");

        if(playerClass.equalsIgnoreCase("wizard")){
            player = new Wizard(playerName, dice.nextInt(50) + 1, dice.nextInt(10) + 1, realPlayerName, dice.nextInt(100) + 6,wizardColor);
        } else if(playerClass.equalsIgnoreCase("paladin")){
            player = new Paladin(playerName, dice.nextInt(50) + 25, dice.nextInt(20) + 1, realPlayerName,paladinColor);
        } else if (playerClass.equalsIgnoreCase("berserker")) {
            player = new Berserker(playerName, dice.nextInt(50) + 50, dice.nextInt(15) + 1, realPlayerName,berserkerColor);
        }
        player.printSheet();

        Npc prisonGuy = new Npc("Prison jerk", 30,15,40,true,"\033[32m");
        Weapon rustySword = new Weapon("Rusty sword", 0 , 5,5);
        choice = console.readLine("\nYou wake up in a stone cell, there is a rusty sword to your right \n if you want to pick it up type PICK \n otherwise type NO");
        if(choice.equalsIgnoreCase("PICK")){
            player.pickUpitem(rustySword);
            System.out.printf("you pick up the %s this boosts your attack damage to %d",rustySword.getName(),player.getAttackDamage());
        }
        System.out.println(" \n a man with long black hair stares at you from the other side of the cell. \n Hey \n What are you looking at? Are you looking for trouble?!\n");
        choice = console.readLine("It seems this guy isn't very friendly.\n If you want to attack him, type ATTACK, \n If you want to call a guard, type SHOUT ");

        if(choice.equalsIgnoreCase("ATTACK")){
            while(!prisonGuy.isDead()){
                fight(player,prisonGuy,fightRound);
                player.attack(prisonGuy);
                if (!prisonGuy.isDead()){
                    prisonGuy.attack(player);
                }
                if(player.isDead()){
                    System.out.println("\033[31mYOU DIED\033[0m");
                    System.exit(0);
                }
                fightRound++;
            }
            choice= console.readLine("\nThe troublemaker is dead, you find some bread among his belongings. \n If you want to eat it, type EAT, \n otherwise, type NO ");
            if (choice.equalsIgnoreCase("EAT")){
                player.eat();
            }
        } else if (choice.equalsIgnoreCase("SHOUT")) {
            System.out.println("\n You shout at the top of your lungs, but no one arrives. \n The guy seems irritated, and getting up from his cot, he punches you. \n Shut up for a bit!\n");
            prisonGuy.attack(player);
            choice = console.readLine("\nDo you want to counterattack? The guy seems very weakened. \n Type YES to counterattack \n Type NO to not counterattack and go to sleep");

            if (choice.equalsIgnoreCase("YES")){
                while(!prisonGuy.isDead()){
                    fight(player,prisonGuy,fightRound);
                    player.attack(prisonGuy);
                    if (!prisonGuy.isDead()){
                        prisonGuy.attack(player);
                    }
                    if(player.isDead()){
                        System.out.println("YOU DIED");
                        System.exit(0);
                    }
                    fightRound++;
                }
            }else if (choice.equalsIgnoreCase("NO")){
                player.sleep();
            }
        }
        System.out.println("\nYou have completed this sample game of our game. CONGRATULATIONS!!");


    }
    public static void fight(Entity player, Entity enemy, int round){

        if(round ==1){
            System.out.println("\nTHE BATTLE BEGINS!\n");
            System.out.printf("\nThe enemy has %d HP, you have %d HP\n",enemy.getHealthPoints(),player.getHealthPoints());
            System.out.printf("\nThe enemy's base damage is %d, your base damage is %d \n",enemy.getAttackDamage(),player.getAttackDamage());
            System.out.println("-----------------------------------------------\n");
        }else{
            System.out.printf("ROUND %d\n", round);
        }
    }
}
