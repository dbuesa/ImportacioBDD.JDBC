import Exercicis.objectes.Candidatura;
import Exercicis.objectes.ComunitatAutonoma;
import Exercicis.objectes.DAO.CandidaturaDAODB;
import Exercicis.objectes.DAO.ComunitatAutonomaDAODB;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        /*
        ComunitatAutonoma c1 = new ComunitatAutonoma("Los Madriles", "88");

        ComunitatAutonomaDAODB c1DAO = new ComunitatAutonomaDAODB();

        try {
            if (c1DAO.create(c1)){
                System.out.println("Agregat, rei!");
            }else {
                System.out.println("Oops... Algu ha sortit malament, maco...");
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

         */

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
