package eserciziRipassoArgomenti;

import java.util.ArrayList;
import java.util.List;

public class StreamAndLambda {

    static List<Integer> numeri = new ArrayList<>();

    static {
        numeri.add(1);
        numeri.add(2);
        numeri.add(3);
        numeri.add(4);
        numeri.add(5);
        numeri.add(6);
    }

    public static void main(String[] args) {
        System.out.println(sumEvenNum());
    }
    public static int sumEvenNum() {
        return numeri.stream()
                .filter(n -> (n % 2 == 0))
                .mapToInt(Integer::intValue)
                .sum();
    }
}
