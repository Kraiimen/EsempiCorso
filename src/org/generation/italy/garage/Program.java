package org.generation.italy.garage;

public class Program {
    public static void main(String[] args) {
        Ferrari f = new Ferrari("674FF", 1993);
        Porsche p = new Porsche("GHF666", 2021);
        Guzzi g = new Guzzi("Guzz110", 2025);
        Harley h = new Harley("HeyleyQ666", 2011);
        Ferrari bi4 = null;
        Harley su4ka = null;

        Garage<Car, Motorcycle> garagik = new Garage<>();
        garagik.parkCar(f);
        garagik.parkCar(p);
        garagik.parkMoto(g);
        garagik.parkMoto(h);
        garagik.parkCar(bi4);
        garagik.parkMoto(su4ka);
    }
}
