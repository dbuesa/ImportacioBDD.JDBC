package Exercicis.objectes.DAO;

import Exercicis.Importacio.DBMySQLManager;
import Exercicis.SQLRW.SQLRW;
import Exercicis.objectes.Candidatura;
import Exercicis.objectes.ComunitatAutonoma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CandidaturaDAODB implements DAODB<Candidatura> {

    @Override
    public boolean create(Candidatura candidatura) throws SQLException {
        boolean addedApplication = false;
        Connection con = DBMySQLManager.getConnection();
        try {
            String sql = "INSERT INTO candidatures (eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia, codi_acumulacio_ca, codi_acumulacio_nacional)" +
                    "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);


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
    public boolean read(Candidatura candidatura) {
        return false;
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
