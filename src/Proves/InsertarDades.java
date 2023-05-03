package Proves;
import java.sql.*;
import java.util.Calendar;
import java.util.List;

public class InsertarDades {
    public static void main(String[] args) {

    }
    public void insertData(List<String[]> data){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://10.2.211.106/eleccions2017", "perepi", "pastanaga");


            //Preparem el Date
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " INSERT INTO candidats (candidat_id,candidatura_id,persona_id,provincia_id,num_ordre,tipus)"
                    + " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            for (int i = 0; i < data.size(); i++) {
                String[] values = data.get(i);
                preparedStmt.setString(1, values[0]);
                preparedStmt.setInt(2, Integer.parseInt(values[1]));
                preparedStmt.setInt(3, Integer.parseInt(values[2]));
                preparedStmt.setInt(4, Integer.parseInt(values[3]));
                preparedStmt.setInt(5, Integer.parseInt(values[4]));
                preparedStmt.setString(6, "T");
                //preparedStmt.setDate(6, startDate);
                /*preparedStmt.setString(7, "IT_PROG");
                preparedStmt.setFloat(8, 5000.12f);*/

                // execute the preparedstatement
                preparedStmt.execute();
            }
            //Tanquem la connexió
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
