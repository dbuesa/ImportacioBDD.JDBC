package Exercicis.objectes.DAO;

import Exercicis.Importacio.DBMySQLManager;
import Exercicis.objectes.ComunitatAutonoma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComunitatAutonomaDAODB implements DAODB<ComunitatAutonoma> {


    @Override
    public boolean create(ComunitatAutonoma comunitatAutonoma) throws SQLException {
        boolean addedApplication = false;
        Connection con = DBMySQLManager.getConnection();
        try {
            String sql = "INSERT INTO comunitats_autonomes (nom, codi_ine) VALUES (?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, comunitatAutonoma.getNom());
            stmt.setString(2, comunitatAutonoma.getCodi_ine());

            int quantity = stmt.executeUpdate();

            addedApplication = (quantity > 0);

        } catch (Exception e) {
            System.out.println("Error al crear la comunitat autònoma " + e.getMessage());
        } finally {
            DBMySQLManager.closeConnection();
        }
        return addedApplication;
    }

    @Override
    public boolean read(long com_aut_id) {
        return false;
    }
    public String readById(long id) throws SQLException {
        String value = null;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DBMySQLManager.getConnection();
            String sql = "SELECT nom FROM comunitats_autonomes WHERE comunitat_aut_id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                value = rs.getString("nom");
            }
        } catch (Exception e) {
            System.out.println("Error al leer el valor de la comunidad autónoma " + e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return value;
    }

    @Override
    public boolean update(ComunitatAutonoma comunitatAutonoma) {
        return false;
    }

    @Override
    public boolean delete(ComunitatAutonoma comunitatAutonoma) {
        return false;
    }


}
