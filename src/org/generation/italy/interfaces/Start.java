package org.generation.italy.interfaces;

public class Start {
    public static void main(String[] args) {
        Cat c1 = new Cat(7);
        Cat c2 = new Cat(12);
        c1.euthanize();
        c2.euthanize();
    }
}
