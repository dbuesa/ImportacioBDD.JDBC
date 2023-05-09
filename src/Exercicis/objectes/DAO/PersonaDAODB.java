package Exercicis.objectes.DAO;

import Exercicis.Importacio.DBMySQLManager;
import Exercicis.objectes.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonaDAODB implements DAODB<Persona> {

    @Override
    public boolean create(Persona persona) throws SQLException {
        boolean addedPerson = false;
        Connection con = DBMySQLManager.getConnection();
        try{
            String sql = "INSERT INTO persones (nom, cog1, cog2, dni) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, persona.getNom());
            stmt.setString(2, persona.getCog1());
            stmt.setString(3, persona.getCog2());
            stmt.setString(4, persona.getDni());

            int quantity = stmt.executeUpdate();

            addedPerson= (quantity > 0);

        }catch (Exception e){
            System.out.println("Error al crear la persona " + e.getMessage());
        }finally{
            DBMySQLManager.closeConnection();
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
