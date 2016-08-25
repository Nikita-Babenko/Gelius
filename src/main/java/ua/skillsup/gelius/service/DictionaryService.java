package ua.skillsup.gelius.service;

import java.util.List;
import java.util.Map;

public interface DictionaryService {

    Map<String, List<?>> getAllDictionaries();

    void editDictionary(String dictionary, String operation, Object object);

}
