package Proves;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class LecturaDades {
    public static void main(String[] args) {

        // printComunitat();
        // printProvincia();
         //printMunicipi();
        printPersones();
        //readInsertMunicipi();
        //readInsertComunitat();
        readInsertProvincies();
    }

    public static void printComunitat() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "07021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                if (strLinia.substring(11, 13).equals("99")) { // dels totals
                    // Extraiem el codi de la CA
                    System.out.println("Codi comunitat:  " + strLinia.substring(9, 11));
                    // Extraiem el nom de la CA
                    System.out.println("Nom comunitat:  " + strLinia.substring(14, 64));

                    System.out.println();
                }
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

    public static void printProvincia() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "07021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                // Excloent els totals
                if (!(strLinia.substring(9, 11).equals("99") || strLinia.substring(11, 13).equals("99"))) {
                    // Extraiem el codi de la CA
                    System.out.println("Codi comunitat de la província:  " + strLinia.substring(9, 11));
                    // Extraiem el nom de la província
                    System.out.println("Nom província:  " + strLinia.substring(14, 64));
                    // Extraiem el codi INE de la província
                    System.out.println("INE Província:  " + strLinia.substring(11, 13));
                    // Extraiem el número d'escons
                    System.out.println("Escons província:  " + strLinia.substring(149, 155));

                    System.out.println();
                }
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

    public static void printMunicipi() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "05021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            String nom, codi_ine, provincia_id;
            int districte;
            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                if (strLinia.substring(16, 18).equals("99")) {   // Si Nº districte és 99
                    // Extrayem nom del MUNICIPI
                    System.out.println("Nom del municipi: " + strLinia.substring(18, 118));
                    nom = strLinia.substring(18, 118);
                } else {    // Si Nº districte NO és 99
                    // Extrayem nom del DISTRICTE
                    System.out.println("Nom del districte: " + strLinia.substring(18, 118));
                    nom = strLinia.substring(18, 118);
                }
                // Extraiem codi INE del municipi
                System.out.println("INE municipi: " + strLinia.substring(13, 16));
                codi_ine = strLinia.substring(13, 16);
                // Extraiem el codi INE de la província
                System.out.println("INE província del municipi: " + strLinia.substring(11, 13));
                provincia_id = strLinia.substring(11, 13);
                // Extraiem el número de districte
                System.out.println("Número districte: " + strLinia.substring(16, 18));  // Si és 99 és municipi
                districte = Integer.parseInt(strLinia.substring(16, 18));
                System.out.println();
                Nom_INE_Municipi.insertData(nom,codi_ine,provincia_id,districte);
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

    public static void printPersones() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "04021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                //Nom del candidat
                System.out.println("Nom candidat: " + strLinia.substring(25, 50));
                String nom = strLinia.substring(25, 50);
                //Primer cognom del candidat
                System.out.println("Cognom1: " + strLinia.substring(50, 75));
                String cognom1 = strLinia.substring(50, 75);
                //Segon cognom del candidat
                System.out.println("Cognom2: " + strLinia.substring(75, 100));
                String cognom2 = strLinia.substring(75, 100);
                    /*
                    //Les següents dades no surten al fitxer pero si estàn solicitades a la BD, en l'insert haurem de posarles en null.
                    //Sexo del candidato
                    System.out.println("Sexo: " + strLinia.substring(100, 101));
                    //data de naixament
                    System.out.println("Data de naixement: " + strLinia.substring(101, 103) + "/" + strLinia.substring(104, 105) + "/" + strLinia.substring(106, 109));
                    //DNI del candidat
                    //System.out.println("DNI: " + strLinia.substring(101, 101));
                     */
                System.out.println();
                Inserts_provisionales.insertPersones(nom, cognom1, cognom2);
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

    public static void readInsertMunicipi() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "05021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            String nom, codi_ine, ine_provincia;
            int districte;
            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                if (strLinia.substring(16, 18).equals("99")) {   // Si Nº districte és 99
                    // Extrayem nom del MUNICIPI
                    nom = strLinia.substring(18, 118);
                } else {    // Si Nº districte NO és 99
                    // Extrayem nom del DISTRICTE
                    nom = strLinia.substring(18, 118);
                }
                // Extraiem codi INE del municipi
                codi_ine = strLinia.substring(13, 16);
                // Extraiem el codi INE de la província
                ine_provincia = strLinia.substring(11, 13);
                // Extraiem el número de districte
                districte = Integer.parseInt(strLinia.substring(16, 18)); // Si és 99 és municipi

                //Insertem dades
                Nom_INE_Municipi.insertData(nom,codi_ine, ine_provincia,districte);
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

    public static void readInsertComunitat() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "07021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                if (strLinia.substring(11, 13).equals("99")) { // dels totals
                    // Extraiem el codi de la CA
                    String codi_ine = strLinia.substring(9, 11);
                    // Extraiem el nom de la CA
                    String nom = strLinia.substring(14, 64);
                    Inserts_provisionales.insertComunitat(nom, codi_ine);
                }
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

    public static void readInsertProvincies() {
        BufferedReader bfLector = null;
        try {
            // Ruta del nostre arxiu (
            Path pathFitxer1 = Paths.get("C:", "M02", "02201606_MESA", "07021606.DAT");
            bfLector = Files.newBufferedReader(pathFitxer1, StandardCharsets.ISO_8859_1);
            String strLinia;

            String codi_ine_ca, nom_provincia, codi_ine_prov;
            int num_escons;
            // Recorregut de cada línia de l'arxiu
            while ((strLinia = bfLector.readLine()) != null) {
                // Excloent els totals
                if (!(strLinia.substring(9, 11).equals("99") || strLinia.substring(11, 13).equals("99"))) {
                    // Extraiem el codi de la CA
                    codi_ine_ca = strLinia.substring(9, 11);
                    // Extraiem el nom de la província
                    nom_provincia = strLinia.substring(14, 64);
                    // Extraiem el codi INE de la província
                    codi_ine_prov = strLinia.substring(11, 13);
                    // Extraiem el número d'escons
                    num_escons = Integer.parseInt(strLinia.substring(149, 155));

                    Inserts_provisionales.insertProvincia(codi_ine_ca, nom_provincia, codi_ine_prov, num_escons);
                }
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
