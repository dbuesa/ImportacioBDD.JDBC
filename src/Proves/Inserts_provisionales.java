package Proves;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class Inserts_provisionales {

    public static void insertComunitat(String nom, String codi_ine) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://10.2.211.106/eleccions2016", "perepi", "pastanaga");


            //Preparem el Date
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " INSERT INTO comunitats_autonomes (nom,codi_ine)"
                    + " values (?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nom);
            preparedStmt.setString(2, codi_ine);
            // execute the preparedstatement
            preparedStmt.execute();
            //Tanquem la connexió
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertProvincia(String codi_ine_ca, String nom, String codi_ine_prov, int num_escons) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://10.2.211.106/eleccions2016", "perepi", "pastanaga");


            //Preparem el Date
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " INSERT INTO provincies (comunitat_aut_id,nom,codi_ine,num_escons)"
                    + " SELECT comunitat_aut_id, ?, ?, ?" +
                    " FROM comunitats_autonomes" +
                    " WHERE codi_ine = ?";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nom);
            preparedStmt.setString(2, codi_ine_prov);
            preparedStmt.setInt(3, num_escons);
            preparedStmt.setString(4, codi_ine_ca);
            // execute the preparedstatement
            preparedStmt.execute();
            //Tanquem la connexió
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertPersones(String nom, String cog1, String cog2) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://10.2.106.42/eleccions2016", "perepi", "pastanaga");

            //Preparem el Date
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " INSERT INTO persones (nom,cog1,cog2)"
                    + " values (?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nom);
            preparedStmt.setString(2, cog1);
            preparedStmt.setString(3, cog2);
            // execute the preparedstatement
            preparedStmt.execute();
            //Tanquem la connexió
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertVotsProvincials(int codi_ine, int canditatura_id, int vots, int candidats_obtinguts) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://10.2.106.42/eleccions2016", "perepi", "pastanaga");


            //Preparem el Date
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = "INSERT INTO vots_candidatures_prov (provincia_id, candidatura_id, vots, candidats_obtinguts)" +
            "VALUES ((SELECT provincia_id" +
                    "FROM provincies" +
                    "WHERE codi_ine = ?)," +
            "(SELECT candidatura_id" +
            "FROM candidaturesç" +
            "WHERE codi_candidatura = ? AND eleccio_id = 1), " +
            "?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, codi_ine);
            preparedStmt.setInt(2, canditatura_id);
            preparedStmt.setInt(3, vots);
            preparedStmt.setInt(4, candidats_obtinguts);
            // execute the preparedstatement
            preparedStmt.execute();
            //Tanquem la connexió
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertVotsComunitatAutonoma(int comunitat_autonoma_id, int candidatura_id, int vots) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://10.2.106.42/eleccions2016", "perepi", "pastanaga");


            //Preparem el Date
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " INSERT INTO vots_candidatures_ca (comunitat_autonoma_id,canditatura_id,vots)"
                    + "VALUES ((SELECT candidatura_id" +
                    "    FROM candidatures" +
                    "     WHERE candidatura_id = ? and eleccio_id = 1 )," +
                    " (SELECT comunitat_autonoma_id" +
                    "  FROM comunitats_autonomes" +
                    "   WHERE codi_ine = ?), " +
                    "   ? )";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, comunitat_autonoma_id);
            preparedStmt.setInt(3, vots);
            preparedStmt.setInt(2, candidatura_id);
            // execute the preparedstatement
            preparedStmt.execute();
            //Tanquem la connexió
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
