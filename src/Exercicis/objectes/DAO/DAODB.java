package Exercicis.objectes.DAO;

import java.sql.SQLException;

public interface DAODB<T> {
    boolean create(T t) throws SQLException;
    boolean read(T t);
    boolean update(T t);
    boolean delete(T t);
}
