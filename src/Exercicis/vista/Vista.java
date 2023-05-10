package Exercicis.vista;

import Exercicis.opcionsMenu.OpcionsMenu;

import java.util.Scanner;

import static Exercicis.opcionsMenu.OpcionsMenu.updateCA;

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
                        OpcionsMenu.insertCandidatura();
                        break;
                    case 2:
                        OpcionsMenu.readCandidatura();
                        break;
                }
                break;
            case 2:
                registerMenu();
                operationOption = scan.nextInt();
                switch (operationOption) {
                    case 1:
                        OpcionsMenu.insertPersona();
                        break;
                    case 2:
                        OpcionsMenu.readPersona();
                        break;
                    case 3:
                        OpcionsMenu.updatePersona();
                        break;
                }
                break;
            case 3:
                registerMenu();
                operationOption = scan.nextInt();
                switch (operationOption) {
                    case 1:
                        OpcionsMenu.insertCA();
                        break;
                    case 2:
                        OpcionsMenu.readCA();
                        break;
                    case 3:
                        updateCA();
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


}
