package org.generation.italy.bankProject.interfaces;

public interface Animal {
    void breathe();
    void eat();
    double getWeight();

    default void euthanize(){
        System.out.println("Faccio fuori l'animaletto col gas, o con una puttanata di programmazione");
        double w = getWeight();
        if(w < 10){
            System.out.println("Ti seppellisco nel giardino");
        } else {
            System.out.println("Facciamo un bel falò");
        }
    }
}

