package org.generation.italy.concessionaria;

public class Start {
    public static void main (String[] args){
        Auto a = new Auto("Ferrari", 280, 70);
        Moto m = new Moto("Bmw", 280, 15);

        m.rifornisci(15);

        Camion c = new Camion("IVECO", 180, 50);
        c.accellera();
        Concessionaria conc = new Concessionaria();

        conc.aggiungiVeicolo(a);
        conc.aggiungiVeicolo(m);
        conc.stampaVeicoli();


    }
}
