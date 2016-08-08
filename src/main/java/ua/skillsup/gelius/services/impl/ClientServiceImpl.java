package ua.skillsup.gelius.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ClientDAO;
import ua.skillsup.gelius.dao.entities.Client;
import ua.skillsup.gelius.dto.ClientDto;
import ua.skillsup.gelius.services.ClientService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static ua.skillsup.gelius.converters.ClientDTOConverter.convert;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientDAO clientDao;

    @Override
    @Transactional(readOnly = true)
    public List<ClientDto> getAllClients() {
        List<ClientDto> result = new ArrayList<>();
        Collection<Client> clients = clientDao.findAll();
        for(Client client : clients) {
            result.add(convert(client));
        }

        return result;
    }

    @Override
    public ClientDto findById(Long id) {
        return null;
    }

    @Override
    public Long createClient(ClientDto client) {
        return null;
    }

    @Override
    public ClientDto editClient(ClientDto client) {
        return null;
    }

    @Override
    public boolean deleteClient(Long id) {
        return false;
    }

}
