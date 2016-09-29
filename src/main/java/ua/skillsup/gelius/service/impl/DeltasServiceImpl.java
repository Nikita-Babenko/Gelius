package ua.skillsup.gelius.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.skillsup.gelius.dao.DeltasDao;
import ua.skillsup.gelius.model.dto.BigovkiDeltasDto;
import ua.skillsup.gelius.model.dto.PerforationDeltasDto;
import ua.skillsup.gelius.service.DeltasService;

@Service
public class DeltasServiceImpl implements DeltasService {

    @Autowired
    private DeltasDao deltasDao;

    @Override
    public BigovkiDeltasDto getBigovkiDeltas(long profileId) {
        return this.deltasDao.getBigovkiDeltas(profileId);
    }

    @Override
    public PerforationDeltasDto getPerforationDeltas(long profileId) {
        return this.deltasDao.getPerforationDeltas(profileId);
    }
}
