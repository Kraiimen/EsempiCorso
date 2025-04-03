package org.generation.italy.exceptions;


import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {

        FileReader first = null;
        try {
            first = new FileReader("file.txt");
            int i = first.read();
        } catch (IOException e) {
            System.out.println("Errore: " + e.getMessage());
        } finally {
            try {
                if (first != null) {
                    first.close();
                }
            } catch (IOException e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }

        try (FileReader res = new FileReader("file.txt")) {

            int i = res.read();
        } catch (IOException e) {
            System.out.println("Errore: " + e.getMessage());
        }

    }
}
