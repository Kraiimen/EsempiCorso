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

        // 4 righe centrali (righe 11–14) con eventuali porte est/ovest
        for (int i = 0; i < 4; i++) {
            sb.append(getDoorLine(e, o));
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
}