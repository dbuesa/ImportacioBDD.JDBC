package exercicis.objectes.DAO;

import java.sql.SQLException;

public interface DAODB<T> {
    boolean create(T t) throws SQLException;
    String read(long id) throws SQLException;
    boolean update(T t) throws SQLException;
    boolean delete(T t) throws SQLException;
}
