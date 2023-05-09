package Exercicis.objectes.DAO;

import Exercicis.SQLRW.SQLRW;
import Exercicis.objectes.Persona;

import java.sql.Connection;

public class PersonaDAODB implements DAODB<Persona> {

    @Override
    public boolean create(Persona persona) {
        boolean addedPerson = false;
        Connection conn = SQLRW.getConnection();
        try{
            String sql = "INSERT INTO persones (nom, cog1, cog2, dni) VALUES (?, ?, ?, ?)";

        }catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean read(Persona persona) {
        return false;
    }

    @Override
    public boolean update(Persona persona) {
        return false;
    }

    @Override
    public boolean delete(Persona persona) {
        return false;
    }
}
