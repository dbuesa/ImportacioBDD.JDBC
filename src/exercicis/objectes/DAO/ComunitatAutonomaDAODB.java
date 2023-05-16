package exercicis.objectes.DAO;

import exercicis.connexio.DBMySQLManager;
import exercicis.objectes.ComunitatAutonoma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComunitatAutonomaDAODB implements DAODB<ComunitatAutonoma> {


    private Connection con; // Mantener una única conexión abierta

    public ComunitatAutonomaDAODB() {
        con = DBMySQLManager.getConnection(); // Obtener la conexión al instanciar la clase
    }
    @Override
    public boolean create(ComunitatAutonoma comunitatAutonoma) throws SQLException {
        boolean addedApplication = false;

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
    public String read(long com_aut_id) throws SQLException {
        String value = null;

        PreparedStatement stmt = null;
        try {

            String sql = "SELECT comunitat_aut_id, nom, codi_ine FROM comunitats_autonomes WHERE comunitat_aut_id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, com_aut_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                value = "NOM: " + rs.getString("nom");
                value += "\nCODI_INE: " + rs.getString("codi_ine");
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



    public boolean update(ComunitatAutonoma ca) throws SQLException {
        boolean updatedCa = false;

        PreparedStatement stmt = null;
        try {


            // Construir la consulta SQL base
            StringBuilder sqlBuilder = new StringBuilder("UPDATE comunitats_autonomes SET");
            List<Object> parameters = new ArrayList<>();

            // Verificar y agregar los campos a actualizar
            if (ca.getNom() != null) {
                sqlBuilder.append(" nom = ?,");
                parameters.add(ca.getNom());
            }
            if (ca.getCodi_ine() != null) {
                sqlBuilder.append(" codi_ine = ?,");
                parameters.add(ca.getCodi_ine());
            }

            // Eliminar la última coma (,) y completar la cláusula WHERE
            sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
            sqlBuilder.append(" WHERE comunitat_aut_id = ?");
            parameters.add(ca.getComunitat_aut_id());

            // Crear la declaración preparada y establecer los parámetros
            stmt = con.prepareStatement(sqlBuilder.toString());
            for (int i = 0; i < parameters.size(); i++) {
                stmt.setObject(i + 1, parameters.get(i));
            }

            int quantity = stmt.executeUpdate();
            updatedCa = (quantity > 0);
        } catch (Exception e) {
            System.out.println("Error al actualizar la comunitat autonoma " + e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return updatedCa;
    }

    @Override
    public boolean delete(ComunitatAutonoma comunitatAutonoma) throws SQLException {
        boolean deleteCA = false;
        PreparedStatement stmt = null;
        try {

            String sql = "DELETE FROM comunitats_autonomes WHERE comunitat_aut_id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, comunitatAutonoma.getComunitat_aut_id());

            int quantity = stmt.executeUpdate();

             deleteCA = (quantity > 0);

        } catch (Exception e) {
            System.out.println("Error al borrar la comunitat autonoma " + e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return deleteCA;
    }
}
