package Proves;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class LecturaVotsMunicipis {
    public static void main(String[] args) {
        printVotsMunicipis();

    }

    public static void printVotsMunicipis() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "06021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {

                int municipi_id = Integer.parseInt(strLinia.substring(11, 14));
                System.out.println("Codi I.N.E del municipi : " + municipi_id);
                int candidatura_id = Integer.parseInt(strLinia.substring(16, 22));
                System.out.println("Codi de la candidatura o del Senador: " + candidatura_id);
                int vots = Integer.parseInt(strLinia.substring(22, 30));
                System.out.println("Vots obtinguts per la candidatura: " + vots);
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