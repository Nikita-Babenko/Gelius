package ua.skillsup.gelius.service;

import java.time.LocalDate;
import java.util.List;

public interface ValidationService<T> {

    List<String> validation(T element);

    LocalDate parseDate(String dateValue);

}
