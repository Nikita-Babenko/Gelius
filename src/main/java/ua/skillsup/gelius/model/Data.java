package ua.skillsup.gelius.model;

import java.time.format.DateTimeFormatter;

public class Data {

    //DateTimeFormatter для указанных пользователем дат (согласно формату из HTML-поля INPUT:date):
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

}
