package Exercicis.opcionsMenu;

import Exercicis.objectes.Candidatura;
import Exercicis.objectes.ComunitatAutonoma;
import Exercicis.objectes.DAO.CandidaturaDAODB;
import Exercicis.objectes.DAO.ComunitatAutonomaDAODB;
import Exercicis.objectes.DAO.PersonaDAODB;
import Exercicis.objectes.Persona;

import java.sql.SQLException;
import java.util.Scanner;

public class OpcionsMenu {
    static Scanner scan = new Scanner(System.in);

    public static void insertCA() {
        System.out.println("Quin és el nom de la comunitat autònoma que desitges introduïr?");
        scan.nextLine();
        String nom = scan.nextLine().trim();
        System.out.println("Quin és el seu codi_ine (MÀXIM 2 DÍGITS!)");
        String codi_ine = scan.nextLine().trim();
        while (codi_ine.length() != 2 || !codi_ine.matches("[0-9]+")) {
            System.out.println("Codi_ine INVÀLID! Torna a introduïr-lo, si us plau. Recorda: MÀXIM 2 dígits!");
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
            System.out.println("codi_candidatura INVÀLID! Torna a introduïr-lo, si us plau. Recorda: 6 dígits!");
            codi_can = scan.nextLine().trim();
        }
        System.out.println("Introdueix el nom curt de la candidatura");
        String nom_curt = scan.nextLine();
        System.out.println("Introdueix el nom llarg de la candidatura");
        String nom_llarg = scan.nextLine();
        System.out.println("Introdueix el codi d'acumulació provincial (HAN DE SER 6 DÍGITS!)");
        String codi_acu_prov = scan.nextLine();
        while (codi_acu_prov.length() != 6 || !codi_acu_prov.matches("[0-9]+")) {
            System.out.println("codi_acumulacio_provincia INVÀLID! Torna a introduïr-lo, si us plau. Recorda: 6 dígits!");
            codi_acu_prov = scan.nextLine().trim();
        }
        System.out.println("Introdueix el codi d'acumulació CA (HAN DE SER 6 DÍGITS!)");
        String codi_acu_ca = scan.nextLine();
        while (codi_acu_ca.length() != 6 || !codi_acu_ca.matches("[0-9]+")) {
            System.out.println("codi_acumulacio_provincia INVÀLID! Torna a introduïr-lo, si us plau. Recorda: 6 dígits!");
            codi_acu_ca = scan.nextLine().trim();
        }
        System.out.println("Introdueix el codi d'acumulació nacional (HAN DE SER 6 DÍGITS!)");
        String codi_acu_na = scan.nextLine();
        while (codi_acu_na.length() != 6 || !codi_acu_na.matches("[0-9]+")) {
            System.out.println("codi_acumulacio_provincia INVÀLID! Torna a introduïr-lo, si us plau. Recorda: 6 dígits!");
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

    public static void insertPersona() {
        System.out.println("Introdueix el nom de la persona:");
        String nom = scan.nextLine().trim();
        System.out.println("Introdueix el seu primer cognom:");
        String cog1 = scan.nextLine().trim();
        System.out.println("Introdueix el seu segon cognom:");
        String cog2 = scan.nextLine().trim();
        System.out.println("Introdueix el seu DNI (HAN DE SER 8 DÍGITS!)");
        String dni = scan.nextLine().trim();
        while (dni.length() != 8 || !dni.matches("[0-9]+")) {
            System.out.println("DNI INVÀLID! Torna a introduïr-lo, si us plau. Recorda: MÀXIM 2 dígits!");
            dni = scan.nextLine().trim();
        }

        Persona p = new Persona(nom, cog1, cog2, dni);
        PersonaDAODB pDAO = new PersonaDAODB();
        try {
            if (pDAO.create(p)) {
                System.out.println("Registre afegit!");
            } else {
                System.out.println("Oops... Algu ha sortit malament...");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


    }

    public static void readCA(){
        System.out.println("Introdueix la comunitat_aut_id de la comunitat la qual desitges rebre la informació:");
        long com_aut_id = scan.nextLong();

        ComunitatAutonomaDAODB caDAO = new ComunitatAutonomaDAODB();
        try {
            String infoComunitatAutonoma = caDAO.read(com_aut_id);
            System.out.println(infoComunitatAutonoma);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void readCandidatura(){
        System.out.println("Introdueix la candidatura_id de la candidatura la qual desitges rebre la informació:");
        long can_id = scan.nextLong();

        CandidaturaDAODB canDAO = new CandidaturaDAODB();
        try {
            String infoCandidatura = canDAO.read(can_id);
            System.out.println(infoCandidatura);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void readPersona(){
        System.out.println("Introdueix la persona_id de la persona la qual desitges rebre la informació:");
        long pers_id = scan.nextLong();

        PersonaDAODB p = new PersonaDAODB();
        try {
            String infoCandidatura = p.read(pers_id);
            System.out.println(infoCandidatura);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void updateCA(){}

    public static void updateCandidatura(){}

    public static void updatePersona(){}
}
