package ua.skillsup.gelius.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractCommonDao implements CommonDao {

    @Autowired
    private SessionFactory sessionFactory;

    public <T, PK extends Serializable> PK save(T object) {
        return (PK) sessionFactory.getCurrentSession().save(object);
    }

    public void delete(Object object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    public <T, PK extends Serializable> T get(Class<T> type, PK id) {
        return (T) sessionFactory.getCurrentSession().get(type, id);
    }

    public <T> T update(T object) {
        sessionFactory.getCurrentSession().update(object);
        return (object);
    }

    public <T> List<T> getAll(Class<T> type) {
        final Session session = sessionFactory.getCurrentSession();
        final Criteria crit = session.createCriteria(type);
        return crit.list();
    }
}
