package ua.skillsup.gelius.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.skillsup.gelius.dao.DeltasDao;
import ua.skillsup.gelius.model.dto.BigovkiDeltasDto;
import ua.skillsup.gelius.model.dto.PerforationDeltasDto;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/mock-mvc-dispatcher-servlet.xml")
@Transactional
public class DeltasDaoImplTest {

    @Autowired
    private DeltasDao deltasDao;

    @Test
    public void testGetBigovkiDeltas() throws Exception {
        //G
        long profileId = 2;
        Double[] expectedDeltasList = {1.5, 2.0, 1.5};

        //W
        BigovkiDeltasDto deltas = this.deltasDao.getBigovkiDeltas(profileId);

        //T
        assertNotNull("Bigovki's deltas for nexisting profile must not be null", deltas);
        assertArrayEquals(
            "Bigovki's deltas are not equals",
            expectedDeltasList,
            new Double[] { deltas.getDelta1(), deltas.getDelta2(), deltas.getDelta3() }
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBigovkiDeltasWithNonExistingProfile() throws Exception {
        //G
        long profileIdNotExists = 42;

        //W
        BigovkiDeltasDto deltasNotExists = this.deltasDao.getBigovkiDeltas(profileIdNotExists);
    }

    @Test
    public void testGetPerforationDeltas() throws Exception {
        //G
        long profileId = 5;
        Double[] expectedDeltasList = {4.0, 8.0, 8.0, 4.0};

        //W
        PerforationDeltasDto deltas = this.deltasDao.getPerforationDeltas(profileId);

        //T
        assertNotNull("Perforations' deltas for nexisting profile must not be null", deltas);
        assertArrayEquals(
            "Perforations' deltas are not equals",
            expectedDeltasList,
            new Double[] { deltas.getDelta1(), deltas.getDelta2(), deltas.getDelta3(), deltas.getDelta4() }
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPerforationDeltasWithNonExistingProfile() throws Exception {
        //G
        long profileIdNotExists = 42;

        //W
        PerforationDeltasDto deltasNotExists = this.deltasDao.getPerforationDeltas(profileIdNotExists);
    }

}