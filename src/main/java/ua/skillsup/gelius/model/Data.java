package ua.skillsup.gelius.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Data {

    //Uploaded files:
    public static final String FILES_DIR = "PRODUCT_FILES";
    public static final Pattern ALLOWED_FILENAME_SYMBOLS = Pattern.compile(
        "[^a-zA-Zа-яА-ЯҐґЄєІіЇї0-9_\\+\\.\\,\\(\\)!@\\$=-]"
    );
    public static final String FILENAME_REPLACER = "_";
    public static final List<String> ALLOWED_FILE_EXTENSIONS = Arrays.asList(
        "pdf", "png", "jpg", "jpeg", "ai", "cdr"
    );
    public static final String FILENAME_SUFFIX = "_new";

    //Numbers of old and new datasheets - placeholder (padded from left) and number of digits:
    public class ProductNumber {
        public static final String PLACEHOLDER = "0";
        public static final int DIGITS_COUNT_NEW = 5;
        public static final int DIGITS_COUNT_OLD = 4;
    }

}
