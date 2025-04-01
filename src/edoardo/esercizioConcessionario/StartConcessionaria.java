package edoardo.esercizioConcessionario;


import java.time.Year;

public class StartConcessionaria {
    public static void main(String[] args) {
        Car v1 = new Car("ABC123", "a", Year.of(1999));
        Car v2 = new Car("ABC123", "a", Year.of(1999));
        System.out.println(v1.equals(v2)); // true, stessa classe e stesso valore
        //System.out.println(v1.equals()); // false, classi diverse!
    }
}
