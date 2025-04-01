package org.generation.italy.interfaces;

public class Cats implements Animal{
private double weight;

public Cats(double weight){
    this.weight = weight;
}

    @Override
    public void breathe() {
        System.out.println("Sto respirando");
    }

    @Override
    public void eat() {
        System.out.println("Sto mangiando");

    }

    @Override
    public double getWeight() {
        return weight;
    }
}
