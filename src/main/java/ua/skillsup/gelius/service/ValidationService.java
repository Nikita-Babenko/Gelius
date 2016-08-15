package ua.skillsup.gelius.service;

import java.util.List;

public interface ValidationService<T> {
    List<String> validation(T element);
}
