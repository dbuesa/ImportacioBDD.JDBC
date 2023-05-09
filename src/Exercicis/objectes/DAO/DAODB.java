package Exercicis.objectes.DAO;

import Exercicis.objectes.Persona;

import java.sql.SQLException;

public interface DAODB<T> {
    boolean create(T t) throws SQLException;
    boolean read(long id);
    boolean update(T t);
    boolean delete(T t);
}
