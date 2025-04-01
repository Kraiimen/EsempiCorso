package org.generation.italy.bankproject.interfaces;

public class Cat implements  Animal {
    private double weight;

    public Cat(double weight){
        this.weight = weight;
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
