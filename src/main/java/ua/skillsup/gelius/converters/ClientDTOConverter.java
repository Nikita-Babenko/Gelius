package ua.skillsup.gelius.converters;

import ua.skillsup.gelius.dao.entities.Client;
import ua.skillsup.gelius.dto.ClientDto;

public final class ClientDTOConverter {

    private ClientDTOConverter() {

    }

    public static Client convert(ClientDto clientDTO) {
        if (clientDTO == null) {
            return null;
        }
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setDescription(clientDTO.getDescription());
        client.setLastName(clientDTO.getLastName());
        client.setAddress(clientDTO.getAddress());
        client.setCompanyName(clientDTO.getCompanyName());
        client.setFirstName(clientDTO.getFirstName());
        client.setPhoneNumber(clientDTO.getPhoneNumber());
        return client;
    }

    public static ClientDto convert(Client client) {
        if (client == null) {
            return null;
        }
        ClientDto clientDTO = new ClientDto();
        clientDTO.setId(client.getId());
        clientDTO.setDescription(client.getDescription());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setCompanyName(client.getCompanyName());
        clientDTO.setFirstName(client.getFirstName());
        clientDTO.setPhoneNumber(client.getPhoneNumber());
        return clientDTO;
    }

}
