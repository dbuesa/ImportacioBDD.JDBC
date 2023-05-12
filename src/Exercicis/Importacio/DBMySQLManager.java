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
    private String host = ipMarc; //IP de qui executi el programa
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

    public static Connection getcon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String unicode="useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8";
            return DriverManager.getConnection("jdbc:mysql://10.2.106.42:3306/practicaEleccions?serverTimezone=UTC" +unicode, "perepi", "pastanaga");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("couldn't connect!");
            throw new RuntimeException(ex);
        }
    }
}