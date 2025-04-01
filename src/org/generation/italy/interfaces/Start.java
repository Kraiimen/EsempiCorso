package org.generation.italy.interfaces;

public class Start {
    public static void main(String[] args){
        Cats c1 = new Cats(7);
        Cats c2 = new Cats(12);
        c1.euthanize();
        c2.euthanize();
    }
}
