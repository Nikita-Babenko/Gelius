package ua.skillsup.gelius.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.model.dto.BigovkiDto;
import ua.skillsup.gelius.model.dto.PerforationDto;
import ua.skillsup.gelius.model.dto.ProducibilityNotesDto;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.model.dto.dictionary.*;
import ua.skillsup.gelius.util.ProductTestUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/mock-mvc-dispatcher-servlet.xml")
@Transactional
public class ProductDaoImplTest {

    @Autowired
    @InjectMocks
    private ProductDao productDao;

    @Autowired
    private ModelMapper modelMapper;

    private List<ProductDto> products;

    private List<Long> productIds;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        products = new ArrayList<ProductDto>(){{

            add(modelMapper.map(
                    ProductTestUtil
                            .createProduct(1, true, "Product 1", 2, 12, 200, 50, 140, 1),
                    ProductDto.class));

            add(modelMapper.map(
                    ProductTestUtil
                            .createProduct(1, false, "Product 2", 2, 15, 100, 75, 188, 1),
                    ProductDto.class));

            add(modelMapper.map(
                    ProductTestUtil
                            .createProduct(567, false,"Product 3", 1, 45, 324, 44, 124, 2),
                    ProductDto.class));

            add(modelMapper.map(
                    ProductTestUtil
                            .createProduct(14, true,"Product 4", 4, 8, 200, 89, 255,3),
                    ProductDto.class));

            add(modelMapper.map(
                    ProductTestUtil
                            .createProduct(45, false,"Product 5", 4, 8, 415, 30, 90,4),
                    ProductDto.class));

            add(modelMapper.map(
                    ProductTestUtil
                            .createProduct(2, false, "Product 6",2, 9, 200, 46, 145,5),
                    ProductDto.class));

            add(modelMapper.map(
                    ProductTestUtil
                            .createProduct(34, false,"Product 7", 3, 9, 200, 66, 167, 4),
                    ProductDto.class));

            add(modelMapper.map(
                    ProductTestUtil
                            .createProduct(223, true,"Product 8", 2, 200, 343, 11, 255, 3),
                    ProductDto.class));

            add(modelMapper.map(
                    ProductTestUtil
                            .createProduct(343, true,"Product 9", 1, 150, 333, 44, 255, 2),
                    ProductDto.class));
        }};


