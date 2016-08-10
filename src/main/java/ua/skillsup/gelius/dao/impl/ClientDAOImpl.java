package ua.skillsup.gelius.dao.impl;

import org.springframework.stereotype.Repository;
import ua.skillsup.gelius.dao.ClientDAO;
import ua.skillsup.gelius.dao.HibernateGenericDAO;
import ua.skillsup.gelius.dao.entities.Client;

@Repository
public class ClientDAOImpl extends HibernateGenericDAO<Client, Long> implements ClientDAO<Client, Long> {

}
