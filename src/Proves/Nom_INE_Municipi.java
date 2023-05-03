package Proves;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class Nom_INE_Municipi {

    public static void insertData(String nom, String codi_ine, String provincia_id, int districte) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:<IP>/eleccions2017", "perepi", "pastanaga");


            //Preparem el Date
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " INSERT INTO municipis (nom, codi_ine,provincia_id,districte)"
                    + "(SELECT ?, ?, provincia_id, ? " +
                    "   FROM provincies " +
                    "   WHERE codi_ine = ?);";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nom);
            preparedStmt.setString(2, codi_ine);
            preparedStmt.setString(3, String.valueOf(districte));
            preparedStmt.setInt(4, Integer.parseInt(provincia_id));
            // execute the preparedstatement
            preparedStmt.execute();
            //Tanquem la connexió
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
