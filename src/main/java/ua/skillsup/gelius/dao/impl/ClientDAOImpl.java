package ua.skillsup.gelius.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ClientDAO;
import ua.skillsup.gelius.dao.HibernateGenericDAO;
import ua.skillsup.gelius.dao.entities.Client;

@Repository
@Transactional
public class ClientDAOImpl extends HibernateGenericDAO<Client, Long> implements ClientDAO<Client, Long> {

}
