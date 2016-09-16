package ua.skillsup.gelius.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ProductFileUtilsTest {

    @Test
    public void addSuffixToFileNameWithOneDotInFileName() throws Exception {
        String result = ProductFileUtils.addSuffixToFileName("file.pdf");

        assertEquals("Add suffix to file name", result, "file_new.pdf");
    }

    @Test
    public void addSuffixToFileNameWithTwoDotsInFileName() throws Exception {
        String result = ProductFileUtils.addSuffixToFileName("file.pfg.pdf");

        assertEquals("Add suffix to file name", result, "file.pfg_new.pdf");
    }
}