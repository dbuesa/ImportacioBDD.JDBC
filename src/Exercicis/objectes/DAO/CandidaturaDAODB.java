package Exercicis.objectes.DAO;

import Exercicis.SQLRW.SQLRW;
import Exercicis.objectes.Candidatura;
import Exercicis.objectes.ComunitatAutonoma;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CandidaturaDAODB implements DAODB<Candidatura> {

    @Override
    public boolean create(Candidatura candidatura) {return false;}

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
