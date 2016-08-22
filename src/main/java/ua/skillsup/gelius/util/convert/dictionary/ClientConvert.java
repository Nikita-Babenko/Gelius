package ua.skillsup.gelius.util.convert.dictionary;

import ua.skillsup.gelius.dao.entity.dictionary.Client;
import ua.skillsup.gelius.model.dto.dictionary.ClientDto;

public final class ClientConvert {

    private ClientConvert(){

    }

    public static Client convert(ClientDto clientDto) {
        if (clientDto == null) {
            return null;
        }
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setAddress(clientDto.getAddress());
        client.setCompanyName(clientDto.getCompanyName());
        client.setDescription(clientDto.getDescription());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setPhoneNumber(clientDto.getPhoneNumber());

        return client;
    }

    public static ClientDto convert(Client client) {
        if (client == null) {
            return null;
        }
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setAddress(client.getAddress());
        clientDto.setCompanyName(client.getCompanyName());
        clientDto.setDescription(client.getDescription());
        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(client.getLastName());
        clientDto.setPhoneNumber(client.getPhoneNumber());

        return clientDto;
    }
}
