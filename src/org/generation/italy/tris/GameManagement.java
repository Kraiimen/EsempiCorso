package org.generation.italy.tris;
import java.io.Console;

public class GameManagement extends Board{
    private int rowChosen;
    private int columnChosen;
    private boolean isPlayerOneTurn = true;

    public void waitForUserChoice(){
        Console console = System.console();
        String s = console.readLine("Inserisci il numero della riga: ");
        rowChosen = Integer.parseInt(s);
        // posso utilizzare s perché tanto il valore inserito da tastiera che era in s ora è in rowchosen, quindi possiamo riutilizzarlo
        s = console.readLine("Inserisci il numero della colonna: ");
        columnChosen = Integer.parseInt(s);
        placeSymbolAt(rowChosen, columnChosen);
    }

    private boolean isChoiceValid(int row, int col){
        return gameBoard[row-1][col-1] == EMPTY;
//        if(gameBoard[row - 1][col - 1] == EMPTY){
//            return true;
//        }
//        return false;
    }

    private void placeSymbolAt(int x, int y){
        if(isChoiceValid(x, y)){
            gameBoard[x - 1][y - 1] = getPlayerSymbol();
        }
    }

    private char getPlayerSymbol(){
        return isPlayerOneTurn ? 'X':'O';
    }

    public void changeTurn(){
        if(isPlayerOneTurn){
            isPlayerOneTurn = false;
        }
        else{
            isPlayerOneTurn = true;
        }
    }
}

