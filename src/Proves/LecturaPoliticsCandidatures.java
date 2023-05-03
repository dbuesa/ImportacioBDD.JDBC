package Proves;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LecturaPoliticsCandidatures {
    public static void main(String[] args) {
        printCandidatures();

    }

    public static void printCandidatures() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "03021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                System.out.println("Codi de la candidatura: " + Integer.parseInt(strLinia.substring(8,14)));
                System.out.println("Nom curt: " + strLinia.substring(14,64));
                System.out.println("Nom llarg: " + strLinia.substring(64,214));
                System.out.println("Codi de candidatura capçalera d'acumulació a nivell provincial: " + Integer.parseInt(strLinia.substring(214,220)));
                System.out.println("Codi de candidatura capçalera d'acumulació a nivell autonòmic: " + Integer.parseInt(strLinia.substring(220,226)));
                System.out.println("Codi de candidatura capçalera d'acumulació a nivell nacional: " + Integer.parseInt(strLinia.substring(226,232)));
                System.out.println();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bfLector != null)
                    bfLector.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}

