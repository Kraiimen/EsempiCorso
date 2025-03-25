package org.generation.italy.bankProject.accounting;
import java.time.LocalDate;//Fully Qualified Name, scrivendo il nome completo 
//non ho bisogno di fare l'import.
//Le classi ne package default Java non sono importabili, perchè
//il pack default non ha nome.
public class Account {

    double balance;
    int id;
    LocalDate creationDate;//Serve ad indicare la data, la prima ricerca la fa 
    //nel java.lang, se non la trova la va a cercare nel package, se non la trova
    //prima di dare errore, andrà a leggere la lista degli import.

    public void printBalance(){
        System.out.printf("IL CONTO CON ID %d HA COME SALDO %f%n", id, balance);
        //Quando stamperò al posto di %d andrà id; al posto di %n andrà balance.
        
    }

    public double deposit(double amount){
        balance += amount;
        return balance;
    }

    public double withdraw(double amount){
        balance -= amount;
        return balance;
    }
}


