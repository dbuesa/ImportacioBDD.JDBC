package Exercicis.objectes.DAO;

import Exercicis.Importacio.DBMySQLManager;
import Exercicis.objectes.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDAODB implements DAODB<Persona> {

    @Override
    public boolean create(Persona persona) throws SQLException {
        boolean addedPerson = false;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DBMySQLManager.getConnection();
            String sql = "INSERT INTO persones (nom, cog1, cog2, dni) " +
                    "VALUES (?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, persona.getNom());
            stmt.setString(2, persona.getCog1());
            stmt.setString(3, persona.getCog2());
            stmt.setString(4, persona.getDni());

            int quantity = stmt.executeUpdate();

            addedPerson = (quantity > 0);

        } catch (Exception e) {
            System.out.println("Error al crear la persona " + e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return addedPerson;
    }

    @Override
    public String read(long persona_id) throws SQLException {
        String value = null;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DBMySQLManager.getConnection();
            String sql = "SELECT nom FROM candidatures WHERE candidatura_id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, persona_id);
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
//    @Override
//    public boolean read(Persona persona) throws SQLException {
//
//        Connection con = null;
//        PreparedStatement stmt = null;
//
//        try{
//            con = DBMySQLManager.getConnection();
//            String sql = "SELECT nom, cog1, cog2, dni FROM persones WHERE dni = ?";
//            stmt = con.prepareStatement(sql);
//            stmt.setString(1, persona.getDni());
//
//
//        }catch (Exception e){
//            System.out.println("Error al crear la persona " + e.getMessage());
//        }finally{
//            if (stmt != null) {
//                stmt.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
//        return false;
//    }

    public boolean read(Long persona_id) {
//        Persona er = read(p.getPersona_id());
//        if (er == null) return false;
//        p.set(er.getNom(), er.getDn(), er.getDep());
        return true;
    }

//    public Persona read(long persona_id) {
//        String p = Long.toString(persona_id);
//        String query = "SELECT nom, cog1, cog2, dni FROM persones WHERE id= ?";
//        List<Object[]> r = DBMySQLManager.read(query);
//        if (r == null || r.size() != 1) return null;
//        Object[] o = r.iterator().next();
//        return new Persona(persona_id, (String) o[0], (String) o[1], (String) o[2], (String) o[3]);
//    }


    @Override
    public boolean update(Persona persona) {
        return false;
    }

    @Override
    public boolean delete(Persona persona) {
        return false;
    }
}
