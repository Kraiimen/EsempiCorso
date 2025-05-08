package org.generation.italy.sudProject;

import org.generation.italy.sudProject.entities.Player;
import org.generation.italy.sudProject.map.WorldMap;

import java.io.Console;

public class GameEngine {
    static{
        GameMenu menu = new GameMenu();
        Player player;
        WorldMap worldMap;
        menu.showMenuOptions();
        boolean loginState = false;
        do {
            Console console = System.console();
            switch (console.readLine().trim().toUpperCase()) {
                case "REGISTER":
                    worldMap = new WorldMap();
                    menu.registerNewPlayer();
                    System.out.println("EFFETTUA IL LOGIN:");
                    menu.login();
                    player = menu.login();
                    if(player!=null){
                        loginState = true;
                    }
                    break;
                case "LOGIN":
                    player = menu.login();
                    if(player!=null){
                        loginState = true;
                    }
                    break;
                default:
                    System.out.println("SELEZIONA (REGISTER) o (LOGIN)");
                    break;
            }
        }while(!loginState);
        //il giocatore ha effettuato il login


    }
}
