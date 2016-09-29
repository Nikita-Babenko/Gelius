package ua.skillsup.gelius.dao.impl;

import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.DeltasDao;
import ua.skillsup.gelius.dao.entity.BigovkiDeltas;
import ua.skillsup.gelius.dao.entity.PerforationDeltas;
import ua.skillsup.gelius.model.dto.BigovkiDeltasDto;
import ua.skillsup.gelius.model.dto.PerforationDeltasDto;

@Repository
@Transactional
public class DeltasDaoImpl implements DeltasDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BigovkiDeltasDto getBigovkiDeltas(long profileId) {
        System.out.println(profileId);
        BigovkiDeltas deltas = (BigovkiDeltas) this.sessionFactory.getCurrentSession().
            createQuery("select d from BigovkiDeltas d where d.profile.id = :profileId").
            setParameter("profileId", profileId).
            uniqueResult();
        return this.modelMapper.map(deltas, BigovkiDeltasDto.class);
    }

    @Override
    public PerforationDeltasDto getPerforationDeltas(long profileId) {
        PerforationDeltas deltas = (PerforationDeltas) this.sessionFactory.getCurrentSession().
            createQuery("select d from PerforationDeltas d where d.profile.id = :profileId").
            setParameter("profileId", profileId).
            uniqueResult();
        return this.modelMapper.map(deltas, PerforationDeltasDto.class);
    }
}
