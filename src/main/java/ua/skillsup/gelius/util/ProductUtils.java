package ua.skillsup.gelius.util;

import ua.skillsup.gelius.model.Data;

public final class ProductUtils {

    private ProductUtils() {
    }

    public static String getFullProductNumber(int productNumber, boolean isNewDatasheet) {
        int needLength = isNewDatasheet ? Data.ProductNumber.DIGITS_COUNT_NEW : Data.ProductNumber.DIGITS_COUNT_OLD;
        int currentLength = String.valueOf(productNumber).length();
        int delta = needLength - currentLength;
        StringBuilder value = new StringBuilder(productNumber);
        for (int i = 0; i < delta; i++) {
            value.append(Data.ProductNumber.PLACEHOLDER);
        }
        value.append(productNumber);
        return value.toString();
    }
}
