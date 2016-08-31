package ua.skillsup.gelius.service;

import java.util.List;
import java.util.Map;

public interface DictionaryService {

    Map<String, List<?>> findAll();

    void update(String dictionary, String operation, Object object);

}
