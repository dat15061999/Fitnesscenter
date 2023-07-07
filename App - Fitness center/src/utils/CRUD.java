package utils;

import java.util.List;

public interface CRUD <T> {
    void create(T t);
    void delete(int id);
    void update(int id);
    void find();
    List<T> readFile();

    List<T> getAll();
}
