package Exercicis.vista;

import Exercicis.objectes.ComunitatAutonoma;
import Exercicis.objectes.DAO.ComunitatAutonomaDAODB;
import Exercicis.objectes.DAO.PersonaDAODB;
import Exercicis.objectes.Persona;

import java.sql.SQLException;
import java.util.Scanner;

public class Vista {
    static Scanner scan = new Scanner(System.in);
    public static void menu(){

        int option, operationOption;

        initialMenu();

        option = scan.nextInt();
        switch (option) {
            case 1:
                registerMenu();
                operationOption = scan.nextInt();
                switch (operationOption){
                    case 1:

                }
                break;
            case 2:
                registerMenu();
                operationOption = scan.nextInt();
                break;
            case 3:
                registerMenu();
                operationOption = scan.nextInt();
                switch (operationOption){
                    case 1: insertCA();
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
    public static void initialMenu(){
        System.out.println("Benvingut al menú de taules! Sobre quina taula desitges treballar");
        System.out.println("1. Candidatures");
        System.out.println("2. Persones");
        System.out.println("3. Comunitats autònomes");
        System.out.println("0. Sortir");
    }

    public static void registerMenu(){
        System.out.println("Selecciona una operació per a la taula escollida, si us plau");
        System.out.println("1. Crear registre");
        System.out.println("2. Llegir registre");
        System.out.println("3. Modificar registre");
        System.out.println("4. Eliminar registre");
        System.out.println("0. Sortir");
    }

    public static void insertCA(){
        System.out.println("Quin és el nom de la comunitat autònoma que desitges introduïr?");
        scan.nextLine();
        String nom = scan.nextLine().trim();
        System.out.println("Quin és el seu codi_ine (MÀXIM 2 CARÀCTERS!)");
        String codi_ine = scan.nextLine().trim();
        while (codi_ine.length() > 2) {
            System.out.println("Codi_ine invàlid! Torna a introduïr-lo, si us plau. Recorda: MÀXIM 2 caràcters!");
            codi_ine = scan.nextLine().trim();
        }

        ComunitatAutonoma ca = new ComunitatAutonoma(nom,codi_ine);
        ComunitatAutonomaDAODB caDAO= new ComunitatAutonomaDAODB();
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
}
