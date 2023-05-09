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
    public boolean read(ComunitatAutonoma comunitatAutonoma) {
        return false;
    }
    public ComunitatAutonoma readById(long id) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ComunitatAutonoma comunitatAutonoma = null;
        try {
            con = DBMySQLManager.getConnection();
            String sql = "SELECT * FROM comunitats_autonomes WHERE comunitat_autonoma_id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, comunitatAutonoma.getComunitat_aut_id());
            rs = stmt.executeQuery();
            if (rs.next()) {
                String nom = rs.getString("nom");
                String codi_ine = rs.getString("codi_ine");
                comunitatAutonoma = new ComunitatAutonoma(nom, codi_ine);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la comunidad autónoma con identificador " + comunitatAutonoma.getComunitat_aut_id() + ": " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return comunitatAutonoma;
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
