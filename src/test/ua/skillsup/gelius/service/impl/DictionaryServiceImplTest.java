package ua.skillsup.gelius.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.skillsup.gelius.dao.DictionaryDao;
import ua.skillsup.gelius.service.DictionaryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DictionaryServiceImplTest {

    @Mock
    private DictionaryDao dictionaryDao;

    @InjectMocks
    private DictionaryService dictionaryService = new DictionaryServiceImpl();

    @Before
    public void setUp() throws Exception {
        when(dictionaryDao.findAll(any())).thenReturn(new ArrayList<>());
    }

    @Test
    public void findAll() throws Exception {
        Map<String, List<?>> all = dictionaryService.findAll();
        int count = 13;

        verify(dictionaryDao, times(count)).findAll(any());
        assertEquals("get all dictionaries", all.size(), count);
    }

    @Test
    public void update() throws Exception {
        // Do nothing
    }

}