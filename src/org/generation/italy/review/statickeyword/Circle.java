package org.generation.italy.review.statickeyword;

public class Circle {
    public static final int MAX_RADIUS = 100;  //se non fosse statica ogni cerchio avrebbe la sua costante (MAX_RADIUS).
    private double radius;
    private static double counter;
    public Circle() {
        counter++;
    }
    public double calculatePerimeter() {
        return 2.0 * Math.PI * radius;
    }
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    public static void reportCircleNumber() {
        System.out.printf("In questo splendido programma esistono attualmente %d cerchi %n", counter);
    }
    public static void main(String[] args) {
        Circle c = new Circle();
        c.radius = 4.0;
        double p = c.calculatePerimeter();
        double a = c.calculateArea();
        System.out.println(p);
        System.out.println(a);
        Circle c2 = new Circle();
        reportCircleNumber(); //reportCircleNumber non lavora su nessun dato di un cerchio, a differenza di c.
        Circle.reportCircleNumber(); //riga 27 e 28 significano la stessa cosa ma solo perchè mi ritrovo nella stessa classe Circle, fossi stato in un altra classe avrei dovuto mettere necessariamente Circle.
    }
}
