package org.generation.italy.concessionaria;

public class Moto extends Veicolo{
    private static final int RUOTE_MOTO = 2;

    public Moto(String modello,int velocitaMax,int carburante_max){
        super(modello, velocitaMax,RUOTE_MOTO,carburante_max );
    }


    @Override
    public void avvia() {
        System.out.println("La moto"+ getModello() + "e partita");
    }
    public void rifornisci(int rifornimento) {
        if(rifornimento > getCARBURANTE_MAX()){
            System.out.println("Il serbatoio è pieno");

        }
    }

    @Override
    public void accellera() {
        System.out.println("La moto " + getModello() + " sta accellerando");
    }

    @Override
    public void frena() {
        System.out.println("La moto " + getModello() + " sta frenando");

    }
}
