package ua.skillsup.gelius.dao;

import ua.skillsup.gelius.model.Client;

import java.io.Serializable;


public interface ClientDAO<T, PK extends Serializable> extends GenericDAO<Client, PK> {

}
