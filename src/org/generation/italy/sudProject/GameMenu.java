package org.generation.italy.sudProject;

import org.generation.italy.sudProject.entities.Player;
import org.generation.italy.sudProject.entities.playerClasses.*;

import java.io.Console;
import java.util.Arrays;

import static org.generation.italy.sudProject.PlayerData.*;

public class GameMenu {
    public Console console = System.console();
    String className;

    // /--METHODS--/
    public void registerNewPlayer(){
        System.out.println("CREAZIONE GIOCATORE:");
        System.out.println("INSERISCI FIRSTNAME:");
        String firstname = console.readLine();
        System.out.println("INSERISCI LASTNAME:");
        String lastname = console.readLine();
        System.out.println("INSERISCI EMAIL:");
        String email = console.readLine();
        System.out.println("INSERISCI PASSWORD:");
        String password = console.readLine();
        System.out.println("INSERISCI PLAYER NAME:");
        String playerName = console.readLine();
        boolean state = false;
        do {
            System.out.println("SCEGLI LA CLASSE DEL TUO PERSONAGGIO:");
            System.out.println(Arrays.toString(Classes.values()));
            className = console.readLine().toUpperCase();
            for(Classes c : Classes.values()){
                if(className.equals(c.getString())){
                    state = true;
                    break;
                }
            }
        }while(!state);
        Player player = switch (Classes.valueOf(className)) {
            case PALADIN -> new Paladin(firstname, lastname, email, password, playerName);
            case PRIEST -> new Priest(firstname, lastname, email, password, playerName);
            case ROGUE -> new Rogue(firstname, lastname, email, password, playerName);
            case WIZARD -> new Wizard(firstname, lastname, email, password, playerName);
        };
        addPlayerData(player);
    }
    public Player login(){
        System.out.println("INSERISCI EMAIL:");
        String email = console.readLine();
        System.out.println("INSERISCI PASSWORD");
        String password = console.readLine();
        Player player = checkCredentials(email, password);
        if(player == null) {
            System.out.println("Credenziali errate o inesistenti");
        }
        return player;
    }
    public void showMenuOptions(){
        System.out.println("REGISTRATI O EFFETTUA IL LOGIN:");
        System.out.println("(REGISTER)\n"+"(LOGIN)");
    }
}
