package org.generation.italy.interfaces;

public interface Animal {
    void breathe();
    void eat();

    double getWeight();

    //il seguente metodo implementa il design pattern template
    //è un metodo concreto che ne invoca uno astratto: getWeight()
    default void euthanize() {
        System.out.println("Faccio fuori l'animaletto col gas, o con una puttanata di programmazione");
        //potevo farla senza variabile
        double w = getWeight();
        if(w < 10) {
            System.out.println("Ti seppellisco nel giardino");
        } else {
            System.out.println("Facciamo un bel falò");
        }
    }

}
