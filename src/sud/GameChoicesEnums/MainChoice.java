package sud.GameChoicesEnums;

import java.util.ArrayList;
import java.util.List;

public enum MainChoice {
    //TODO da aggiungere un secondo valore numero(in forma di stringa) per fare la scelta usando un numero (su tutti i menu)
    QUIT("quit"),   //esci dal gioco
    BACK("back"),   //torna al menù precedente

    INTERACT("interagisci"),
    ATTACK("attack"),
    PICK("raccogli"),
    INVENTORY("inventario"),

    YES("si"),
    NO("no");

    private final String value;
    private static List<String> mainMenu = new ArrayList<>();
    private static List<String> confirmationMenu = new ArrayList<>();

    static {
        mainMenu.add(MainChoice.INTERACT.value);
        mainMenu.add(MainChoice.ATTACK.value);
        mainMenu.add(MainChoice.PICK.value);
        mainMenu.add(MainChoice.INVENTORY.value);

        confirmationMenu.add(MainChoice.YES.value);
        confirmationMenu.add(MainChoice.NO.value);
    }

    private MainChoice(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static List<String> getMainMenu() {
        return mainMenu;
    }
    public static List<String> getConfirmationMenu() {
        return confirmationMenu;
    }
}
