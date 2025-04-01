package org.generation.italy.concessionaria;

public class Camion extends Veicolo{
    private static final int RUOTE_CAMOIN = 10;

    public Camion (String modello,int velocitaMax,int carburante_max){
        super(modello, velocitaMax,RUOTE_CAMOIN,carburante_max );
    }
    @Override
    public void avvia() {
        System.out.println("Il Camion "+ getModello() + " è partito");

    }

    @Override
    public void accellera() {
        System.out.println("Il Camion "+ getModello() + " sta accellerando");

    }

    @Override
    public void frena() {
        System.out.println("Il Camion "+ getModello() + " sta frenando");

    }
}
