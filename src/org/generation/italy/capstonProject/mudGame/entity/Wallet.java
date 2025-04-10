package org.generation.italy.capstonProject.mudGame.entity;

public class Wallet {
    private int balance;

    public int addCoin(int coins){
        return balance += coins;
    }

    public int takeCoins(int coins) throws ArithmeticException{
        if(coins > balance){
            throw new ArithmeticException();
        }
        return balance -= coins;
    }

    public int getBalance() {
        return balance;
    }
}
