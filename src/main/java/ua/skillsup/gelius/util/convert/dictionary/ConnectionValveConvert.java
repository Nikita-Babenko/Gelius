package ua.skillsup.gelius.util.convert.dictionary;

import ua.skillsup.gelius.dao.entity.dictionary.ConnectionValve;
import ua.skillsup.gelius.model.dto.dictionary.ConnectionValveDto;

public final class ConnectionValveConvert {

    private ConnectionValveConvert() {
    }

    public static ConnectionValve convert(ConnectionValveDto connectionValveDto) {
        if (connectionValveDto == null) {
            return null;
        }
        ConnectionValve connectionValve = new ConnectionValve();
        connectionValve.setId(connectionValveDto.getId());
        connectionValve.setConnectionValve(connectionValveDto.getConnectionValve());

        return connectionValve;
    }

    public static ConnectionValveDto convert(ConnectionValve connectionValve) {
        if (connectionValve == null) {
            return null;
        }
        ConnectionValveDto connectionValveDto = new ConnectionValveDto();
        connectionValveDto.setId(connectionValve.getId());
        connectionValveDto.setConnectionValve(connectionValve.getConnectionValve());

        return connectionValveDto;
    }
}