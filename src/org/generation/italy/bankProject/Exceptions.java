package org.generation.italy.bankProject;

public class Exceptions {
    public static void main(String[] args){
//        try {
//
//        } catch (Exception e){
//            System.out.println();
//        }
        f1();

        }




    private static void f1(){
        System.out.println("inizio f1");
        f2();
        System.out.println("fine f2");
    }

    private static void f2(){
        System.out.println("inizio f2");
        f3();
        System.out.println("fine f2");
    }

    private static void f3(){
        System.out.println("inizio f3");
        try {
            int x = 10 / 0;
            System.out.println("che bello ho diviso per zero");
        } catch (ArithmeticException e) {
            System.out.println("Errore" + e.getMessage());
        }
        System.out.println("fine f3");
    }




}
