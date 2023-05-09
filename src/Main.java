import Exercicis.objectes.Candidatura;
import Exercicis.objectes.ComunitatAutonoma;
import Exercicis.objectes.DAO.CandidaturaDAODB;
import Exercicis.objectes.DAO.ComunitatAutonomaDAODB;
import Exercicis.objectes.DAO.PersonaDAODB;
import Exercicis.objectes.Persona;
import Exercicis.vista.Vista;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        PersonaDAODB personaDAO = new PersonaDAODB();

        try {
            // Leer la persona que se desea actualizar desde la base de datos
            long personaId = 3839; // ID de la persona a actualizar
            String nombreActual = personaDAO.read(personaId);
            System.out.println("Nombre actual: " + nombreActual);

            // Crear una instancia de Persona con los nuevos valores
            Persona persona = new Persona("Nuevo nombre");
            persona.setPersona_id(personaId);
            persona.setNom("Miguel");
            persona.setCog1("García");
            persona.setDni("33333333");

            // Actualizar la persona en la base de datos
            boolean actualizado = personaDAO.update(persona);
            if (actualizado) {
                System.out.println("Persona actualizada correctamente.");
            } else {
                System.out.println("No se pudo actualizar la persona.");
            }

            // Leer la persona actualizada desde la base de datos
            String nombreActualizado = personaDAO.read(personaId);
            System.out.println("Nombre actualizado: " + nombreActualizado);

        } catch (SQLException e) {
            System.out.println("Error al realizar la operación en la base de datos: " + e.getMessage());
        }
    }
}


        /*
        ComunitatAutonomaDAODB caDAO = new ComunitatAutonomaDAODB();

        try {
            String infoComunitatAutonoma = caDAO.read(1);
            System.out.println(infoComunitatAutonoma);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

         */

    /*
        CandidaturaDAODB cDAODB = new CandidaturaDAODB();

        try {
            String infoCandidatura = cDAODB.read(1);
            System.out.println(infoCandidatura);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        PersonaDAODB pDAOB = new PersonaDAODB();

        try {
            String infoPersona = pDAOB.read(1);
            System.out.println(infoPersona);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

     */

/*
        Persona p1 = new Persona("Paco", "Perez", "Perez", "88465939");
        PersonaDAODB p1DAO = new PersonaDAODB();

        try {
            if (p1DAO.create(p1)) {
                System.out.println("Agregat, rei!");
            } else {
                System.out.println("Oops... Algu ha sortit malament, maco...");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        Candidatura can1 = new Candidatura(1, "123456", "BUGS", "Burundanda unida ganando sida", "123456", "123456", "123456");
        CandidaturaDAODB can1DAO = new CandidaturaDAODB();
        try {
            if (can1DAO.create(can1)) {
                System.out.println("Agregat!");
            } else {
                System.out.println("Oops... Algu ha sortit malament, maco...");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

 */


