import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.skillsup.gelius.configs.HibernateConfig;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfig.class)

public class TestSimpleDBQuery {
    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void simpleQuery() {
        Session session = sessionFactory.openSession();
        BigInteger countOfRecords = (BigInteger) session.createSQLQuery("SELECT COUNT(*) FROM CLIENTS").uniqueResult();
        assertEquals("CLIENTS table should contain at least 1 record.", 1, countOfRecords.compareTo(BigInteger.ZERO));
    }

}