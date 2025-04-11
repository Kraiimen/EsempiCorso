package org.generation.italy.edenGame.room;

import org.generation.italy.edenGame.entity.Enemies.*;

import java.util.Map;
import java.util.Random;

public class Woods extends Room {

    Enemies enemy = new Monster("Carmine 🐍", 50, 50, 15, 50);
    Enemies enemy2 = new Monster("Filippo 🐦‍⬛", 50, 50, 15, 50);
    Enemies enemy3 = new Monster("Federico 🦅", 50, 50, 15, 50);
    Enemies enemy4 = new Monster("Marta 🦡", 50, 50, 15, 50);
    Enemies enemy5 = new Monster("Rossella 👩🏻‍💼", 50, 50, 15, 50);

    Enemies riccorcrux = new FinalBoss("👺😈👺😈👺😈RICCORCRUX👺😈👺😈👺😈", 100, 100, 50, 100);

    public Woods(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("🪵Non sai cosa troverai, puoi solo sperare di poterlo raccontare🪵");
        System.out.println("------------------------------------------------------------------");
        System.out.println(" ");
    }

    @Override
    public void getPossibleActions() {
        System.out.println("Attacca (A), Cerca (C), Info Abilità (I), Esci da qui (E)");
    }

    @Override
    public Enemies getEnemy() {
        Random dice = new Random();
        int chanceOfMonster = dice.nextInt(21);
        if (chanceOfMonster == 0 || chanceOfMonster == 18 || chanceOfMonster == 19 || chanceOfMonster == 20) {
            return enemy;
        } else if (chanceOfMonster == 1 || chanceOfMonster == 2 || chanceOfMonster == 3 || chanceOfMonster == 4) {
            return enemy2;
        } else if (chanceOfMonster == 5 || chanceOfMonster == 6 || chanceOfMonster == 7 || chanceOfMonster == 8) {
            return enemy3;
        } else if (chanceOfMonster == 9 || chanceOfMonster == 10 || chanceOfMonster == 11 || chanceOfMonster == 12) {
            return enemy4;
        } else if (chanceOfMonster == 13 || chanceOfMonster == 14 || chanceOfMonster == 16 || chanceOfMonster == 17) {
            return enemy5;
        } else {
            return riccorcrux;
        }
    }

}
