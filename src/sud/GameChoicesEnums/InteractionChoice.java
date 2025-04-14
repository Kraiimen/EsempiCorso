package sud.GameChoicesEnums;

public enum InteractionChoice {
    SPEAK("parla"),
    ATTACK("attacca");

    private String value;

    private InteractionChoice(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
