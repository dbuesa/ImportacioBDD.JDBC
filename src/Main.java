import Exercicis.objectes.ComunitatAutonoma;
import Exercicis.objectes.DAO.ComunitatAutonomaDAODB;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
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
}
