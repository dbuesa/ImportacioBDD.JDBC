import Exercicis.objectes.Candidatura;
import Exercicis.objectes.ComunitatAutonoma;
import Exercicis.objectes.DAO.CandidaturaDAODB;
import Exercicis.objectes.DAO.ComunitatAutonomaDAODB;
import Exercicis.vista.Vista;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Vista.menu();

/*
        CandidaturaDAODB candidatura = new CandidaturaDAODB();
    try {
            // Leer la persona que se desea actualizar desde la base de datos
            long candidatura_id = 84; // ID de la persona a actualizar
            String candidaturaActual = candidatura.read(candidatura_id);
            System.out.println("Candidatura actual: " + candidaturaActual);

            // Crear una instancia de Persona con los nuevos valores
           Candidatura candidatura1 = new Candidatura("Nuevo nombre");
            candidatura1.setCandidatura_id(candidatura_id);
            candidatura1.setNom_curt("pepito");
            candidatura1.setNom_llarg("PUEBLO ESPAÑOL PROGRESISTA INDEPENDIENTE TOLERANTE ORGULLOSO");
            candidatura1.setCodi_acumulacio_ca("777777");

            // Actualizar la persona en la base de datos
            boolean actualizado = candidatura.update(candidatura1);
            if (actualizado) {
                System.out.println("candidatura actualizada correctamente.");
            } else {
                System.out.println("No se pudo actualizar la candidatura.");
            }

        } catch (SQLException e) {
            System.out.println("Error al realizar la operación en la base de datos: " + e.getMessage());
        }


         */


    }
}



