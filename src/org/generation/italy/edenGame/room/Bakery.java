package org.generation.italy.edenGame.room;

import org.generation.italy.edenGame.entity.Enemies.Cat;
import org.generation.italy.edenGame.entity.Enemies.Enemies;

import java.util.Map;

public class Bakery extends Room{

    Enemies enemy = new Cat("pioppino", 10, 10, 1, 3);

    public Bakery(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("Una pannetteria dove i più affamati possono ristorare, il profumo di pane ti aiuterà a ritrovare le tue forze ");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
    }
    public Enemies getEnemy() {
        return enemy;
    }
    @Override
    public void getPossibleActions() {
        System.out.println("Attacca (A), Ruba (St), Compra (B), Info Abilità (I), Esci di qui (E)");
    }
}
