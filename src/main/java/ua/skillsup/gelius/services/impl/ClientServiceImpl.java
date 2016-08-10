package ua.skillsup.gelius.services.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private static final Logger LOG = LoggerFactory.getLogger("ClientService");

    @Autowired
    ClientDAO clientDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ClientDto> getAllClients() {
        List<ClientDto> result = new ArrayList<>();
        Collection<Client> clients = clientDao.findAll();
        LOG.info("Find {} clients", clients.size());
        for(Client client : clients) {
            ClientDto clientDTO = modelMapper.map(client, ClientDto.class);
            result.add(clientDTO);
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
