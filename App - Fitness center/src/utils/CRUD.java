package utils;

import java.util.List;
import java.util.Objects;

public interface CRUD <T> {
    void create(T t);
    void delete(int id);
    void update(int id);
    List<T> readFile();

    void getAll();
}
