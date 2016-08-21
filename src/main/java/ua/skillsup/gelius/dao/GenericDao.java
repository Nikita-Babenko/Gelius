package ua.skillsup.gelius.dao;

import java.io.Serializable;
import java.util.Collection;

public interface GenericDao<T, PK extends Serializable> {

    PK create(T newObject);

    T findById(PK id);

    Collection<T> findAll();

    T update(T object);

    boolean delete(T object);
}

