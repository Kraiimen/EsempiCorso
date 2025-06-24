package org.generation.italy.sudProject.map;

public class MapOutput {
    public static String getRoomOutput(Room northRoom, Room southRoom, Room eastRoom, Room westRoom) {
        boolean n = northRoom != null;
        boolean s = southRoom != null;
        boolean e = eastRoom != null;
        boolean o = westRoom != null;
        return buildMap(n, s, e, o);
    }

    private static String buildMap(boolean n, boolean s, boolean e, boolean o) {
        StringBuilder sb = new StringBuilder();

        // Riga superiore (con apertura nord)
        if (n) {
            sb.append("|====================          ====================|\n");
        } else {
            sb.append("|==================================================|\n");
        }

        // Prime 10 righe normali
        for (int i = 0; i < 10; i++) {
            sb.append(getStandardLine());
        }

        // 4 righe centrali: inseriamo lo stickman su righe 2, 3 e 4 (i = 1, 2, 3)
        for (int i = 0; i < 4; i++) {
            if (i == 1) {
                sb.append(getDoorLineWithStickman(e, o, 1)); // testa
            } else if (i == 2) {
                sb.append(getDoorLineWithStickman(e, o, 2)); // busto e braccia
            } else if (i == 3) {
                sb.append(getDoorLineWithStickman(e, o, 3)); // gambe
            } else {
                sb.append(getDoorLine(e, o));
            }
        }

        // Ultime 9 righe normali
        for (int i = 0; i < 9; i++) {
            sb.append(getStandardLine());
        }

        // Riga inferiore (con apertura sud)
        if (s) {
            sb.append("|====================          ====================|\n");
        } else {
            sb.append("|==================================================|\n");
        }

        return sb.toString();
    }

    // Riga normale con entrambi i lati chiusi
    private static String getStandardLine() {
        return "|                                                  |\n";
    }

    // Riga con aperture laterali (porte) a est e/o ovest
    private static String getDoorLine(boolean east, boolean west) {
        StringBuilder line = new StringBuilder();

        if (west) {
            line.append(" "); // Porta aperta a ovest
        } else {
            line.append("|");
        }

        line.append("                                                  ");

        if (east) {
            line.append(" "); // Porta aperta a est
        } else {
            line.append("|");
        }

        line.append("\n");
        return line.toString();
    }

    // Riga con stickman centrato nella stanza
    private static String getDoorLineWithStickman(boolean east, boolean west, int stickmanLine) {
        StringBuilder line = new StringBuilder();

        if (west) {
            line.append(" "); // apertura ovest
        } else {
            line.append("|"); // muro ovest
        }

        // 22 spazi prima dello stickman
        line.append("                      ");

        // Corpo dello stickman
        switch (stickmanLine) {
            case 1:
                line.append("  O  "); // testa
                break;
            case 2:
                line.append(" /|\\ "); // busto e braccia
                break;
            case 3:
                line.append(" / \\ "); // gambe
                break;
            default:
                line.append("     ");
        }

        // 23 spazi dopo lo stickman
        line.append("                       ");

        if (east) {
            line.append(" "); // apertura est
        } else {
            line.append("|");
        }

        line.append("\n");
        return line.toString();
    }
}