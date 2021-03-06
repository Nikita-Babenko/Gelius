package ua.skillsup.gelius.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.DictionaryDao;
import ua.skillsup.gelius.dao.entity.dictionary.*;
import ua.skillsup.gelius.model.dto.dictionary.*;
import ua.skillsup.gelius.service.DictionaryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DictionaryServiceImpl implements DictionaryService {

    private static final Logger LOG = LoggerFactory.getLogger("DictionaryService");

    private Map<String, ClassWithDTOPair> dictionaries = getDictionariesWithClasses();

    @Autowired
    private DictionaryDao dictionaryDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Map<String, List<?>> findAll() {
        LOG.info("Get all dictionaries");

        Map<String, List<?>> result = new HashMap<>();

        for (String dictionaryName : dictionaries.keySet()) {

            ClassWithDTOPair classes = dictionaries.get(dictionaryName);

            Class<?> clazzEntity = classes.getClazz();
            Class<?> clazzDto = classes.getClazzDto();

            List<?> listEntities = getEntitiesFromDictionary(clazzEntity, clazzDto);
            result.put(dictionaryName, listEntities);
        }

        return result;
    }

    @Override
    public void update(String dictionary, String operation, Object object) {
    }

    private Map<String, ClassWithDTOPair> getDictionariesWithClasses() {
        Map<String, ClassWithDTOPair> dictionaries = new HashMap<>();

        dictionaries.put("client", new ClassWithDTOPair(Client.class, ClientDto.class));
        dictionaries.put("cardboardBrand", new ClassWithDTOPair(CardboardBrand.class, CardboardBrandDto.class));
        dictionaries.put("celluloseLayer", new ClassWithDTOPair(CelluloseLayer.class, CelluloseLayerDto.class));
        dictionaries.put("connectionValve", new ClassWithDTOPair(ConnectionValve.class, ConnectionValveDto.class));
        dictionaries.put("faceLayer", new ClassWithDTOPair(FaceLayer.class, FaceLayerDto.class));
        dictionaries.put("format", new ClassWithDTOPair(Format.class, FormatDto.class));
        dictionaries.put("innerLayer", new ClassWithDTOPair(InnerLayer.class, InnerLayerDto.class));
        dictionaries.put("packing", new ClassWithDTOPair(Packing.class, PackingDto.class));
        dictionaries.put("pallet", new ClassWithDTOPair(Pallet.class, PalletDto.class));
        dictionaries.put("palletPlacement", new ClassWithDTOPair(PalletPlacement.class, PalletPlacementDto.class));
        dictionaries.put("productType", new ClassWithDTOPair(ProductType.class, ProductTypeDto.class));
        dictionaries.put("profile", new ClassWithDTOPair(Profile.class, ProfileDto.class));
        dictionaries.put("producibility", new ClassWithDTOPair(Producibility.class, ProducibilityDto.class));

        return dictionaries;
    }

    private <T, D> List<D> getEntitiesFromDictionary(Class<T> entityClazz, Class<D> dtoClazz) {

        List<D> result = new ArrayList<>();
        List<T> entities = dictionaryDao.findAll(entityClazz);
        for (T entity : entities) {
            result.add(converEntityToDto(entity, dtoClazz));
        }

        return result;
    }

    private <D> D converEntityToDto(Object entity, Class<D> clazzDto) {
        D entityDto = null;
        try {
            entityDto = (D) clazzDto.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            LOG.error("Error when convert {} is : {}", entity, ex);
        }
        if (entityDto != null) {
            modelMapper.map(entity, entityDto);
        }
        return entityDto;
    }

    private class ClassWithDTOPair {
        private Class<?> clazz;
        private Class<?> clazzDto;

        ClassWithDTOPair(Class<?> clazz, Class<?> clazzDto) {
            this.clazz = clazz;
            this.clazzDto = clazzDto;
        }

        Class<?> getClazz() {
            return clazz;
        }

        Class<?> getClazzDto() {
            return clazzDto;
        }

    }
}
