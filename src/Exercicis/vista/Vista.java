package Exercicis.vista;

import Exercicis.objectes.Candidatura;
import Exercicis.objectes.ComunitatAutonoma;
import Exercicis.objectes.DAO.CandidaturaDAODB;
import Exercicis.objectes.DAO.ComunitatAutonomaDAODB;
import Exercicis.objectes.DAO.PersonaDAODB;
import Exercicis.objectes.Persona;

import java.sql.SQLException;
import java.util.Scanner;

public class Vista {
    static Scanner scan = new Scanner(System.in);

    public static void menu() {

        int option, operationOption;

        initialMenu();

        option = scan.nextInt();
        switch (option) {
            case 1:
                registerMenu();
                operationOption = scan.nextInt();
                switch (operationOption) {
                    case 1:
                        insertCandidatura();
                        break;

                }
                break;
            case 2:
                registerMenu();
                operationOption = scan.nextInt();
                switch (operationOption) {
                    case 1:
                }
                break;
            case 3:
                registerMenu();
                operationOption = scan.nextInt();
                switch (operationOption) {
                    case 1:
                        insertCA();
                        break;
                }
                break;
            case 0:
                System.out.println("Fins aviat!");
                System.exit(0);
                break;
            default:
                System.out.println("Opció no vàlida");
                break;
        }
    }

    public static void initialMenu() {
        System.out.println("Benvingut al menú de taules! Sobre quina taula desitges treballar");
        System.out.println("1. Candidatures");
        System.out.println("2. Persones");
        System.out.println("3. Comunitats autònomes");
        System.out.println("0. Sortir");
    }

    public static void registerMenu() {
        System.out.println("Selecciona una operació per a la taula escollida, si us plau");
        System.out.println("1. Crear registre");
        System.out.println("2. Llegir registre");
        System.out.println("3. Modificar registre");
        System.out.println("4. Eliminar registre");
        System.out.println("0. Sortir");
    }

    public static void insertCA() {
        System.out.println("Quin és el nom de la comunitat autònoma que desitges introduïr?");
        scan.nextLine();
        String nom = scan.nextLine().trim();
        System.out.println("Quin és el seu codi_ine (MÀXIM 2 DÍGITS!)");
        String codi_ine = scan.nextLine().trim();
        while (codi_ine.length() != 2 || !codi_ine.matches("[0-9]+")) {
            System.out.println("Codi_ine invàlid! Torna a introduïr-lo, si us plau. Recorda: MÀXIM 2 dígits!");
            codi_ine = scan.nextLine().trim();
        }

        ComunitatAutonoma ca = new ComunitatAutonoma(nom, codi_ine);
        ComunitatAutonomaDAODB caDAO = new ComunitatAutonomaDAODB();
        try {
            if (caDAO.create(ca)) {
                System.out.println("Registre afegit!");
            } else {
                System.out.println("Oops... Algu ha sortit malament...");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void insertCandidatura() {
        System.out.println("Introdueix la eleccio_id de la candidatura: ");
        long eleccio_id = scan.nextLong();
        System.out.println("Introdueix el codi de la candidatura (HAN DE SER 6 DÍGITS!)");
        scan.nextLine();
        String codi_can = scan.nextLine();
        while (codi_can.length() != 6 || !codi_can.matches("[0-9]+")) {
            System.out.println("codi_candidatura invàlid! Torna a introduïr-lo, si us plau. Recorda: 6 dígits!");
            codi_can = scan.nextLine().trim();
        }
        System.out.println("Introdueix el nom curt de la candidatura");
        String nom_curt = scan.nextLine();
        System.out.println("Introdueix el nom llarg de la candidatura");
        String nom_llarg = scan.nextLine();
        System.out.println("Introdueix el codi d'acumulació provincial (HAN DE SER 6 DÍGITS!)");
        String codi_acu_prov = scan.nextLine();
        while (codi_acu_prov.length() != 6 || !codi_acu_prov.matches("[0-9]+")) {
            System.out.println("codi_acumulacio_provincia invàlid! Torna a introduïr-lo, si us plau. Recorda: 6 dígits!");
            codi_acu_prov = scan.nextLine().trim();
        }
        System.out.println("Introdueix el codi d'acumulació CA (HAN DE SER 6 DÍGITS!)");
        String codi_acu_ca = scan.nextLine();
        while (codi_acu_ca.length() != 6 || !codi_acu_ca.matches("[0-9]+")) {
            System.out.println("codi_acumulacio_provincia invàlid! Torna a introduïr-lo, si us plau. Recorda: 6 dígits!");
            codi_acu_ca = scan.nextLine().trim();
        }
        System.out.println("Introdueix el codi d'acumulació nacional (HAN DE SER 6 DÍGITS!)");
        String codi_acu_na = scan.nextLine();
        while (codi_acu_na.length() != 6 || !codi_acu_na.matches("[0-9]+")) {
            System.out.println("codi_acumulacio_provincia invàlid! Torna a introduïr-lo, si us plau. Recorda: 6 dígits!");
            codi_acu_na = scan.nextLine().trim();
        }

        Candidatura can = new Candidatura(eleccio_id, codi_can, nom_curt, nom_llarg, codi_acu_prov, codi_acu_ca, codi_acu_na);
        CandidaturaDAODB canDAO = new CandidaturaDAODB();
        try {
            if (canDAO.create(can)) {
                System.out.println("Registre afegit!");
            } else {
                System.out.println("Oops... Algu ha sortit malament...");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
