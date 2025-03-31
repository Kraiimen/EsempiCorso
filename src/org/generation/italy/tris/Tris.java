package org.generation.italy.tris;

public class Tris {
    public static void main(String[] args){
        GameManagement gm = new GameManagement();
        gm.showGameBoard();
        gm.waitForUserChoice();
        gm.showGameBoard();
        gm.changeTurn();
        gm.waitForUserChoice();
        gm.showGameBoard();
    }
}
