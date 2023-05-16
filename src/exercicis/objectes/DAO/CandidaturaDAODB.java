package exercicis.objectes.DAO;

import exercicis.connexio.DBMySQLManager;
import exercicis.objectes.Candidatura;

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
                value =  "ELECCIO_ID: " + rs.getString("eleccio_id");
                value += "\nCODI_CANDIDATURA: " + rs.getString("codi_candidatura");
                value += "\nNOM CURT: " + rs.getString("nom_curt");
                value += "\nNOM_LLARG: " + rs.getString("nom_llarg");
                value += "\nCA_PROVINCIA: " + rs.getString("codi_acumulacio_provincia");
                value += "\nCA_CA: " + rs.getString("codi_acumulacio_ca");
                value += "\nCA_NACIONAL: " + rs.getString("codi_acumulacio_nacional");
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

    public boolean update(Candidatura candidatura) throws SQLException {
        boolean updatedCandidatura = false;

        PreparedStatement stmt = null;
        try {
            // Construir la consulta SQL base
            StringBuilder sqlBuilder = new StringBuilder("UPDATE candidatures SET");
            List<Object> parameters = new ArrayList<>();

            // Verificar y agregar los campos a actualizar
            if (candidatura.getCodi_candidatura() != null) {
                sqlBuilder.append(" codi_candidatura = ?,");
                parameters.add(candidatura.getCodi_candidatura());
            }
            if (candidatura.getNom_curt() != null) {
                sqlBuilder.append(" nom_curt = ?,");
                parameters.add(candidatura.getNom_curt());
            }
            if (candidatura.getNom_llarg() != null) {
                sqlBuilder.append(" nom_llarg = ?,");
                parameters.add(candidatura.getNom_llarg());
            }
            if (candidatura.getCodi_acumulacio_provincia() != null) {
                sqlBuilder.append(" codi_acumulacio_provincia = ?,");
                parameters.add(candidatura.getCodi_acumulacio_provincia());
            }
            if (candidatura.getCodi_acumulacio_ca() != null) {
                sqlBuilder.append(" codi_acumulacio_ca = ?,");
                parameters.add(candidatura.getCodi_acumulacio_ca());
            }
            if (candidatura.getCodi_acumulacio_nacional() != null) {
                sqlBuilder.append(" codi_acumulacio_nacional = ?,");
                parameters.add(candidatura.getCodi_acumulacio_nacional());
            }

            // Eliminar la última coma (,) y completar la cláusula WHERE
            sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
            sqlBuilder.append(" WHERE candidatura_id = ?");
            parameters.add(candidatura.getCandidatura_id());

            // Crear la declaración preparada y establecer los parámetros
            stmt = con.prepareStatement(sqlBuilder.toString());
            for (int i = 0; i < parameters.size(); i++) {
                stmt.setObject(i + 1, parameters.get(i));
            }

            int quantity = stmt.executeUpdate();
            updatedCandidatura = (quantity > 0);
        } catch (Exception e) {
            System.out.println("Error al actualizar la candidatura " + e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
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
        }
        return deleteCandidatura;
    }
}
