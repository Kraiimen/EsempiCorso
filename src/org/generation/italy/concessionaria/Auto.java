package org.generation.italy.concessionaria;

public class Auto extends Veicolo{
    private static final int  NUMERO_RUOTE = 4;

    public Auto(String modello,int velocitaMax,int carburante_max){
        super(modello, velocitaMax,NUMERO_RUOTE,carburante_max );
    }

    @Override
    public void avvia() {
        System.out.println(" l'auto " + getModello() + " è partita");
    }

    @Override
    public void accellera() {
        System.out.println(" l'auto " + getModello() + " sta accellerando");
    }

    @Override
    public void frena() {
        System.out.println(" l'auto " + getModello() + " sta frenando");
    }
}
