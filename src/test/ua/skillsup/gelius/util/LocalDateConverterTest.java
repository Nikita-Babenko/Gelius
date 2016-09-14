package ua.skillsup.gelius.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LocalDateConverterTest {

    private LocalDate currentDate = LocalDate.now();

    private LocalDateConverter localDateConverter = new LocalDateConverter();

    @Test
    public void ifConvertToEntityAttribute() throws Exception {
        Date firstDate = Date.valueOf(currentDate);

        LocalDate localDate = localDateConverter.convertToEntityAttribute(firstDate);
        Date secondDate = Date.valueOf(localDate);

        assertEquals("if 2 java.sql.Date's equals ", secondDate, firstDate);
    }


    @Test
    public void ifPassedLocalDateIsNull() throws Exception {
        LocalDate localDate = localDateConverter.convertToEntityAttribute(null);

        assertEquals("if passed LocalDate is null", localDate, null);
    }

    @Test
    public void ifConvertToDatabaseColumn() throws Exception {
        LocalDate firstDate = currentDate;

        Date date = localDateConverter.convertToDatabaseColumn(firstDate);
        LocalDate secondDate = date.toLocalDate();

        assertEquals("if 2 java.time.LocalDate's equals ", secondDate, firstDate);
    }

    @Test
    public void ifPassedDateIsNull() throws Exception {
        Date date = localDateConverter.convertToDatabaseColumn(null);

        assertEquals("if passed sql Date is null", date, null);
    }
}