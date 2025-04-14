package sud.engine.GUI;

import sud.environment.rooms.Room;

import java.util.List;

public class GUI {
    private static final String newLine = "\n";
    private static final String optionSymbol = ") ";
    private static final String inlineSymbol = "\t";


    public static void invalidChoice() {
        System.out.println("scelta non valida");
    }

    public static void noResidentFound() {
        System.out.println("non c'è nessuno");
    }

    public static void noItemsFound() {
        System.out.println("non ci sono oggetti da raccogliere");
    }

    public static void printRoom(Room currentPosition) {
        System.out.println(currentPosition);
    }
    public static void printInlineMenu(List<String> menu) {
        System.out.println(buildMenu(menu, true));
    }

    public static void printMenu(List<String> menu) {
        System.out.println(buildMenu(menu, false));
    }
    public static StringBuilder buildMenu(List<String> menu, boolean isInline) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String option : menu){
            //TODO quando aggiungo il valore numerico ai menù, posso togliere i e metterci il valore numerico dell'enum
            addOption(sb, ++i, option);
            if(isInline){
                makeOptionInline(sb);
            }else{
                makeOptionVertical(sb);
            }
        }
        return sb;
    }
    public static StringBuilder addOption(StringBuilder sb, int i, String option) {
        return sb.append(i).append(optionSymbol).append(option);
    }
    public static StringBuilder makeOptionInline(StringBuilder sb) {
        return sb.append(inlineSymbol);
    }
    public static StringBuilder makeOptionVertical(StringBuilder sb) {
        return sb.append(newLine);
    }
//    public static StringBuilder addOption(int i, String option) {
//        StringBuilder res = new StringBuilder();
//        res.append(i).append(optionSymbol).append(option);
//        return res;
//    }



    public static void printMainMenu(List<String> menu) {
        int i = 0;
        for (String option : menu){
            //TODO quando aggiungo il valore numerico ai menù, posso togliere i e metterci il valore numerico dell'enum
            System.out.print(++i + ") " + option);
        }
        StringBuilder s = new StringBuilder("P");
    }
}
