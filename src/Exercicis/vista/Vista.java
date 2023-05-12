package Exercicis.vista;

import Exercicis.opcionsMenu.OpcionsMenu;

import java.awt.*;
import java.util.Scanner;

import static Exercicis.opcionsMenu.OpcionsMenu.*;

public class Vista {
    static Scanner scan = new Scanner(System.in);

    public static void repeatMenu() {
        boolean continuar = true;
        while (continuar) {
            menu();
            System.out.println("Desitges realitzar una altra operació? (S/Qualsevol altra tecla)");
            scan.nextLine();
            String resposta = scan.nextLine();
            continuar = (resposta.equalsIgnoreCase("S"));
            if (!(continuar = (resposta.equalsIgnoreCase("S")))) {
                System.out.println("Fins aviat!");
            }
        }
    }


    public static void menu() {
        int option, operationOption;
        initialMenu();
        while (!scan.hasNextInt()) {
            System.out.println("Error: si us plau, introdueix un número del menú vàlid:");
            scan.next();
        }
        option = scan.nextInt();
        switch (option) {
            case 1:
                registerMenu();
                while (!scan.hasNextInt()) {
                    System.out.println("Error: si us plau, introdueix un número del menú vàlid:");
                    scan.next();
                }
                operationOption = scan.nextInt();

                switch (operationOption) {
                    case 1:
                        OpcionsMenu.insertCandidatura();
                        break;
                    case 2:
                        OpcionsMenu.readCandidatura();
                        break;
                    case 3:
                        OpcionsMenu.updateCandidatura();
                        break;
                    case 4:
                        OpcionsMenu.deleteCandidatura();
                        break;
                    case 5:
                        repeatMenu();
                        break;
                    case 0:
                        System.out.println("Fins aviat!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opció no vàlida");
                        break;
                }
                break;
            case 2:
                registerMenu();
                while (!scan.hasNextInt()) {
                    System.out.println("Error: si us plau, introdueix un número del menú vàlid:");
                    scan.next();
                }
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
                    case 4:
                        OpcionsMenu.deletePersona();
                        break;
                    case 5:
                        repeatMenu();
                        break;
                    case 0:
                        System.out.println("Fins aviat!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opció no vàlida");
                        break;
                }
                break;
            case 3:
                registerMenu();
                while (!scan.hasNextInt()) {
                    System.out.println("Error: si us plau, introdueix un número del menú vàlid:");
                    scan.next();
                }
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
                        break;
                    case 4:
                        deleteCA();
                        break;
                    case 5:
                        repeatMenu();
                        break;
                    case 0:
                        System.out.println("Fins aviat!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opció no vàlida");
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
        System.out.println("┌────────────────────────────────────────┐");
        System.out.println("│          Selecciona una taula          │");
        System.out.println("│        per començar a treballar        │");
        System.out.println("├────────────────────────────────────────┤");
        System.out.println("│ 1. Candidatures                        │");
        System.out.println("│ 2. Persones                            │");
        System.out.println("│ 3. Comunitats Autónomes                │");
        System.out.println("│ 0. Sortir                              │");
        System.out.println("└────────────────────────────────────────┘");

    }

    public static void registerMenu() {
        System.out.println("┌──────────────────────────────────────────┐");
        System.out.println("│   Selecciona una operació per a la       │");
        System.out.println("│           taula escollida:               │");
        System.out.println("├──────────────────────────────────────────┤");
        System.out.println("│ 1. Crear registre                        │");
        System.out.println("│ 2. Obtenir dades d'un registre           │");
        System.out.println("│ 3. Modificar registre                    │");
        System.out.println("│ 4. Eliminar registre                     │");
        System.out.println("│ 5. Tornar al menú de taules              │");
        System.out.println("│ 0. Sortir                                │");
        System.out.println("└──────────────────────────────────────────┘");
    }
}


