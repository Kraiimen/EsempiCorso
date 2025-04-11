package org.generation.italy.edenGame.room;

import org.generation.italy.edenGame.entity.Enemies.Cat;
import org.generation.italy.edenGame.entity.Enemies.Enemies;
import org.generation.italy.edenGame.entity.Enemies.Guards;

import java.util.Map;
import java.util.Random;

public class Gardens extends Room {

    Enemies enemy = new Cat("micio", 10, 10, 1, 1);
    Enemies enemy2 = new Cat("micia", 10, 10, 1, 1);
    Enemies enemy3 = new Cat("micie", 10, 10, 1, 1);
    Enemies enemy4 = new Cat("micii", 10, 10, 1, 1);
    Enemies enemy5 = new Cat("miciu", 10, 10, 1, 1);

    Enemies enemy6 = new Guards("Caio", 50, 50, 20, 10);
    Enemies enemy7 = new Guards("Tizio", 50, 50, 20, 10);
    Enemies enemy8 = new Guards("Sempro", 50, 50, 20, 10);

    public Gardens(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("I giardini, fioriti e colorati, il vanto della casata reale ");
        System.out.println("------------------------------------------------------------");
        System.out.println(" ");
    }

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
        } else if (chanceOfMonster == 4) {
            return enemy5;
        } else if (chanceOfMonster == 5) {
            return enemy6;
        } else if (chanceOfMonster == 6) {
            return enemy7;
        } else {
            return enemy8;
        }
    }

        @Override
        public void getPossibleActions () {
            System.out.println("Attacca (A), Cerca (C), Riposa (R), Esci da qui (E)");
        }

}
