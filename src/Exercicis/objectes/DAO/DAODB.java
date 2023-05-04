package Exercicis.objectes.DAO;

public interface DAODB<T> {
    boolean create(T t);
    boolean read(T t);
    boolean update(T t);
    boolean delete(T t);
}
