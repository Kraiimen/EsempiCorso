package org.generation.italy.edenGame.room;

import org.generation.italy.edenGame.entity.Enemies.Cat;
import org.generation.italy.edenGame.entity.Enemies.Enemies;
import org.generation.italy.edenGame.entity.Enemies.Guards;
import org.generation.italy.edenGame.entity.Enemies.Monster;

import java.util.Map;
import java.util.Random;

public class Woods extends Room {

    Enemies enemy = new Monster("Camilla", 50, 50, 15, 50);
    Enemies enemy2 = new Monster("Elvis", 50, 50, 15, 50);
    Enemies enemy3 = new Monster("Filippo", 50, 50, 15, 50);
    Enemies enemy4 = new Monster("Lorenzo", 50, 50, 15, 50);
    Enemies enemy5 = new Monster("Nicolò", 50, 50, 15, 50);


    public Woods(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("Non sai cosa troverai, puoi solo sperare di poterlo raccontare ");
        System.out.println("---------------------------------------------------------------");
        System.out.println(" ");
    }

    @Override
    public void getPossibleActions() {
        System.out.println("Attacca (A), Cerca (C), Esci da qui (E)");
    }

    @Override
    public Enemies getEnemy() {
        Random dice = new Random();
        int chanceOfMonster = dice.nextInt(5);
        if (chanceOfMonster == 0) {
            return enemy;
        } else if (chanceOfMonster == 1) {
            return enemy2;
        } else if (chanceOfMonster == 2) {
            return enemy3;
        } else if (chanceOfMonster == 3) {
            return enemy4;
        } else {
            return enemy5;
        }
    }

}
