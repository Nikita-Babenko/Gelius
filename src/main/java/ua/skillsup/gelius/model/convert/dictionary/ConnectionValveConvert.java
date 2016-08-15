package ua.skillsup.gelius.model.convert.dictionary;

import ua.skillsup.gelius.model.dto.dictionary.ConnectionValveDto;
import ua.skillsup.gelius.model.entity.dictionary.ConnectionValve;

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