package ua.skillsup.gelius.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.dao.impl.ProductDaoImpl;
import ua.skillsup.gelius.services.ProductService;
import ua.skillsup.gelius.services.impl.ProductServiceImpl;

@Configuration
public class TestConfig {

    @Bean
    public ProductDao getProductDao() {
        return new ProductDaoImpl();
    }

    @Bean
    public ProductService getProductSer() {
        return new ProductServiceImpl();
    }

}
