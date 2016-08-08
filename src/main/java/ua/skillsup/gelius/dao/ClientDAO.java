package ua.skillsup.gelius.dao;

import ua.skillsup.gelius.dao.entities.Client;

import java.io.Serializable;


public interface ClientDAO<T, PK extends Serializable> extends GenericDAO<Client, PK> {

}
