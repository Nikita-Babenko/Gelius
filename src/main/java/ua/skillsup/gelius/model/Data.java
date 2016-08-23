package ua.skillsup.gelius.model;

import java.time.format.DateTimeFormatter;

public class Data {

    //DateTimeFormatter для указанных пользователем дат (согласно формату из HTML-поля INPUT:date):
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    //Displaying string for "empty" dictionary's element:
    public static final String DICTIONARY_EMPTY_ELEMENT_VALUE = "[не выбрано]";

    //Номера новых и старых техкарт - заполнитель (дополняет слева) и количество цифр:
    public class ProductNumber {
        public static final String PLACEHOLDER = "0";
        public static final int DIGITS_COUNT_NEW = 5;
        public static final int DIGITS_COUNT_OLD = 4;
    }

}
