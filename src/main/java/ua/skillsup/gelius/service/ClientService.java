package ua.skillsup.gelius.service;

import ua.skillsup.gelius.model.dto.ClientDto;

import java.util.List;

public interface ClientService {
    List<ClientDto> getAllClients();

    ClientDto findById(Long id);

    Long createClient(ClientDto client);

    ClientDto editClient(ClientDto client);

    boolean deleteClient(Long id);
}
