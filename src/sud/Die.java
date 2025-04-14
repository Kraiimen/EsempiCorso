package sud;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public enum Die {
    D4(4),
    D6(6),
    D8(8),
    D10(10),
    D12(12),
    D20(20);

    private static Random random = new Random();

    private final int value;
    private static Map<Integer, Die> map = new HashMap<>();

    private Die(int value) {
        this.value = value;
    }

    static {
        for (Die die : Die.values()) {
            map.put(die.value, die);
        }
    }

    public static Die valueOf(int value) {
        return map.get(value);
    }

    public int getValue() {
        return value;
    }

    public int roll() {
        return random.nextInt(getValue()) + 1;
    }
}
