package org.generation.italy.interfaces;

public class Cat implements Animal{
    private double weight;

    //COSTRUTTORE
    public Cat(double weight){
        this.weight=weight;
    }

    @Override
    public void breathe() {
        System.out.println("Sto respirando");
    }

    @Override
    public void eat() {
        System.out.println("Sto mangiando un topo");

    }

    @Override
    public double getWeight() {
        return weight;
    }
}
