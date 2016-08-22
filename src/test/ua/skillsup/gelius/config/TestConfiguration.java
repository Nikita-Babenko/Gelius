package ua.skillsup.gelius.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.skillsup.gelius.dao.ProductDao;
import ua.skillsup.gelius.dao.ProductRegisterDao;
import ua.skillsup.gelius.dao.impl.ProductDaoImpl;
import ua.skillsup.gelius.dao.impl.ProductRegisterDaoImpl;
import ua.skillsup.gelius.service.ProductRegisterService;
import ua.skillsup.gelius.service.impl.ProductRegisterServiceImpl;

@Configuration
public class TestConfiguration {

    @Bean
    public ProductRegisterDao getProductRegisterDao(){
        return new ProductRegisterDaoImpl();
    }

    @Bean
    public ProductRegisterService getProductRegisterService() {
        return new ProductRegisterServiceImpl();
    }

    @Bean
    public ProductDao getProductDao(){
        return new ProductDaoImpl();
    }

}
