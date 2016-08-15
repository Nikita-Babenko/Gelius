package ua.skillsup.gelius.dao;

import java.io.Serializable;
import java.util.List;

public interface CommonDAO {

    public <T, PK extends Serializable> PK save(T object);

    public void delete(Object object);

    public <T, PK extends Serializable> T get(Class<T> type, PK id);

    public <T> T update(T object);

    public <T> List<T> getAll(Class<T> type);

}
