package ua.skillsup.gelius.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.skillsup.gelius.dao.ProductRegisterDao;
import ua.skillsup.gelius.model.dto.ProductRegisterDto;
import ua.skillsup.gelius.model.dto.ProductRegisterFilter;
import ua.skillsup.gelius.service.ProductRegisterService;

import java.util.*;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductRegisterServiceImplTest {

    @Mock
    private ProductRegisterDao productRegisterDao;

    private ProductRegisterFilter productRegisterFilter = new ProductRegisterFilter();

    @InjectMocks
    private final static ProductRegisterService productRegisterService =  new ProductRegisterServiceImpl();

    @Before
    public void setUp() throws Exception {
        List<ProductRegisterDto> productList = new ArrayList<>();
        Map productMap = new HashMap<>();
        when(productRegisterDao.findAll()).thenReturn(Arrays.asList(new ProductRegisterDto(), new ProductRegisterDto()));
        when(productRegisterDao.findByFilter(productRegisterFilter)).thenReturn(productList);
        when(productRegisterDao.findAllFilterParameters(productRegisterFilter)).thenReturn(productMap);
    }

    @Test
    public void getAllProducts() throws Exception {
        productRegisterService.findAll();

        verify(productRegisterDao, times(1)).findAll();
    }

    @Test
    public void findByFilter() throws Exception {
        productRegisterService.findByFilter(productRegisterFilter);

        verify(productRegisterDao, times(1)).findByFilter(productRegisterFilter);
    }

    @Test
    public void findAllFilterParameters() throws Exception {
        productRegisterService.findAllFilterParameters(productRegisterFilter);

        verify(productRegisterDao, times(1)).findAllFilterParameters(productRegisterFilter);
    }

}