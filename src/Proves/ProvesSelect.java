package Proves;

import java.sql.*;

public class ProvesSelect {
    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://10.2.93.209:3306/eleccions2017", "perepi", "pastanaga");

            //SENTÈNCIA SELECT
            //Sentència sense paràmetres.
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * " +
                                                "FROM eleccions2017.eleccions");

            while (rs.next()) {
                System.out.println(rs.getString("nom") +
                        "  " + rs.getDate("data"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
