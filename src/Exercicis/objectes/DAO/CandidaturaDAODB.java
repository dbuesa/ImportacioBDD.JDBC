package Exercicis.objectes.DAO;

import Exercicis.Importacio.DBMySQLManager;
import Exercicis.objectes.Candidatura;
import Exercicis.objectes.ComunitatAutonoma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidaturaDAODB implements DAODB<Candidatura> {

    @Override
    public boolean create(Candidatura candidatura) throws SQLException {
        boolean addedApplication = false;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DBMySQLManager.getConnection();
            String sql = "INSERT INTO candidatures (eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia, codi_acumulacio_ca, codi_acumulacio_nacional)" +
                        "VALUES (?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, candidatura.getEleccio_id());
            stmt.setString(2, candidatura.getCodi_candidatura());
            stmt.setString(3, candidatura.getNom_curt());
            stmt.setString(4, candidatura.getNom_llarg());
            stmt.setString(5, candidatura.getCodi_acumulacio_provincia());
            stmt.setString(6, candidatura.getCodi_acumulacio_ca());
            stmt.setString(7, candidatura.getCodi_acumulacio_nacional());

            int quantity = stmt.executeUpdate();

            addedApplication= (quantity > 0);

        }catch (Exception e) {
            System.out.println("Error al crear la comunitat autònoma " + e.getMessage());
        }finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return addedApplication;
    }


    @Override
    public String read(long can_id) throws SQLException {
        String value = null;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DBMySQLManager.getConnection();
            String sql = "SELECT nom_curt FROM candidatures WHERE candidatura_id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, can_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                value = rs.getString("nom_curt");
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
    public boolean update(Candidatura candidatura) {
        return false;
    }

    @Override
    public boolean delete(Candidatura candidatura) {
        return false;
    }
}
