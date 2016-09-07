package ua.skillsup.gelius.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.DictionaryDao;

@Repository
@Transactional
public class DictionaryDaoImpl extends AbstractDictionaryDao implements DictionaryDao {
}