        productIds = new ArrayList<>();
        products.forEach(productDto -> productIds.add(productDao.save(productDto)));
    }

    @After
    public void tearDown() throws Exception {
        productIds.forEach(aLong -> productDao.delete(aLong));
    }

    @Test
    public void findAll() throws Exception {
        int productCountExpected = products.size();

        List<ProductDto> allProducts = productDao.findAll();

        assertEquals("Find all products in the database:", productCountExpected, allProducts.size());
    }

    @Test
    public void findAllProductsAfterSaveProduct() throws Exception {
        int productCountExpected = products.size() + 1;
        ProductDto productDto = modelMapper.map(
                ProductTestUtil
                        .createProduct(122, false, "Product 10", 2, 150, 230, 50, 100, 1),
                ProductDto.class);

        long id = productDao.save(productDto);
        List<ProductDto> allProducts = productDao.findAll();
        productDao.delete(id);

        assertEquals("Find all products after save singe Product", productCountExpected, allProducts.size());
    }


    @Test
    public void getMaxProductNumberAfterLessNumberForNewProduct() throws Exception {
        int maxBefore = 0;
        for (ProductDto productDto : products) {
            maxBefore = productDto.getProductNumber() > maxBefore && productDto.getIsNew() ? productDto.getProductNumber() : maxBefore;
        }
        ProductDto productDto = modelMapper.map(
                ProductTestUtil
                        .createProduct(222, true, "Product 10", 2, 150, 230, 50, 100, 1),
                ProductDto.class);

        long id = productDao.save(productDto);
        int maxProductNumber = productDao.getMaxNumberOfNewProduct();
        productDao.delete(id);

        assertEquals("Max number after save new product with number less, didn't changed", maxBefore, maxProductNumber);
    }

    @Test
    public void getMaxProductNumberAfterSaveMoreNumberForNewProduct() throws Exception {
        int maxBefore = 0;
        for (ProductDto productDto : products) {
            maxBefore = productDto.getProductNumber() > maxBefore && productDto.getIsNew() ? productDto.getProductNumber() : maxBefore;
        }
        ProductDto productDto = modelMapper.map(
                ProductTestUtil
                        .createProduct(555, true, "Product 10", 2, 333, 230, 50, 100, 1),
                ProductDto.class);

        long id = productDao.save(productDto);
        int maxProductNumber = productDao.getMaxNumberOfNewProduct();
        productDao.delete(id);

        assertNotEquals("Max number after save new product with number less, have changed", maxBefore, maxProductNumber);
    }

    @Test
    public void oldProductExist() throws Exception {
        ProductDto productDto = modelMapper.map(
                ProductTestUtil
                        .createProduct(1233, false, "Product 10", 2, 333, 230, 50, 100, 1),
                ProductDto.class);

        long id = productDao.save(productDto);
        boolean isExist = productDao.isOldProductExist(productDto.getProductNumber());
        productDao.delete(id);

        assertTrue("Old product is exist", isExist);
    }

    @Test
    public void oldProductIsNotExist() throws Exception {
        boolean isExist = productDao.isOldProductExist(11111);

        assertFalse("Old product isn't exist", isExist);
    }

    @Test
    public void findProductById() throws Exception {
        long productId = productIds.get(0);

        ProductDto productDto = productDao.findById(productId);

        assertEquals("Find product by id", productDto.getId(), new Long(productId));
    }

    @Test
    public void saveProductWithEmptyBigovkiAndPerforationsAndNotes() throws Exception {
        ProductDto productDto = ProductTestUtil.getProductDtoWithSpecificStaticValues(true);

        long id = productDao.save(productDto);
        ProductDto productDtoFromDatabase = productDao.findById(id);
        productDao.delete(id);

        assertTrue("Did product with id=" + id + "save", productDto.equals(productDtoFromDatabase));
    }

    @Test
    public void saveProductWithNotEmptyNotesAndEmptyPerforationsAndBigovki() throws Exception {
        ProductDto productDto = ProductTestUtil.getProductDtoWithSpecificStaticValues(true);

        List<ProducibilityNotesDto> notes = new ArrayList<>();
        ProducibilityNotesDto note = new ProducibilityNotesDto();
        note.setProduct(productDto);
        note.setNote("some note");
        notes.add(note);

        productDto.setProducibilityNotes(notes);

        long id = productDao.save(productDto);
        ProductDto productDtoFromDatabase = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Did product with id=" + id + "save", productDtoFromDatabase, productDto);

        assertEquals("Are bigovki sizes equal",
                    notes.size(), productDtoFromDatabase.getProducibilityNotes().size());

        for (int i = 0; i < productDtoFromDatabase.getProducibilityNotes().size(); i++) {
            assertEquals("Are producibility notes values equal",
                    productDtoFromDatabase.getProducibilityNotes().get(i).getNote(),
                    notes.get(i).getNote());
        }
    }


    @Test
    public void saveProductWithNotEmptyBigovkiAndEmptyPerforationsAndNotes() throws Exception {
        ProductDto productDto = ProductTestUtil.getProductDtoWithSpecificStaticValues(true);

        List<BigovkiDto> bigovki = new ArrayList<>();
        BigovkiDto bigovkiDto = new BigovkiDto();
        bigovkiDto.setProduct(productDto);
        bigovkiDto.setValue(4);
        bigovki.add(bigovkiDto);

        productDto.setBigovki(bigovki);

        long id = productDao.save(productDto);
        ProductDto productDtoFromDatabase = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Did product with id=" + id + "save", productDtoFromDatabase, productDto);

        assertEquals("Are bigovki sizes equal",
                    bigovki.size(), productDtoFromDatabase.getBigovki().size());

        for (int i = 0; i < productDtoFromDatabase.getProducibilityNotes().size(); i++) {
            assertEquals("Are bigovki values equal",
                    productDtoFromDatabase.getBigovki().get(i).getValue(),
                    bigovki.get(i).getValue());
        }
    }


    @Test
    public void saveProductWithNotEmptyPerforationsAndEmptyBigovkiAndNotes() throws Exception {
        ProductDto productDto = ProductTestUtil.getProductDtoWithSpecificStaticValues(true);

        List<PerforationDto> perforations = new ArrayList<>();

        PerforationDto perforation = new PerforationDto();
        perforation.setProduct(productDto);
        perforation.setValue(34d);
        perforations.add(perforation);

        productDto.setPerforations(perforations);

        long id = productDao.save(productDto);
        ProductDto productDtoFromDatabase = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Did product with id=" + id + "save", productDtoFromDatabase, productDto);

        assertEquals("Are perforations sizes equal",
                    perforations.size(), productDtoFromDatabase.getPerforations().size());

        for (int i = 0; i < productDtoFromDatabase.getProducibilityNotes().size(); i++) {
            assertEquals("Are perforations values equal",
                    productDtoFromDatabase.getPerforations().get(i).getValue(),
                    perforations.get(i).getValue());
        }
    }

    @Test
    public void deleteNewProductWithEmptyBigovkiAndNotesAndPerforations() throws Exception {
        ProductDto newProduct = ProductTestUtil.getProductDtoWithSpecificStaticValues(true);

        int countBefore = productDao.findAll().size();
        long id = productDao.save(newProduct);
        ProductDto deletedNewProduct = productDao.delete(id);
        int countAfter = productDao.findAll().size();

        assertEquals("Are two products(deleted and didn't delete) equal", deletedNewProduct, newProduct);
        assertEquals("The total number of products didn't change", countAfter, countBefore);
    }

    @Test
    public void deleteOldProductWithEmptyBigovkiAndNotesAndPerforations() throws Exception {
        ProductDto oldProduct = ProductTestUtil.getProductDtoWithSpecificStaticValues(false);

        oldProduct.setBigovki(new ArrayList<>());
        oldProduct.setProducibilityNotes(new ArrayList<>());
        oldProduct.setPerforations(new ArrayList<>());

        int countBefore = productDao.findAll().size();
        long id = productDao.save(oldProduct);
        ProductDto deletedOldProduct = productDao.delete(id);
        int countAfter = productDao.findAll().size();

        assertEquals("Are two products(deleted and didn't delete) equal", deletedOldProduct, oldProduct);
        assertEquals("The total number of products didn't change", countAfter, countBefore);
    }

    private ProductDto saveProduct(){
        ProductDto newProduct = ProductTestUtil.getProductDtoWithSpecificStaticValues(true);
        long id = productDao.save(newProduct);
        return productDao.findById(id);
    }

    @Test
    public void updateProductNumber() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setProductNumber(34);
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two numbers (updated and found) equal, after update productNumber",
                productAfterUpdate.getProductNumber(), productForUpdate.getProductNumber());
    }


    @Test
    public void updateIsNew() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setIsNew(false);
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two isNews (updated and found) equal, after update isNew",
                productAfterUpdate.getNew(), productForUpdate.getNew());
    }

    @Test
    public void updateCreateDate() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setProductCreateDate(LocalDate.of(2016, 4, 12));
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two create dates (updated and found) equal, after update create date",
                productAfterUpdate.getProductCreateDate(), productForUpdate.getProductCreateDate());
    }

    @Test
    public void updateUpdateDate() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setProductUpdateDate(LocalDate.of(2016, 5, 12));
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two create dates (updated and found) equal, after update create date",
                productAfterUpdate.getProductUpdateDate(), productForUpdate.getProductUpdateDate());
    }

    @Test
    public void updateClient() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setClient(new ClientDto(2L));
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two clents (updated and found) equal, after update client",
                productAfterUpdate.getClient().getId(), productForUpdate.getClient().getId());
    }

    @Test
    public void updateBlankFormat() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setBlankFormat(23);
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two blank formats (updated and found) equal, after update blank format",
                productAfterUpdate.getBlankFormat(), productForUpdate.getBlankFormat());
    }

    @Test
    public void updateProductName() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setProductName("Test");
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two product names (updated and found) equal, after update product name",
                productAfterUpdate.getProductName(), productForUpdate.getProductName());
    }


    @Test
    public void updateProductType() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setProductType(new ProductTypeDto(2L));
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two product types (updated and found) equal, after update product type",
                productAfterUpdate.getProductType().getId(), productForUpdate.getProductType().getId());
    }

    @Test
    public void updateInnerLength() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setInnerLength(3444);
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two product's inner lengths (updated and found) equal, after update product's inner length",
                productAfterUpdate.getInnerLength(), productForUpdate.getInnerLength());
    }

    @Test
    public void updateInnerWidth() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setInnerWidth(232);
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two product's inner widths (updated and found) equal, after update product's inner widths",
                productAfterUpdate.getInnerWidth(), productForUpdate.getInnerWidth());
    }

    @Test
    public void updateHeight() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setInnerHeight(554);
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two product's inner heights (updated and found) equal, after update product's inner heights",
                productAfterUpdate.getInnerHeight(), productForUpdate.getInnerHeight());
    }

    @Test
    public void updateProfile() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setProfile(new ProfileDto(2L));
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two profiles (updated and found) equal, after update profiles",
                productAfterUpdate.getProfile().getId(), productForUpdate.getProfile().getId());
    }

    @Test
    public void updateFormat() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setFormat(new FormatDto(2L));
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two formats (updated and found) equal, after update formats",
                productAfterUpdate.getProfile().getId(), productForUpdate.getProfile().getId());
    }

    @Test
    public void updateCardboardBrand() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setCardboardBrand(new CardboardBrandDto(2L));
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two cardboard brands (updated and found) equal, after update cardboard brand",
                productAfterUpdate.getCardboardBrand().getId(), productForUpdate.getCardboardBrand().getId());
    }

    @Test
    public void updateCelluloseLayer() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setCelluloseLayer(new CelluloseLayerDto(2L));
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two cellulose layers (updated and found) equal, after update cellulose layer",
                productAfterUpdate.getCelluloseLayer().getId(), productForUpdate.getCelluloseLayer().getId());
    }

    @Test
    public void updateFaceLayer() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setFaceLayer(new FaceLayerDto(2L));
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two face layers (updated and found) equal, after update face layer",
                productAfterUpdate.getFaceLayer().getId(), productForUpdate.getFaceLayer().getId());
    }

    @Test
    public void updateInnerLayer() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setInnerLayer(new InnerLayerDto(2L));
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two inner layers (updated and found) equal, after update face layer",
                productAfterUpdate.getInnerLayer().getId(), productForUpdate.getInnerLayer().getId());
    }

    @Test
    public void updateSpecialConditions() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setSpecialConditions("any conditions");
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two special conditions (updated and found) equal, after update special condition",
                productAfterUpdate.getSpecialConditions(), productForUpdate.getSpecialConditions());
    }

    @Test
    public void updateMaterial() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setMaterial("any material");
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two materials (updated and found) equal, after update material",
                productAfterUpdate.getMaterial(), productForUpdate.getMaterial());
    }

    @Test
    public void updateSizeWorkpieceLength() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setSizeWorkpieceLength(344);
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two workpiece lengths (updated and found) equal, after update workpiece length",
                productAfterUpdate.getSizeWorkpieceLength(), productForUpdate.getSizeWorkpieceLength());
    }

    @Test
    public void updateWorkpieceWidth() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setPackageWidth(123);
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two workpiece widths (updated and found) equal, after update workpiece width",
                productAfterUpdate.getSizeWorkpieceWidth(), productForUpdate.getSizeWorkpieceWidth());
    }

    @Test
    public void updateConnectionValve() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setConnectionValve(new ConnectionValveDto(2L));
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two connection valves (updated and found) equal, after update connection valve",
                productAfterUpdate.getConnectionValve().getId(), productForUpdate.getConnectionValve().getId());
    }

    @Test
    public void updateStamp() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setStamp("test");
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two stamps (updated and found) equal, after update stamp",
                productAfterUpdate.getStamp(), productForUpdate.getStamp());
    }

    @Test
    public void updateCliche() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setCliche("test");
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two cliches (updated and found) equal, after update cliche",
                productAfterUpdate.getCliche(), productForUpdate.getCliche());
    }

    @Test
    public void updatePacking() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setPacking(new PackingDto(2L));
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two packings (updated and found) equal, after update packing",
                productAfterUpdate.getPacking().getId(), productForUpdate.getPacking().getId());
    }

    @Test
    public void updateNumberInPack() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setNumberInPack(3);
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two numbers in pack (updated and found) equal, after update number in pack",
                productAfterUpdate.getNumberInPack(), productForUpdate.getNumberInPack());
    }

    @Test
    public void updateNumberInTransportPackage() throws Exception {
        ProductDto productForUpdate = saveProduct();
        productForUpdate.setNumberInTransportPackage(6);
        long id = productForUpdate.getId();

        productDao.update(productForUpdate);
        ProductDto productAfterUpdate = productDao.findById(id);
        productDao.delete(id);

        assertEquals("Are two number in transport package (updated and found) equal, after update number in transport package",
                productAfterUpdate.getNumberInTransportPackage(), productForUpdate.getNumberInTransportPackage());
    }
}