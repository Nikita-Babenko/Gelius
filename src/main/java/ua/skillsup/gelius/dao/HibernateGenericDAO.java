package ua.skillsup.gelius.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

public abstract class HibernateGenericDAO<T, PK extends Serializable>
        implements GenericDAO<T, Long> {

    private Class<T> type;

    @Autowired
    private SessionFactory sessionFactory;

    public HibernateGenericDAO() {
        type = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public Long create(T entity) {
        return (Long) sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public T findById(Long id) {
        return (T) sessionFactory.getCurrentSession().load(type, id);
    }

    @Override
    public Collection<T> findAll() {
        return (Collection<T>) sessionFactory.getCurrentSession()
                .createQuery("from " + type.getName()).list();
    }

    @Override
    public T update(T object) {
        sessionFactory.getCurrentSession().saveOrUpdate(object);
        return object;
    }

    @Override
    public boolean delete(T object) {
        sessionFactory.getCurrentSession().delete(object);
        return true;
    }

}


