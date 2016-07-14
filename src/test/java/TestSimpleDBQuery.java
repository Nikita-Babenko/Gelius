import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.skillsup.gelius.SpringConfig;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)

public class TestSimpleDBQuery {
    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void simpleQuery(){
        Session session = sessionFactory.openSession();     // Test returns true if we have only three records in table CLIENTS
        BigInteger actual = (BigInteger) session.createSQLQuery("SELECT COUNT(*) FROM CLIENTS").uniqueResult();
        BigInteger expected = BigInteger.valueOf(3);

        assertEquals(expected, actual);
    }

}
