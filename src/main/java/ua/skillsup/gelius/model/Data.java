package ua.skillsup.gelius.model;

import java.time.format.DateTimeFormatter;

public class Data {

    //DateTimeFormatter for dates (according to HTML-field INPUT:date format):
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static final String FILES_DIR = "PRODUCT_FILES";

    //Numbers of old and new datasheets - placeholder (padded from left) and number of digits:
    public class ProductNumber {
        public static final String PLACEHOLDER = "0";
        public static final int DIGITS_COUNT_NEW = 5;
        public static final int DIGITS_COUNT_OLD = 4;
    }

}
