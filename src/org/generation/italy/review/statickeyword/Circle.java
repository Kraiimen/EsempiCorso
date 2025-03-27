package org.generation.italy.review.statickeyword;

public class Circle {
    public static final int MAX_RADIUS = 100; // se non fosse statica ogni cerchio avrebbe la sua costante;
    private double radius;
    private static double counter;
    public Circle(){
        counter++;
    }
    public double calculatePerimeter(){
        radius = 27; //non essendo statica lo chiamo su un oggetto
        return 2.0 * Math.PI * radius;
    }
    public double calculateArea(){
        return Math.PI * radius * radius;
    }
    public static void reportCircleNumber(){// non lavora su nessun cerchio
        // this.radius = 27; // non ha senso perché non lo chiamo su nessun oggetto
        System.out.printf("In questo splendido programma esistono attualmente %d cerchi%n", counter);
    }
    public static void main(String[] args){
        Circle c = new Circle();
        c.radius = 4.0;
        double p = c.calculatePerimeter(); //lavorano sullo stato di un determinato cerchio
        double a = c.calculateArea();
        System.out.println(p);
        System.out.println(a);
        Circle c2 = new Circle();
        reportCircleNumber();
        Circle.reportCircleNumber(); // è la stessa cosa della riga 27

    }

}

