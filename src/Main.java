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
    }
}

