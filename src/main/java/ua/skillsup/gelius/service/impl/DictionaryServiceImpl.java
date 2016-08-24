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
    public Map<String, List<?>> getAllDictionaries() {
        LOG.info("Get all dictionaries");

        Map<String, List<?>> result = new HashMap<>();

        for (String dictionaryName : dictionaries.keySet()) {

            ClassWithDTOPair classes = dictionaries.get(dictionaryName);

            Class<?> clazzEntity = classes.getClazz();
            Class<?> clazzDto = classes.getClazzDto();
            String fieldNameToDisplay = classes.getFieldNameToDisplay();

            List<?> listEntities = getEntitiesFromDictionary(clazzEntity, clazzDto, fieldNameToDisplay);
            result.put(dictionaryName, listEntities);
        }

        return result;
    }

    @Override
    public void editDictionary(String dictionary, String operation, Object object) {

    }

    private Map<String, ClassWithDTOPair> getDictionariesWithClasses() {
        Map<String, ClassWithDTOPair> dictionaries = new HashMap<>();

        dictionaries.put("client", new ClassWithDTOPair(Client.class, ClientDto.class, "companyName"));
        dictionaries.put("cardboardBrand", new ClassWithDTOPair(CardboardBrand.class, CardboardBrandDto.class, "cardboardBrand"));
        dictionaries.put("celluloseLayer", new ClassWithDTOPair(CelluloseLayer.class, CelluloseLayerDto.class, "celluloseLayer"));
        dictionaries.put("connectionValve", new ClassWithDTOPair(ConnectionValve.class, ConnectionValveDto.class, "connectionValve"));
        dictionaries.put("faceLayer", new ClassWithDTOPair(FaceLayer.class, FaceLayerDto.class, "faceLayer"));
        dictionaries.put("format", new ClassWithDTOPair(Format.class, FormatDto.class, "format"));
        dictionaries.put("innerLayer", new ClassWithDTOPair(InnerLayer.class, InnerLayerDto.class, "innerLayer"));
        dictionaries.put("packing", new ClassWithDTOPair(Packing.class, PackingDto.class, "packing"));
        dictionaries.put("pallet", new ClassWithDTOPair(Pallet.class, PalletDto.class, "pallet"));
        dictionaries.put("palletPlacement", new ClassWithDTOPair(PalletPlacement.class, PalletPlacementDto.class, "palletPlacement"));
        dictionaries.put("productType", new ClassWithDTOPair(ProductType.class, ProductTypeDto.class, "productType"));
        dictionaries.put("profile", new ClassWithDTOPair(Profile.class, ProfileDto.class, "profile"));
        dictionaries.put("workability", new ClassWithDTOPair(Workability.class, WorkabilityDto.class, "serviceCenter"));

        return dictionaries;
    }

    private <T, D> List<D> getEntitiesFromDictionary(Class<T> entityClazz, Class<D> dtoClazz, String fieldNameToDisplay) {

        List<D> result = new ArrayList<>();
        List<T> entities = dictionaryDao.getAll(entityClazz);
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
        private String fieldNameToDisplay;

        ClassWithDTOPair(Class<?> clazz, Class<?> clazzDto, String fieldNameToDisplay) {
            this.clazz = clazz;
            this.clazzDto = clazzDto;
            this.fieldNameToDisplay = fieldNameToDisplay;
        }

        Class<?> getClazz() {
            return clazz;
        }

        Class<?> getClazzDto() {
            return clazzDto;
        }

        public String getFieldNameToDisplay() {
            return fieldNameToDisplay;
        }
    }
}
