package org.generation.italy.edenGame.room;

import org.generation.italy.edenGame.entity.Enemies.Cat;
import org.generation.italy.edenGame.entity.Enemies.Enemies;
import org.generation.italy.edenGame.entity.Enemies.Guards;

import java.util.Map;
import java.util.Random;

public class TempleSquare extends Room{

    Enemies enemy = new Cat("giacomino", 10, 10, 1, 1);
    Enemies enemy2 = new Cat("felicia", 10, 10, 1, 1);
    Enemies enemy3 = new Cat("palladepelo", 10, 10, 1, 1);
    Enemies enemy4 = new Cat("bucaneve", 10, 10, 1, 1);

    public TempleSquare(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("Una piazza sacra, al centro della cittadella, pieno di persone e di storie ");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" ");
    }


    @Override
    public void getPossibleActions() {
        System.out.println("Attacca (A), Cerca (C), Info Abilità (I), Esci da qua (E)");
    }

    public Enemies getEnemy() {
        Random dice = new Random();
        int chanceOfMonster = dice.nextInt(4);
        if (chanceOfMonster == 0) {
            return enemy;
        } else if (chanceOfMonster == 1) {
            return enemy2;
        } else if (chanceOfMonster == 2) {
            return enemy3;
        } else {
            return enemy4;
        }

    }
}
