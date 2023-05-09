package Exercicis.Importacio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBMySQLManager {
    //Conexions
    static String ipDavid = "10.2.211.106";
    static String ipMarc = "10.2.106.42";
    static String ipDirecte = "10.2.179.196";

    // Propietats
    private static Connection conn = null;
    private String driver = "com.mysql.cj.jdbc.Driver"; //com.mysql.jdbc.Driver
    private String url;
    private String usuari ="perepi";
    private String contrasenya = "pastanaga";
    private String host = ipDirecte; //IP de qui executi el programa
    private String base_dades = "practicaEleccions"; // PROVA: eleccions2017, BONA: eleccions2016

    // Constructors
    private DBMySQLManager(){

        this.url = "jdbc:mysql://" + host + ":3306/" + base_dades + "?serverTimezone=UTC";

        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuari, contrasenya);
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    // Mètodes
    public static Connection getConnection() {

        if (conn == null){
            new DBMySQLManager();
        }

        return conn;
    }

    public static void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
    public static List<Object> read(String query) throws SQLException {
        Connection con = getConnection();
        if (con == null) return null;

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return getRsValues(rs);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }
    private static List<Object> getRsValues(ResultSet rs) throws SQLException {
        List<Object> values = new ArrayList<>();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                String value = rs.getString(i);
                values.add(value);
            }
        }

        return values;
    }

    public static int write(String query) throws SQLException {
        Connection con = getConnection();
        if (con == null) return 0;

        int r = 0;

        try {
            Statement stmt = con.createStatement();
            r = stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }

        return r;
    }
}