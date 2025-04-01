package org.generation.italy.Interfaces;

public interface Animal {
    void breathe(); //metodo astratto
    void eat(); //metodo astratto
    double getWeight(); //metodo astratto
    // il seguente metodo implementa il design pattern template.
    default void euthanize() { //è un metodo concreto che ne invoca uno astratto: getWeight().
        System.out.println("Faccio fuori l'animaletto col gas, o con una puttanata di programmazione");
        double w = getWeight();
        if(w < 10) {
            System.out.println("Ti seppellisco nel giardino");
        } else {
            System.out.println("Facciamo un bel falò");
        }
    }

}
