package ua.skillsup.gelius.service;

import ua.skillsup.gelius.model.dto.BigovkiDeltasDto;
import ua.skillsup.gelius.model.dto.PerforationDeltasDto;

public interface DeltasService {
    BigovkiDeltasDto getBigovkiDeltas(long profileId);
    PerforationDeltasDto getPerforationDeltas(long profileId);
}
