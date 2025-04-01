package org.generation.italy.concessionaria;

public abstract class Veicolo {
   private String modello;
   private double carburante;
   private int velocita;
   private int velocitaMax;
   private int nRuote;
   private int targa;
   private static int lastTarga;
   private final int CARBURANTE_MAX;

   public Veicolo(String modello,int velocitaMax,int nRuote, int carburante_max){
       this.modello = modello;
       this.velocitaMax = velocitaMax;
       this.nRuote = nRuote;
       lastTarga++;
       targa = lastTarga;
       this.CARBURANTE_MAX = carburante_max;

   }


   //FUNZIONI

   public abstract void avvia();

   public void rifornisci(int rifornimento) {
       carburante += rifornimento;
   }

   public abstract void accellera();

   public abstract void frena();


   public void ferma(){
       velocita = 0;
       System.out.println("Il veicolo si è fermato");
   }

    public String getModello() {
        return modello;
    }

    public int getVelocita() {
        return velocita;
    }

    public int getVelocitaMax() {
        return velocitaMax;
    }

    public int getnRuote() {
        return nRuote;
    }

    public String toString() {
        return "Veicolo: " + " " + modello;
    }

    public int getCARBURANTE_MAX() {
        return CARBURANTE_MAX;
    }
}
