package ru.javawebinar.topjava.repository;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;
@Repository
public interface MealRepository {
    Meal save(Meal Meal);

    boolean delete(int id);

    Meal get(int id);

    Collection<Meal> getAll();
}
