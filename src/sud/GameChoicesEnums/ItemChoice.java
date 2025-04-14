package sud.GameChoicesEnums;

public enum ItemChoice {
    USE("usa"),
    EQUIP("equipaggia"),
    UNEQUIP("disequipaggia"),
    DISCARD("elimina");

    private String value;

    private ItemChoice(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
