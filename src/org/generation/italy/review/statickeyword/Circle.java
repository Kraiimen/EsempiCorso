package org.generation.italy.review.statickeyword;

public class Circle {
    private static final int MAX_RADIUS = 100;
    private double radius;
    private static double counter;
    public Circle(){
        counter++;
    }
    public double calculatePerimeter(){
        return 2.0 * Math.PI * radius;
    }
    public double calculateArea() {
            return Math.PI * radius * radius;
    }
    public static void reportCircleNumber(){//NON LAVORA SUGLI OGGETTI
        System.out.printf("In questo programma esistono attualmente %d cerchi%n",  counter);
    }
    public void main (String[] args){
        Circle c = new Circle();
        c.radius = 4;
        radius = 4.0;
        double p = c.calculatePerimeter();//Lavora sullo stato di un determinato cerchio, CHIAMO IL METODO SULL'OGGETTO
        double a = c.calculateArea();//Lavora // // // // //
        System.out.println(p);
        System.out.println(a);
        reportCircleNumber();
        Circle.reportCircleNumber();//Stesso passaggio di riga 27, è un metodo comune a tutti gli oggetti, usa un dato STATIC
    }
        }