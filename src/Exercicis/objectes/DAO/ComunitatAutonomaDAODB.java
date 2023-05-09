package Exercicis.objectes.DAO;

import Exercicis.Importacio.DBMySQLManager;
import Exercicis.objectes.ComunitatAutonoma;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

            addedApplication= (quantity > 0);

        }catch (Exception e) {
            System.out.println("Error al crear la comunitat autònoma " + e.getMessage());
        }finally {
            DBMySQLManager.closeConnection();
        }
        return addedApplication;
    }

    @Override
    public boolean read(ComunitatAutonoma comunitatAutonoma) {
        return false;
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
