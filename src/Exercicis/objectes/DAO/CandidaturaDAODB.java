package Exercicis.objectes.DAO;

import Exercicis.Importacio.DBMySQLManager;
import Exercicis.objectes.Candidatura;
import Exercicis.objectes.ComunitatAutonoma;
import Exercicis.objectes.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidaturaDAODB implements DAODB<Candidatura> {

    private Connection con; // Mantener una única conexión abierta

    public CandidaturaDAODB() {
        con = DBMySQLManager.getConnection(); // Obtener la conexión al instanciar la clase
    }

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
            String sql = "SELECT candidatura_id, eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia, codi_acumulacio_ca, codi_acumulacio_nacional FROM candidatures WHERE candidatura_id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, can_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                value =  rs.getString("candidatura_id");
                value +=  rs.getString("eleccio_id");
                value += ", " + rs.getString("codi_candidatura");
                value += ", " + rs.getString("nom_curt");
                value += ", " + rs.getString("nom_llarg");
                value += ", " + rs.getString("codi_acumulacio_provincia");
                value += ", " + rs.getString("codi_acumulacio_ca");
                value += ", " + rs.getString("codi_acumulacio_nacional");
            }
        } catch (Exception e) {
            System.out.println("Error al leer el valor de la comunidad autónoma " + e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return value;

    }

    public boolean update(Candidatura candidatura) throws SQLException{
        boolean updatedCandidatura = false;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DBMySQLManager.getConnection();
            String sql = "UPDATE candidatures SET nom_curt = ?, nom_llarg = ?, codi_acumulacio_provincia = ?, codi_acumulacio_ca = ?, codi_acumulacio_nacional = ? WHERE candidatura_id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, candidatura.getNom_curt());
            stmt.setString(2, candidatura.getNom_llarg());
            stmt.setString(3, candidatura.getCodi_acumulacio_provincia());
            stmt.setString(4, candidatura.getCodi_acumulacio_ca());
            stmt.setString(5, candidatura.getCodi_acumulacio_nacional());
            stmt.setLong(6, candidatura.getCandidatura_id());

            int quantity = stmt.executeUpdate();

            updatedCandidatura = (quantity > 0);


        } catch (Exception e) {
            System.out.println("Error al actualizar la candidatura " + e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return updatedCandidatura;
    }



    @Override
    public boolean delete(Candidatura candidatura) throws SQLException {
        boolean deleteCandidatura = false;
        PreparedStatement stmt = null;
        try {

            String sql = "DELETE FROM candidatures WHERE candidatura_id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, candidatura.getCandidatura_id());

            int quantity = stmt.executeUpdate();

            deleteCandidatura = (quantity > 0);

        } catch (Exception e) {
            System.out.println("Error al borrar la candidatura " + e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return deleteCandidatura;
    }
}
