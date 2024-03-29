package exercicis.objectes.DAO;

import exercicis.connexio.DBMySQLManager;
import exercicis.objectes.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAODB implements DAODB<Persona> {

    private Connection con; // Mantener una única conexión abierta

    public PersonaDAODB() {
        con = DBMySQLManager.getConnection(); // Obtener la conexión al instanciar la clase
    }

    @Override
    public boolean create(Persona persona) throws SQLException {
        boolean addedPerson = false;
        PreparedStatement stmt = null;
        try {

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
        }
        return addedPerson;
    }

    @Override
    public String read(long persona_id) throws SQLException {
        String value = null;

        PreparedStatement stmt = null;
        String valueFinal = null;
        try {

            String sql = "SELECT persona_id, nom, cog1, cog2, dni FROM persones WHERE persona_id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, persona_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                value = "NOM: " + rs.getString("nom");
                value += "\n1r COGNOM: " + rs.getString("cog1");
                value += "\n2n COGNOM: " + rs.getString("cog2");
                value += "\nDNI: " + rs.getString("dni");
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

    public boolean update(Persona persona) throws SQLException {
        boolean updatedPerson = false;

        PreparedStatement stmt = null;
        try {
            // Construir la consulta SQL base
            StringBuilder sqlBuilder = new StringBuilder("UPDATE persones SET");
            List<Object> parameters = new ArrayList<>();

            // Verificar y agregar los campos a actualizar
            if (persona.getNom() != null) {
                sqlBuilder.append(" nom = ?");
                parameters.add(persona.getNom());
            }
            if (persona.getCog1() != null) {
                sqlBuilder.append(" cog1 = ?");
                parameters.add(persona.getCog1());
            }
            if (persona.getCog2() != null) {
                sqlBuilder.append(" cog2 = ?");
                parameters.add(persona.getCog2());
            }
            if (persona.getDni() != null) {
                sqlBuilder.append(" dni = ?");
                parameters.add(persona.getDni());
            }

            sqlBuilder.append(" WHERE persona_id = ?");
            parameters.add(persona.getPersona_id());

            // Crear la declaración preparada y establecer los parámetros
            stmt = con.prepareStatement(sqlBuilder.toString());
            for (int i = 0; i < parameters.size(); i++) {
                stmt.setObject(i + 1, parameters.get(i));
            }

            int quantity = stmt.executeUpdate();
            updatedPerson = (quantity > 0);
        } catch (Exception e) {
            System.out.println("Error al actualizar la persona " + e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return updatedPerson;
    }

    @Override
    public boolean delete(Persona persona) throws SQLException {
        boolean deletePerson = false;
        PreparedStatement stmt = null;
        try {

            String sql = "DELETE FROM persones WHERE persona_id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, persona.getPersona_id());

            int quantity = stmt.executeUpdate();

            deletePerson = (quantity > 0);

        } catch (Exception e) {
            System.out.println("Error al borrar la persona " + e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return deletePerson;
    }
}
