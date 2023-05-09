import Exercicis.objectes.Candidatura;
import Exercicis.objectes.ComunitatAutonoma;
import Exercicis.objectes.DAO.CandidaturaDAODB;
import Exercicis.objectes.DAO.ComunitatAutonomaDAODB;
import Exercicis.objectes.DAO.PersonaDAODB;
import Exercicis.objectes.Persona;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {

        ComunitatAutonomaDAODB dao = new ComunitatAutonomaDAODB();
        ComunitatAutonoma c = null;
        try {
            c = dao.readById(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Comunidad autónoma encontrada: " + c.getNom());


        Persona p1 = new Persona("Paco", "Perez", "Perez", "88465939");
        PersonaDAODB p1DAO = new PersonaDAODB();

        try {
            if (p1DAO.create(p1)){
                System.out.println("Agregat, rei!");
            }else {
                System.out.println("Oops... Algu ha sortit malament, maco...");
            }
        }catch (SQLException ex){
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
    }
}

