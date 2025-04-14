package org.generation.italy.edenGame;
import org.generation.italy.edenGame.entity.Enemies.Enemies;
import org.generation.italy.edenGame.entity.player.*;
import org.generation.italy.edenGame.room.*;
import java.io.Console;
import java.util.Random;


public class Start {
    public static void main(String[] args) {
        Console console = System.console();
        Game game = new Game();
        game.printIntro();
        game.createCharacter();
        game.exec();
    }
}

