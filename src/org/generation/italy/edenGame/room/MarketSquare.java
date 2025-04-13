package org.generation.italy.edenGame.room;

import org.generation.italy.edenGame.entity.Enemies.Cat;
import org.generation.italy.edenGame.entity.Enemies.Enemies;
import org.generation.italy.edenGame.entity.Enemies.Guards;

import java.util.Map;

public class MarketSquare extends Room{

    Enemies enemy = new Guards("Tito 👮🏻‍♂️️ ", 50, 50, 10, 10);

    public MarketSquare(String name, Map<Compass, String> directions) {
        super(name, directions);
    }

    @Override
    public void printDescription() {
        System.out.println("🥡Un grande mercato, tanto chiasso e disordine, la gentre va e viene, si compra ma si lascia sempre qualcosa...🥡");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
    }
    public Enemies getEnemy() {
        return enemy;
    }

    @Override
    public void getPossibleActions() {
        System.out.println("Attacca (A), Cerca (C), Info Abilità (I), Esci di qui (E)");
    }


}
