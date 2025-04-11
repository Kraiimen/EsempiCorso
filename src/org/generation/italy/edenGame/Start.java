package org.generation.italy.edenGame;


import org.generation.italy.edenGame.entity.Enemies.Enemies;

import org.generation.italy.edenGame.entity.npc.HighPriest;
import org.generation.italy.edenGame.entity.npc.Npc;
import org.generation.italy.edenGame.entity.player.*;
import org.generation.italy.edenGame.room.*;

import java.io.Console;
import java.util.Map;
import java.util.Random;

public class Start {
    public static void main(String[] args) {

        //INTRO DEL GIOCO
        Console console = System.console();
        System.out.println("Benvenuto in EdenGame, qual'è il tuo nome?");
        String playerName = console.readLine();
        System.out.println("Ciao " + playerName + ", scegli il nome del tuo personaggio");
        String name = console.readLine();
        System.out.println("Ora scegli la categoria tra: Wizard, Paladin, Priest, Thief");
        String answer;

        //inizializzazione Movimenti e Rooms

        Movements movements = new Movements();
        Map<String, Room> roomFinder = movements.getRoomFinder();

        Map<Compass, String> templeSquareDirections = movements.getTempleSquareDirections();
        Room templeSquare = movements.getTempleSquare();

        Map<Compass, String> templeDirections = movements.getTempleDirections();
        Room temple = movements.getTemple();

        Map<Compass, String> marketSquareDirections = movements.getMarketSquareDirections();
        Room marketSquare = movements.getMarketSquare();

        Map<Compass, String> bakeryDirections = movements.getBakeryDirections();
        Room bakery = movements.getBakery();

        Map<Compass, String> armoryDirections = movements.getArmoryDirections();
        Room armory = movements.getArmory();

        Map<Compass, String> gardensDirections = movements.getGardensDirections();
        Room gardens = movements.getGardens();

        Map<Compass, String> cityDoorDirections = movements.getCityDoorDirections();
        Room cityDoor = movements.getCityDoor();

        Map<Compass, String> woodsDirections = movements.getWoodsDirections();
        Room woods = movements.getWoods();


        //INIZIALIZZAZIONE GIOCATORE
        Random dice = new Random();
        Player player = null;


        do {
            System.out.println("Scegli una categoria tra le suggerite");
            answer = console.readLine();
            if (answer.toLowerCase().equals("wizard")) {
                int intelligence = dice.nextInt(20);
                int strength = dice.nextInt(5);
                int agility = dice.nextInt(10);
                int stamina = dice.nextInt(10);
                player = new Wizard(name, 10, 10, 1, 0, templeSquare, playerName, intelligence, strength, agility, stamina);
                System.out.println("Ottimo, il tuo giocatore si chiama " + name + " ed è un Wizard");
                System.out.printf(" intelligence: %d%n strength: %d%n agility: %d%n stamina %d%n", intelligence, strength, agility, stamina);

            } else if (answer.toLowerCase().equals("paladin")) {
                int intelligence = dice.nextInt(5);
                int strength = dice.nextInt(20);
                int agility = dice.nextInt(5);
                int stamina = dice.nextInt(15);
                player = new Paladin(name, 10, 10, 1, 0, templeSquare, playerName, intelligence, strength, agility, stamina);
                System.out.println("Ottimo, il tuo giocatore si chiama " + name + " ed è un Paladin");
                System.out.printf(" intelligence: %d%n strength: %d%n agility: %d%n stamina %d%n", intelligence, strength, agility, stamina);

            } else if (answer.toLowerCase().equals("priest")) {
                int intelligence = dice.nextInt(15);
                int strength = dice.nextInt(5);
                int agility = dice.nextInt(5);
                int stamina = dice.nextInt(20);
                player = new Priest(name, 10, 10, 1, 0, templeSquare, playerName, intelligence, strength, agility, stamina);
                System.out.println("Ottimo, il tuo giocatore si chiama " + name + " ed è un Priest");
                System.out.printf(" intelligence: %d%n strength: %d%n agility: %d%n stamina %d%n", intelligence, strength, agility, stamina);

            } else if (answer.toLowerCase().equals("thief")) {
                int intelligence = dice.nextInt(15);
                int strength = dice.nextInt(5);
                int agility = dice.nextInt(20);
                int stamina = dice.nextInt(5);
                player = new Thief(name, 10, 10, 1, 0, templeSquare, playerName, intelligence, strength, agility, stamina);
                System.out.println("Ottimo, il tuo giocatore si chiama " + name + " ed è un Thief");
                System.out.printf(" intelligence: %d%n strength: %d%n agility: %d%n stamina %d%n", intelligence, strength, agility, stamina);
            }

        } while (!answer.toLowerCase().equals("wizard")
                && !answer.toLowerCase().equals("paladin")
                && !answer.toLowerCase().equals("priest")
                && !answer.toLowerCase().equals("thief"));

        System.out.println("La tua storia inizia qui: " + "\n");
        player.setCurrentRoom(templeSquare);
        System.out.println(" ");


        //MOVIMENTO A PIACERE
        String a2;

        do {
            if(player.getHealthPoints() <= 0) {
                player.setCurrentRoom(temple);
                player.setHealthPoints(player.getMaxHp());
            }
            boolean checkEnemies = player.getCurrentRoom().isCheckEnemies();
            Enemies currentEnemy = player.getCurrentRoom().getEnemy();
            if(checkEnemies) {
                System.out.println("In questo luogo è presente: " + currentEnemy.getClass().getSimpleName() + " di nome: ''" + currentEnemy.getName() + "'' ");
                System.out.println(" ");
            }
            System.out.println("Scegli la tua prossima mossa o scrivi ''Quit'' per uscire: ");
            player.getCurrentRoom().getPossibleActions();
            a2 = console.readLine().toLowerCase();

            if(a2.equals("e")) {
                movements.moveFromRoom(player);

            } else if (a2.equals("a")) {

                if(checkEnemies){
                    player.doCombat(player, currentEnemy);
                    player.getCurrentRoom().setCheckEnemies(false);
                } else {
                    System.out.println("Non ci sono più nemici in questo luogo");
                }

            } else if (a2.equals("p")) {
                if(player.getExp() < 10) {
                    System.out.println("Hai troppa poca exp, non sei ancora degno");
                } else if(player.getExp() >= 10){
                    Npc highPriest = new HighPriest("Sacerdote", 1, 1, 1, 1);
                    player.getCurrentRoom().getNpc().speak(player);
                }

            } else if (a2.equals("i")) {
                System.out.println("Le tue statistiche sono :");
                System.out.println(" ");
                System.out.println("Intelligence: " + player.getIntelligence());
                System.out.println("Strength: " + player.getStrength());
                System.out.println("Agility: " + player.getAgility());
                System.out.println("Stamina: " + player.getStamina());
                System.out.println("Health Points: " + player.getHealthPoints() + " / " + player.getMaxHp());
                System.out.println("Damage Ability: " + player.getDamage());
                System.out.println("Experience: " + player.getExp());
                System.out.println(" ");

            } else if (a2.equals("r")) {
                player.setHealthPoints(player.getMaxHp());
                System.out.println("Ti sei riposato e ora hai il massimo della vita");
            } else if (a2.equals("c")) {
                Random dice2 = new Random();
                int chanceOfItem = dice.nextInt(100);
                if (chanceOfItem < 20){
                    System.out.println("Non hai trovato nulla");
                }else if (chanceOfItem >= 20 && chanceOfItem <= 60){
                    player.useErbaGatta();
                }else if (chanceOfItem > 60 &&chanceOfItem < 90){
                    player.useChiavePrigioni();
                }else {
                    player.useSpadaDiEden();
                }
            }

        } while(!a2.equals("quit"));

    }

}
