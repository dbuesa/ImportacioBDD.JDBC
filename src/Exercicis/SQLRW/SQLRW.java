package Exercicis.SQLRW;

import Exercicis.Importacio.DBMySQLManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLRW {
    static String ipDirecte = "10.2.179.196";
    static String ipDavid = "10.2.211.106";
    static String ipMarc = "10.2.106.42";
    private static Connection conn = null;
    private String driver = "com.mysql.cj.jdbc.Driver"; //com.mysql.jdbc.Driver
    private String url;
    private String usuari = "perepi";
    private String contrasenya = "pastanaga";
    private String host = ipDirecte;
    private String base_dades = "practicaEleccions";


    private SQLRW() {

        this.url = "jdbc:mysql://" + host + ":3306/" + base_dades;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuari, contrasenya);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {

        if (conn == null) {
            new SQLRW();
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
