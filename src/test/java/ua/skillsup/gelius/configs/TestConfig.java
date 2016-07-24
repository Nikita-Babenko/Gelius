package ua.skillsup.gelius.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.dao.impl.ProductDaoImpl;
import ua.skillsup.gelius.services.ProductServ;
import ua.skillsup.gelius.services.impl.ProductServImpl;

@Configuration
public class TestConfig {

    @Bean
    public ProductDao getProductDao() {
        return new ProductDaoImpl();
    }

    @Bean
    public ProductServ getProductSer() {
        return new ProductServImpl();
    }

}
