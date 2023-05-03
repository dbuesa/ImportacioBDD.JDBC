package Proves;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class Provincia_districte {

    public void insertData(String nom, String codi_ine) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://<IP>/eleccions2017", "perepi", "pastanaga");


            //Preparem el Date
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " INSERT INTO municipis (nom, codi_ine)"
                    + " values (?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nom);
            preparedStmt.setString(2, codi_ine);
            //preparedStmt.setDate(6, startDate);
                /*preparedStmt.setString(7, "IT_PROG");
                preparedStmt.setFloat(8, 5000.12f);*/

            // execute the preparedstatement
            preparedStmt.execute();
            //Tanquem la connexió
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void insertVotsCandidaturesMunicipis(int eleccio_id, int candidatura_id, int municipi_id, int vots) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://<IP>/eleccions2017", "perepi", "pastanaga");


            //Preparem el Date
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
            // the mysql insert statement
            String query = " INSERT INTO vots_candidatures_mun (eleccio_id, municipi_id, candidatura_id, vots)"
                    +"VALUES ("
                    + "(SELECT eleccio_id" +
                    "   FROM eleccions" +
                    "   WHERE eleccio_id = 1)," +
                    "  (SELECT municipi_id" +
                    "   FROM municipis" +
                    "   WHERE codi_ine = ?)," +
                    "   (SELECT candidatura_id" +
                    "       FROM candidatures" +
                    "       WHERE candidatura_id = ? AND eleccio_id = 1), ?" +
                    " )";
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, 1);
            preparedStmt.setInt(2, municipi_id);
            preparedStmt.setInt(3, candidatura_id);
            preparedStmt.setInt(4, vots);
            //preparedStmt.setDate(6, startDate);
                /*preparedStmt.setString(7, "IT_PROG");
                preparedStmt.setFloat(8, 5000.12f);*/

            // execute the preparedstatement
            preparedStmt.execute();
            //Tanquem la connexió
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


