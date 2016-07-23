import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.skillsup.gelius.configs.HibernateConfig;
import ua.skillsup.gelius.services.ProductServ;


import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfig.class)

public class TestSimpleDBQuery {
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    ProductServ productServ;

    @Test
    public void simpleQuery(){
        Session session = sessionFactory.openSession();
        BigInteger actual = (BigInteger) session.createSQLQuery("SELECT 1").uniqueResult();
        BigInteger expected = BigInteger.valueOf(1);

        assertEquals(expected, actual);
    }

//It's test for Product service-method
    @Test
    public void getAllProducts(){
        assertEquals(5, productServ.getAllProducts().size());
    }
}