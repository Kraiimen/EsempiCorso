package org.generation.italy.capstonProject.mudGame.entity;

public class Wallet {
    private int balance;

    public Wallet(int balance) {
        this.balance = balance;
    }

    public int addCoins(int coins){
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

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
