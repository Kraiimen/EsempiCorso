package org.generation.italy.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Examples {
    public static void main(String[] args ) {
//    try {
//
//    } catch (Exception e) {
//        System.out.println();
//    }
        System.out.println("Inizio main");
        f1();
        System.out.println("Fine main");
    }

    private static void f1() {
        System.out.println("inizio f1");
        f2();
        System.out.println("fine f1");
    }

    private static void f2() {
        System.out.println("inizio f2");
        f3();
        System.out.println("Fine f2");
    }

    private static void f3() {
        System.out.println("inizio f3");
        try {
            int x = 10 / 0; // Fallirà generando una arithmetic exceptions e si fermerà qui il try, non vedrò il messaggio successivo
            System.out.println("Che bello ho diviso per zero");
        } catch (ArithmeticException e) {
            System.out.println("Errore: " + e.getMessage());
        }
        f4();
        System.out.println("Fine f3");
    }

    private static void f4() {
        System.out.println("inizio f4");
        try {
            FileInputStream fis = new FileInputStream("file.txt"); // Voglio andare a leggere un file, avrò errore se non faccio un try catch, perché è un'eccezione checked
            System.out.println("file aperto");
        } catch (FileNotFoundException e) {
            System.out.println("errore: " + e.getMessage());
        }
        System.out.println("Fine f4");
    }

}
