package ua.skillsup.gelius.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ua.skillsup.gelius.service.DictionaryService;

import java.util.HashMap;

import static org.mockito.Mockito.*;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/mock-mvc-dispatcher-servlet.xml")
public class DictionaryControllerTest {

    @Mock
    @Autowired
    private DictionaryService dictionaryService;

    @InjectMocks
    @Autowired
    private DictionaryController dictionaryController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAllDictionaries() throws Exception {
        when(dictionaryService.findAll()).thenReturn(new HashMap<>());

        dictionaryController.findAllDictionaries();

        verify(dictionaryService, times(1)).findAll();
    }

    @Test
    public void editDictionary() throws Exception {
        doNothing().when(dictionaryService).update(anyString(), anyString(), anyObject());

        dictionaryController.edit(anyString(), anyString(), anyObject());

        verify(dictionaryService, times(1)).update(anyString(), anyString(), anyObject());
    }


}