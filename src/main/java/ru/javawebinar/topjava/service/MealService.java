package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDate;
import java.util.List;
@Service
public interface MealService {
    Meal get(int id);

    List<Meal> getAll();

    List<Meal> getFilteredByDate(LocalDate start, LocalDate end);

    Meal save(Meal meal);

    void update(Meal meal);

    void delete(int id);
}