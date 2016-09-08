package ua.skillsup.gelius.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.model.dto.dictionary.*;
import ua.skillsup.gelius.service.ProductService;
import ua.skillsup.gelius.service.ValidationService;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock
    private ProductDao productDao;

    @Mock
    private ValidationService<ProductDto> validationService;

    @InjectMocks
    private ProductService productService = new ProductServiceImpl();

    private ProductDto productDto;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setIsNew(false);
        productDto.setProductNumber(1);
        productDto.setClient(new ClientDto(1L));
        productDto.setProductType(new ProductTypeDto(1L));
        productDto.setFormat(new FormatDto(1L));
        productDto.setProfile(new ProfileDto(1L));
        productDto.setCardboardBrand(new CardboardBrandDto(1L));
        productDto.setCelluloseLayer(new CelluloseLayerDto(1L));
        productDto.setFaceLayer(new FaceLayerDto(1L));
        productDto.setInnerLayer(new InnerLayerDto(1L));
        productDto.setConnectionValve(new ConnectionValveDto(1L));
        productDto.setPacking(new PackingDto(1L));
        productDto.setPallet(new PalletDto(1L));
        productDto.setPalletPlacement(new PalletPlacementDto(1L));
    }

    @Test
    public void save() throws Exception {
        when(validationService.validation(productDto)).thenReturn(new ArrayList<>());
        when(productDao.save(productDto)).thenReturn(1L);

        productService.save(productDto);

        verify(productDao, times(1)).save(productDto);
    }

    @Test
    public void getProductNumber() throws Exception {
        when(productDao.getMaxProductNumber()).thenReturn(1);

        int productNumber = productService.getProductNumber();

        verify(productDao, times(1)).getMaxProductNumber();
        assertEquals("Is equal", productNumber, 2);
    }

    @Test
    public void getFullProductNumberForNewProduct() throws Exception {
        String fullNumber = productService.getFullProductNumber(1, true);
        assertEquals("Get string for new Product with number 1", fullNumber, "00001");

        fullNumber = productService.getFullProductNumber(20, true);
        assertEquals("Get string for new Product with number 20", fullNumber, "00020");

        fullNumber = productService.getFullProductNumber(100, true);
        assertEquals("Get string for new Product with number 20", fullNumber, "00100");

        fullNumber = productService.getFullProductNumber(1000, true);
        assertEquals("Get string for new Product with number 20", fullNumber, "01000");

        fullNumber = productService.getFullProductNumber(10000, true);
        assertEquals("Get string for new Product with number 20", fullNumber, "10000");
    }

    @Test
    public void getFullProductNumberForOldProduct() throws Exception {
        String fullNumber = productService.getFullProductNumber(1, false);
        assertEquals("Get string for old Product with number 1", fullNumber, "0001");

        fullNumber = productService.getFullProductNumber(20, false);
        assertEquals("Get string for old Product with number 20", fullNumber, "0020");

        fullNumber = productService.getFullProductNumber(100, false);
        assertEquals("Get string for old Product with number 20", fullNumber, "0100");

        fullNumber = productService.getFullProductNumber(1000, false);
        assertEquals("Get string for old Product with number 20", fullNumber, "1000");
    }

    @Test
    public void findById() throws Exception {
        when(productDao.findById(1)).thenReturn(productDto);

        ProductDto product = productService.findById(1);

        verify(productDao, times(1)).findById(1);
        assertEquals("Is equal", product.getId(), productDto.getId());
    }

}