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
        String nom = scan.nextLine().trim();
        while (!validateString(nom)) {
            System.out.println("nom INVÀLID! Torna a introduïr-lo, si us plau");
            nom = scan.nextLine().trim();
        }
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
        verify6Numbers(codi_can, "codi_candidatura");
        System.out.println("Introdueix el nom curt de la candidatura");
        String nom_curt = scan.nextLine();
        while (!validateString(nom_curt)) {
            System.out.println("nom_curt INVÀLID! Torna a introduïr-lo, si us plau");
            nom_curt = scan.nextLine().trim();
        }
        System.out.println("Introdueix el nom llarg de la candidatura");
        String nom_llarg = scan.nextLine();
        while (!validateString(nom_llarg)) {
            System.out.println("nom_llarg INVÀLID! Torna a introduïr-lo, si us plau");
            nom_llarg = scan.nextLine().trim();
        }
        System.out.println("Introdueix el codi d'acumulació provincial (HAN DE SER 6 DÍGITS!)");
        String codi_acu_prov = scan.nextLine();
        verify6Numbers(codi_acu_prov, "codi_acumulacio_provincia");
        System.out.println("Introdueix el codi d'acumulació CA (HAN DE SER 6 DÍGITS!)");
        String codi_acu_ca = scan.nextLine();
        verify6Numbers(codi_acu_ca, "codi_acumulacio_ca");
        System.out.println("Introdueix el codi d'acumulació nacional (HAN DE SER 6 DÍGITS!)");
        String codi_acu_na = scan.nextLine();
        verify6Numbers(codi_acu_na, "codi_acumulacio_na");

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
        while (!validateString(nom)) {
            System.out.println("nom INVÀLID! Torna a introduïr-lo, si us plau");
            nom = scan.nextLine().trim();
        }
        System.out.println("Introdueix el seu primer cognom:");
        String cog1 = scan.nextLine().trim();
        while (!validateString(cog1)) {
            System.out.println("cog1 INVÀLID! Torna a introduïr-lo, si us plau");
            cog1 = scan.nextLine().trim();
        }
        System.out.println("Introdueix el seu segon cognom:");
        String cog2 = scan.nextLine().trim();
        while (!validateString(cog2)) {
            System.out.println("cog2 INVÀLID! Torna a introduïr-lo, si us plau");
            cog2 = scan.nextLine().trim();
        }
        System.out.println("Introdueix el seu DNI (HAN DE SER 8 DÍGITS!)");
        String dni = scan.nextLine().trim();
        while (dni.length() != 8 || !dni.matches("[0-9]+")) {
            System.out.println("DNI INVÀLID! Torna a introduïr-lo, si us plau. Recorda: 8 dígits!");
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

    public static void readCA() {
        System.out.println("Introdueix la comunitat_aut_id de la comunitat la qual desitges rebre la informació:");
        while (!scan.hasNextLong()) {
            System.out.println("Error: si us plau, introdueix un número de comunitat_aut_id vàlid:");
            scan.next();
        }
        long com_aut_id = scan.nextLong();

        ComunitatAutonomaDAODB caDAO = new ComunitatAutonomaDAODB();
        try {
            String infoComunitatAutonoma = caDAO.read(com_aut_id);
            System.out.println(infoComunitatAutonoma);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void readCandidatura() {
        System.out.println("Introdueix la candidatura_id de la candidatura la qual desitges rebre la informació:");
        while (!scan.hasNextLong()) {
            System.out.println("Error: si us plau, introdueix un número de la taula vàlid:");
            scan.next();
        }
        long can_id = scan.nextLong();

        CandidaturaDAODB canDAO = new CandidaturaDAODB();
        try {
            String infoCandidatura = canDAO.read(can_id);
            System.out.println(infoCandidatura);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void readPersona() {
        System.out.println("Introdueix la persona_id de la persona la qual desitges rebre la informació:");
        while (!scan.hasNextLong()) {
            System.out.println("Error: si us plau, introdueix un número de persona_id vàlid:");
            scan.next();
        }
        long pers_id = scan.nextLong();

        PersonaDAODB p = new PersonaDAODB();
        try {
            String infoCandidatura = p.read(pers_id);
            System.out.println(infoCandidatura);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void updateCA() {
        boolean bandera = false;
        do {
            System.out.println("Itrodueix el id de la comunitat autònoma que desitges modificar");
            while (!scan.hasNextLong()) {
                System.out.println("Error: si us plau, introdueix un número de comunitat_aut_id vàlid:");
                scan.next();
            }
            long id = scan.nextLong();
            int opcio;
            System.out.println("╔════════════════════════════════╗");
            System.out.println("║   Quin camp vols modificar?    ║");
            System.out.println("╚════════════════════════════════╝");
            do {
                System.out.println("╔═════════════════╗");
                System.out.println("║ 1- nom          ║");
                System.out.println("║ 2- codi_ine     ║");
                System.out.println("╚═════════════════╝");
                while (!scan.hasNextInt()) {
                    System.out.println("Error: si us plau, introdueix un número de comunitat_aut_id vàlid:");
                    scan.next();
                }
                opcio = scan.nextInt();
                if (opcio < 1 || opcio > 2) System.out.println("Aquest camp no existeix! Torna a probar:");
            } while (opcio < 1 || opcio > 2);
            updateColumnCA(id, opcio);
            System.out.println("Vols seguir modificant la taula de comunitats autònomes (prem 1 per continuar modificant, o qualsevol altra tecla per sortir)?");
            String continuar = scan.nextLine();
            if (continuar.equals("1")) {
                bandera = true;
            }
        } while (bandera);
    }

    public static void updatePersona() {
        boolean bandera = false;
        do {
            System.out.println("Itrodueix el id de la persona que desitges modificar");
            while (!scan.hasNextLong()) {
                System.out.println("Error: si us plau, introdueix un número de persona_id vàlid:");
                scan.next();
            }
            long id = scan.nextLong();
            int opcio;
            System.out.println("╔════════════════════════════════╗");
            System.out.println("║   Quin camp vols modificar?    ║");
            System.out.println("╚════════════════════════════════╝");
            do {
                System.out.println("╔═══════════╗");
                System.out.println("║ 1- nom    ║");
                System.out.println("║ 2- cog1   ║");
                System.out.println("║ 3- cog2   ║");
                System.out.println("║ 4- DNI    ║");
                System.out.println("╚═══════════╝");
                while (!scan.hasNextInt()) {
                    System.out.println("Error: si us plau, introdueix un número de comunitat_aut_id vàlid:");
                    scan.next();
                }
                opcio = scan.nextInt();
                if (opcio < 1 || opcio > 4) System.out.println("Aquest camp no existeix! Torna a probar:");
            } while (opcio < 1 || opcio > 4);
            updateColumnPersona(id, opcio);
            System.out.println("Vols seguir modificant la taula de persones (prem 1 per continuar modificant, o qualsevol altra tecla per sortir)?");
            String continuar = scan.nextLine();
            if (continuar.equals("1")) {
                bandera = true;
            }
        } while (bandera);
    }

    public static void updateCandidatura() {
        boolean bandera = false;
        do {
            System.out.println("Itrodueix el id de la candidatura que desitges modificar");
            while (!scan.hasNextLong()) {
                System.out.println("Error: si us plau, introdueix un número de candidatura_id vàlid:");
                scan.next();
            }
            long id = scan.nextLong();
            int opcio;
            System.out.println("╔════════════════════════════════╗");
            System.out.println("║   Quin camp vols modificar?    ║");
            System.out.println("╚════════════════════════════════╝");
            do {
                System.out.println("╔════════════════════════════════╗");
                System.out.println("║ 1- codi_candidatura            ║");
                System.out.println("║ 2- nom_curt                    ║");
                System.out.println("║ 3- nom_llarg                   ║");
                System.out.println("║ 4- codi_acumulacio_provincia   ║");
                System.out.println("║ 5- codi_acumulacio_ca          ║");
                System.out.println("║ 6- codi_acumulacio_ncional     ║");
                System.out.println("╚════════════════════════════════╝");
                while (!scan.hasNextInt()) {
                    System.out.println("Error: si us plau, introdueix un número de comunitat_aut_id vàlid:");
                    scan.next();
                }
                opcio = scan.nextInt();
                if (opcio < 1 || opcio > 6) System.out.println("Aquest camp no existeix! Torna a probar:");
            } while (opcio < 1 || opcio > 6);
            updateColumnCandidatura(id, opcio);
            System.out.println("Vols seguir modificant la taula de candidatures (prem 1 per continuar modificant, o qualsevol altra tecla per sortir)?");
            String continuar = scan.nextLine();
            if (continuar.equals("1")) {
                bandera = true;
            }
        } while (bandera);
    }

    public static void deleteCA() {
        System.out.println("Introdueix el id de la comunitat autònoma que desitges eliminar");
        while (!scan.hasNextLong()) {
            System.out.println("Error: si us plau, introdueix un número de comunitat_aut_id vàlid:");
            scan.next();
        }
        long id = scan.nextLong();
        ComunitatAutonomaDAODB comunitatAutonomaDAODB = new ComunitatAutonomaDAODB();

        ComunitatAutonoma comunitatAutonoma = new ComunitatAutonoma();
        comunitatAutonoma.setComunitat_aut_id(id);

        try {
            boolean result = comunitatAutonomaDAODB.delete(comunitatAutonoma);
            if (result) {
                System.out.println("Comunitat autonòma eliminada correctament.");
            } else {
                System.out.println("No s'ha pogut eliminar la comunitat autònoma.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la comunitat autònoma: " + e.getMessage());
        }
    }

    public static void deletePersona() {
        System.out.println("Introdueix el id de la persona que desitges eliminar");
        while (!scan.hasNextLong()) {
            System.out.println("Error: si us plau, introdueix un número de persona_id vàlid:");
            scan.next();
        }
        long id = scan.nextLong();
        PersonaDAODB personaDAO = new PersonaDAODB();

        Persona persona = new Persona();
        persona.setPersona_id(id);

        try {
            boolean result = personaDAO.delete(persona);
            if (result) {
                System.out.println("Persona eliminada correctament.");
            } else {
                System.out.println("No s'ha pogut eliminar la persona.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la persona: " + e.getMessage());
        }
    }

    public static void deleteCandidatura() {
        System.out.println("Introdueix el id de la candidatura que desitges eliminar");
        while (!scan.hasNextLong()) {
            System.out.println("Error: si us plau, introdueix un número de candidatura:_id vàlid:");
            scan.next();
        }
        long id = scan.nextLong();
        CandidaturaDAODB candidaturaDAODB = new CandidaturaDAODB();

        Candidatura candidatura = new Candidatura();
        candidatura.setCandidatura_id(id);

        try {
            boolean result = candidaturaDAODB.delete(candidatura);
            if (result) {
                System.out.println("Candidatura eliminada correctament.");
            } else {
                System.out.println("No s'ha pogut eliminar la candidatura.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la candidatura: " + e.getMessage());
        }
    }


    public static void updateColumnCA(long ca_id, int columna) {
        ComunitatAutonomaDAODB c = new ComunitatAutonomaDAODB();
        try {
            long idDesitjat = ca_id;
            String caActual = c.read(idDesitjat);
            System.out.println("\nCOMUNITAT AUTÒNOMA ACTUAL: " + caActual + "\n");

            String nom = null;
            String codi_ine;

            if (columna == 1) {
                System.out.println("Quin és el nou nom que desitges introduïr?");
                scan.nextLine();
                nom = scan.nextLine();
                while (!validateString(nom)) {
                    System.out.println("nom INVÀLID! Torna a introduïr-lo, si us plau");
                    nom = scan.nextLine().trim();
                }
                ComunitatAutonoma ca = new ComunitatAutonoma(nom);
                ca.setComunitat_aut_id(idDesitjat);
                ca.setNom(nom);
                boolean actualitzat = c.update(ca);
                if (actualitzat) {
                    System.out.println("Comunitat autònoma actualitzada correctament.");
                } else {
                    System.out.println("No s'ha pogut actualitzar la comunitat autònoma.");
                }
            } else if (columna == 2) {
                System.out.println("Quin és el nou codi_ine que desitges introduïr (HAN DE SER 2 DÍGITS!)?");
                scan.nextLine();
                codi_ine = scan.nextLine();
                while (codi_ine.length() != 2 || !codi_ine.matches("[0-9]+")) {
                    System.out.println("Codi_ine INVÀLID! Torna a introduïr-lo, si us plau. Recorda: MÀXIM 2 dígits!");
                    codi_ine = scan.nextLine();
                }
                ComunitatAutonoma ca = new ComunitatAutonoma(nom, codi_ine);
                ca.setComunitat_aut_id(idDesitjat);
                ca.setCodi_ine(codi_ine);

                boolean actualitzat = c.update(ca);
                if (actualitzat) {
                    System.out.println("Comunitat autònoma actualitzada correctament.");
                } else {
                    System.out.println("No s'ha pogut actualitzar la comunitat autònoma.");
                }
            } else {
                System.out.println("Columna no vàlida.");
                return;
            }


        } catch (SQLException e) {
            System.out.println("Error al realitzar la operació en la base de dades: " + e.getMessage());
        }
    }


    public static void updateColumnPersona(long per_id, int columna) {
        PersonaDAODB p = new PersonaDAODB();
        try {
            long idDesitjat = per_id;
            String caActual = p.read(idDesitjat);
            System.out.println("\nPERSONA ACTUAL: " + caActual + "\n");

            String nom = null;
            String cog1 = null;
            String cog2 = null;
            String dni = null;

            if (columna == 1) {
                System.out.println("Quin és el nou nom que desitges introduïr?");
                scan.nextLine();
                nom = scan.nextLine();
                while (!validateString(nom)) {
                    System.out.println("nom INVÀLID! Torna a introduïr-lo, si us plau");
                    nom = scan.nextLine().trim();
                }
                Persona per = new Persona(nom);
                per.setPersona_id(idDesitjat);
                per.setNom(nom);
                boolean actualitzat = p.update(per);
                if (actualitzat) {
                    System.out.println("Persona actualitzada correctament.");
                } else {
                    System.out.println("No s'ha pogut actualitzar la persona.");
                }
            } else if (columna == 2) {
                System.out.println("Quin és el nou primer cognom desitges introduïr?");
                scan.nextLine();
                cog1 = scan.nextLine();
                while (!validateString(cog1)) {
                    System.out.println("cog1 INVÀLID! Torna a introduïr-lo, si us plau");
                    cog1 = scan.nextLine().trim();
                }
                Persona per = new Persona(nom, cog1, cog2, dni);
                per.setPersona_id(idDesitjat);
                per.setCog1(cog1);
                boolean actualitzat = p.update(per);
                if (actualitzat) {
                    System.out.println("Persona actualitzada correctament.");
                } else {
                    System.out.println("No s'ha pogut actualitzar la persona.");
                }
            } else if (columna == 3) {
                System.out.println("Quin és el nou segon cognom desitges introduïr?");
                scan.nextLine();
                cog2 = scan.nextLine();
                while (!validateString(cog2)) {
                    System.out.println("cog2 INVÀLID! Torna a introduïr-lo, si us plau");
                    cog2 = scan.nextLine().trim();
                }
                Persona per = new Persona(nom, cog1, cog2, dni);
                per.setPersona_id(idDesitjat);
                per.setCog2(cog2);
                boolean actualitzat = p.update(per);
                if (actualitzat) {
                    System.out.println("Persona actualitzada correctament.");
                } else {
                    System.out.println("No s'ha pogut actualitzar la persona.");
                }
            } else if (columna == 4) {
                System.out.println("Quin és el nou DNI desitges introduïr?");
                scan.nextLine();
                dni = scan.nextLine();
                while (dni.length() != 8 || !dni.matches("[0-9]+")) {
                    System.out.println("DNI INVÀLID! Torna a introduïr-lo, si us plau. Recorda: 8 dígits!");
                    dni = scan.nextLine().trim();
                }
                Persona per = new Persona(nom, cog1, cog2, dni);
                per.setPersona_id(idDesitjat);
                per.setDni(dni);
                boolean actualitzat = p.update(per);
                if (actualitzat) {
                    System.out.println("Persona actualitzada correctament.");
                } else {
                    System.out.println("No s'ha pogut actualitzar la persona.");
                }
            } else {
                System.out.println("Columna no vàlida.");
                return;
            }


        } catch (SQLException e) {
            System.out.println("Error al realitzar la operació en la base de dades: " + e.getMessage());
        }

    }

    public static void updateColumnCandidatura(long can_id, int columna) {
        CandidaturaDAODB can = new CandidaturaDAODB();
        try {
            long idDesitjat = can_id;
            String caActual = can.read(idDesitjat);
            System.out.println("\nCANDIDATURA ACTUAL: " + caActual + "\n");

            long eleccio_id = 1;
            String codi_candidatura = null;
            String nom_curt = null;
            String nom_llarg = null;
            String codi_acumulacio_provincia = null;
            String codi_acumulacio_ca = null;
            String codi_acumulacio_nacional = null;

            if (columna == 1) {
                System.out.println("Quin és el nou codi_candidatura que desitges introduïr (HAN DE SER 6 DÍGITS!)?");
                scan.nextLine();
                codi_candidatura = scan.nextLine();
                verify6Numbers(codi_candidatura, "codi_candidatura");
                Candidatura ca = new Candidatura(eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia, codi_acumulacio_ca, codi_acumulacio_nacional);
                ca.setCandidatura_id(idDesitjat);
                ca.setCandidatura_id((int) eleccio_id);
                boolean actualitzat = can.update(ca);
                if (actualitzat) {
                    System.out.println("Candidatura actualitzada correctament.");
                } else {
                    System.out.println("No s'ha pogut actualitzar la candidatura.");
                }
            } else if (columna == 2) {
                System.out.println("Quin és el nou nom_curt que desitges introduïr?");
                scan.nextLine();
                nom_curt = scan.nextLine();
                while (!validateString(nom_curt)) {
                    System.out.println("nom_curt INVÀLID! Torna a introduïr-lo, si us plau");
                    nom_curt = scan.nextLine().trim();
                }
                Candidatura ca = new Candidatura(eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia, codi_acumulacio_ca, codi_acumulacio_nacional);
                ca.setCandidatura_id(idDesitjat);
                ca.setNom_curt(nom_curt);
                boolean actualitzat = can.update(ca);
                if (actualitzat) {
                    System.out.println("Candidatura actualitzada correctament.");
                } else {
                    System.out.println("No s'ha pogut actualitzar la candidatura.");
                }
            } else if (columna == 3) {
                System.out.println("Quin és el nou nom_llarg que desitges introduïr?");
                scan.nextLine();
                nom_llarg = scan.nextLine();
                while (!validateString(nom_llarg)) {
                    System.out.println("nom_curt INVÀLID! Torna a introduïr-lo, si us plau");
                    nom_llarg = scan.nextLine().trim();
                }
                Candidatura ca = new Candidatura(eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia, codi_acumulacio_ca, codi_acumulacio_nacional);
                ca.setCandidatura_id(idDesitjat);
                ca.setNom_llarg(nom_llarg);
                boolean actualitzat = can.update(ca);
                if (actualitzat) {
                    System.out.println("Candidatura actualitzada correctament.");
                } else {
                    System.out.println("No s'ha pogut actualitzar la candidatura.");
                }
            } else if (columna == 4) {
                System.out.println("Quin és el nou codi_acumulacio_provincia que desitges introduïr? (HAN DE SER 6 DÍGITS!)");
                scan.nextLine();
                codi_acumulacio_provincia = scan.nextLine();
                verify6Numbers(codi_acumulacio_provincia, "codi_acumulacio_provincia");
                Candidatura ca = new Candidatura(eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia, codi_acumulacio_ca, codi_acumulacio_nacional);
                ca.setCandidatura_id(idDesitjat);
                ca.setCodi_acumulacio_provincia(codi_acumulacio_provincia);
                boolean actualitzat = can.update(ca);
                if (actualitzat) {
                    System.out.println("Candidatura actualitzada correctament.");
                } else {
                    System.out.println("No s'ha pogut actualitzar la candidatura.");
                }
            } else if (columna == 5) {
                System.out.println("Quin és el nou codi_acumulacio_ca que desitges introduïr? (HAN DE SER 6 DÍGITS!)");
                scan.nextLine();
                codi_acumulacio_ca = scan.nextLine();
                verify6Numbers(codi_acumulacio_ca, "codi_acumulacio_ca");
                Candidatura ca = new Candidatura(eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia, codi_acumulacio_ca, codi_acumulacio_nacional);
                ca.setCandidatura_id(idDesitjat);
                ca.setCodi_acumulacio_ca(codi_acumulacio_ca);
                boolean actualitzat = can.update(ca);
                if (actualitzat) {
                    System.out.println("Candidatura actualitzada correctament.");
                } else {
                    System.out.println("No s'ha pogut actualitzar la candidatura.");
                }
            } else if (columna == 6) {
                System.out.println("Quin és el nou codi_acumulacio_nacional que desitges introduïr? (HAN DE SER 6 DÍGITS!)");
                scan.nextLine();
                codi_acumulacio_nacional = scan.nextLine();
                verify6Numbers(codi_acumulacio_nacional, "codi_acumulacio_nacional");
                Candidatura ca = new Candidatura(eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia, codi_acumulacio_ca, codi_acumulacio_nacional);
                ca.setCandidatura_id(idDesitjat);
                ca.setCodi_acumulacio_nacional(codi_acumulacio_nacional);
                boolean actualitzat = can.update(ca);
                if (actualitzat) {
                    System.out.println("Candidatura actualitzada correctament.");
                } else {
                    System.out.println("No s'ha pogut actualitzar la candidatura.");
                }
            } else {
                System.out.println("Columna no vàlida.");
                return;
            }


        } catch (SQLException e) {
            System.out.println("Error al realitzar la operació en la base de dades: " + e.getMessage());
        }

    }

    public static void verify6Numbers(String codi, String columna) {
        while (codi.length() != 6 || !codi.matches("[0-9]+")) {
            System.out.println(columna + " INVÀLID! Torna a introduïr-lo, si us plau. Recorda: 6 dígits!");
            codi = scan.nextLine().trim();
        }
    }


    public static boolean validateString(String palabra) {
        String patron = "^[a-zA-ZáéíóúàèìòùñÁÉÍÓÚÀÈÌÒÙÇç\\s]+$";

        return palabra.matches(patron);
    }
}

