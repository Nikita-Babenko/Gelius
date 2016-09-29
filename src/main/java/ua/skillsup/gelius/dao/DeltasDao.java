package ua.skillsup.gelius.dao;

import ua.skillsup.gelius.model.dto.BigovkiDeltasDto;
import ua.skillsup.gelius.model.dto.PerforationDeltasDto;

public interface DeltasDao {
    BigovkiDeltasDto getBigovkiDeltas(long profileId);
    PerforationDeltasDto getPerforationDeltas(long profileId);
}
