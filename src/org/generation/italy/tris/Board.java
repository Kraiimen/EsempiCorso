package org.generation.italy.tris;

import java.util.Arrays;
import java.io.PrintStream;

public class Board {
    private static final int SIZE = 3;
    protected static final char EMPTY = '-';
    protected char[][] gameBoard; //l'ho resa protetta per sfruttare l'ereditarietà, non c'entra col polimorfismo;

    public Board(){
        gameBoard = new char[SIZE][SIZE];
        setLayoutForGameBoard();
    }

    public void setLayoutForGameBoard(){
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[i].length; j++){
                gameBoard[i][j] = EMPTY;
            }
        }
    }

//    public void showGameBoard(){
//        for(char[] arr : gameBoard){ // ad ogni iterazione arr[] sarà uguale all'array di gameBoard
//            for(char c : arr){       // ad ogni iterazione c sarà uguale all'elemento presente all'interno dell'arrey arr[];
//                System.out.print(c + " ");
//            }
//
//        } System.out.println();
//    }
    public void showGameBoard(){
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[i].length; j++){
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
}
