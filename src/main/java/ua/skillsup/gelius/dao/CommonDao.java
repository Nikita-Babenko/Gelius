package ua.skillsup.gelius.dao;

import java.io.Serializable;
import java.util.List;

public interface CommonDao {

    <T, PK extends Serializable> PK save(T object);

    void delete(Object object);

    <T, PK extends Serializable> T get(Class<T> type, PK id);

    <T> T update(T object);

    <T> List<T> getAll(Class<T> type);

}
