package org.generation.italy.edenGame;

import org.generation.italy.edenGame.entity.Enemies.Enemies;
import org.generation.italy.edenGame.entity.player.*;

import java.io.Console;
import java.util.Random;

import static org.generation.italy.edenGame.Movements.*;

public class Game {
    Console console = System.console();
    Random dice = new Random();
    Player player = null;
    Movements movements = new Movements();
    public void printIntro() {
        //INTRO DEL GIOCO
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
        System.out.println(" ");
        System.out.println("✨✨✨✨✨ BENVENUTO IN EDEN GAME, UN MONDO MAGICO ✨✨✨✨✨");
        System.out.println(" ");
        System.out.println("⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔⚔");
        System.out.println(" ");
        System.out.println("Ti trovi nella città di Eden, in cui sono presenti molte entità sempre più forti: ");
        System.out.println("Gattini (deboli 👎🏻), Guardie Reali (media forza 👍🏻) e Goblin (forti 💪🏻)");
        System.out.println(" ");
        System.out.println("❌ ATTENZIONE ❌ ");
        System.out.println("Fuori dalla città ci sono gli Woods, dove sarà presente il grande mostro RICCORCRUX e i suoi Mostri Leggendari (forza leggendaria 🔥)");
        System.out.println("Ricorda anche di stare attento ad attaccare le Guardie Reali, perché inizialmente sei debole, ma nel Temple potrai trovare aiuto");
        System.out.println("Infine... nei meandri della città, sono sparsi oggetti che possono cambiare completamente le tue sorti");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
    }
    public void createCharacter(){
        //INIZIALIZZAZIONE GIOCATORE
        System.out.println("Per cominciare, qual'è il tuo nome? 🤨🤨");
        String playerName = console.readLine();
        System.out.println("Ciao " + playerName + ", scegli il nome del tuo personaggio 🗡️");
        String name = console.readLine();
        System.out.println("Ora scegli la categoria tra: WIZARD 🤓, PALADIN 🤪, PRIEST ✝️, THIEF 🥷");
        String answer;

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

    }
    public void exec(){
        System.out.println("La tua storia inizia qui: " + "\n");
        player.setCurrentRoom(templeSquare);
        System.out.println(" ");

        String a2;

        do {
            if (player.getHealthPoints() <= 0) {
                player.setCurrentRoom(temple);
                player.setHealthPoints(player.getMaxHp());
            }
            boolean checkEnemies = player.getCurrentRoom().getCheckEnemies();
            Enemies currentEnemy = player.getCurrentRoom().getEnemy();
            boolean checkSearch = player.getCurrentRoom().getCheckSearch();

            if (checkEnemies) {
                System.out.println("In questo luogo è presente: " + currentEnemy.getClass().getSimpleName() + " di nome: ''" + currentEnemy.getName() + "'' ");
                System.out.println(" ");
            }
            System.out.println("Scegli la tua prossima mossa o scrivi ''Quit'' per uscire: ");
            player.getCurrentRoom().getPossibleActions();
            a2 = console.readLine().toLowerCase();

            if (!player.getCurrentRoom().returnPossibleActions().contains(a2)) {
                System.out.println(" ");
                System.out.println("Non puoi compiere questa azione, scegline solo una tra quelle indicate");
                System.out.println(" ");
            } else {
                switch (a2) {
                    case "e" -> {
                        player.getCurrentRoom().setCheckSearch(true);
                        movements.moveFromRoom(player);
                    }
                    case "a" -> {
                        if (checkEnemies) {
                            player.doCombat(player, currentEnemy);
                            player.getCurrentRoom().setCheckEnemies(false);
                        } else {
                            System.out.println("Non ci sono più nemici in questo luogo 💀💀");
                        }
                    }
                    case "p" -> {
                        if (player.getExp() < 10) {
                            System.out.println("Hai troppa poca exp, non sei ancora degno 😒😒");
                        } else if (player.getExp() >= 10) {
                            player.getCurrentRoom().getNpc().speak(player);
                        }
                    }
                    case "i" -> {
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
                    }
                    case "r" -> {
                        player.setHealthPoints(player.getMaxHp());
                        System.out.println("Ti sei riposato e ora hai il massimo della vita 💪");
                    }
                    case "c" -> {
                        if (checkSearch) {
                            int chanceOfItem = dice.nextInt(100);
                            if (chanceOfItem < 50) {
                                System.out.println("Non hai trovato nulla");
                            } else if (chanceOfItem <= 85) {
                                player.useErbaGatta();
                            } else if (chanceOfItem <= 95) {
                                player.useChiavePrigioni();
                            } else {
                                player.useSpadaDiEden();
                            }
                            //PER ATTIVARE I CHEAT DELLA RICERCA OGGETTI COMMENTA LA LINEA SOTTO:
                            player.getCurrentRoom().setCheckSearch(false);
                        } else {
                            System.out.println("Hai già cercato qui :(");
                        }
                    }
                }
            }
        }
        while (!a2.equals("quit")) ;

        System.out.println(" ");
        System.out.println("THE END 🐣THE END 🐣THE END 🐣THE END 🐣THE END 🐣THE END 🐣THE END 🐣THE END 🐣THE END 🐣THE END 🐣THE END 🐣THE END 🐣THE END 🐣THE END 🐣THE END 🐣THE END 🐣THE END 🐣THE END 🐣THE END 🐣THE END 🐣");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("da Lorenzo🫡 & Nicolò🎸 ");
    }
}
