package org.generation.italy.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Examples {

    public static void main(String[] args)  {
//        try {
//
//
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        System.out.println("inizio main");
        try {
            f1();
        } catch (FileNotFoundException e) {
            System.out.println("Errore: " + e.getMessage());
        }
        System.out.println("fine main");
    }

    private static void f1() throws FileNotFoundException {
        System.out.println("inizio f1");

        f2();

        System.out.println("fine f1");
    }

    private static void f2() throws FileNotFoundException {
        System.out.println("inizio f2");
        f3();
        System.out.println("fine f2");
    }

    private static void f3() throws FileNotFoundException {
        System.out.println("inizio f3");
//        try {
//            String s = null;
        FileInputStream fis = new FileInputStream("file.txt");

//        } catch (NullPointerException e) {
//            System.out.println("Errore: " + e.getMessage());
//        }
        System.out.println("fine f3");
    }
}
