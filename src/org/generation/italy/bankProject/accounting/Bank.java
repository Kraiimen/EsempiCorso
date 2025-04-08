package org.generation.italy.bankProject.accounting;


public class Bank {
    private static final int MINIMUM_FOR_DEPOSIT =1000;
    private static final int MAX_BEFORE_WITHDRAW =2000;
    private static final int ACCOUNT_DEPOSIT_BONUS =200;
    private static final int ACCOUNT_DEPOSIT_MALUS =500;


//    public void gestisciConto(Account account){
//        if(account.getBalance() < MINIMUM_FOR_DEPOSIT){
//            account.deposit(ACCOUNT_DEPOSIT_BONUS);
//        }else if(account.getBalance()> MAX_BEFORE_WITHDRAW){
//            account.withdraw(ACCOUNT_DEPOSIT_MALUS);
//        }
//        System.out.println("Il tuo saldo attuale è: " +  account.getBalance());
//    }
//
//    public void f1() {
//        Account x = new GoldAccount(100);
//        try {
//            x.temp();
//        } catch (ExcessiveDepositException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
