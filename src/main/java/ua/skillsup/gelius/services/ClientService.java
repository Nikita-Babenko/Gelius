package ua.skillsup.gelius.services;

import ua.skillsup.gelius.dto.ClientDto;

import java.util.List;

public interface ClientService {
    List<ClientDto> getAllClients();

    ClientDto findById(Long id);

    Long createClient(ClientDto client);

    ClientDto editClient(ClientDto client);

    boolean deleteClient(Long id);
}
