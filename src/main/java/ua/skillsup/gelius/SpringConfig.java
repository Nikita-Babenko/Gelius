package ua.skillsup.gelius;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by yaroslav on 7/13/16.
 */
@Configuration
@PropertySource("classpath:config.properties")
@EnableTransactionManagement
public class SpringConfig {
    @Autowired
    private Environment env;

    private static final Logger log = LoggerFactory.getLogger(SpringConfig.class);

    @Bean
    public DataSource dataSource() {

        final HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(env.getProperty("sqldb.url"));
        hikariConfig.setUsername(env.getProperty("sqldb.username"));
        hikariConfig.setPassword(env.getProperty("sqldb.password"));

        return new HikariDataSource(hikariConfig);
    }

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        /*sessionFactory.setPackagesToScan(
                );*/
        sessionFactory.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));

        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new HibernateTransactionManager(sessionFactory().getObject());
    }
}
