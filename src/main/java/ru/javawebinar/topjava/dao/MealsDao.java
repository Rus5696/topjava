package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.MealWithExceed;

import java.util.List;

/**
 * Created by Олег on 20.07.2017.
 */
public interface MealsDao {
    void add(MealWithExceed mealWithExceed);
    void delete(int id);
    MealWithExceed getById(int id);
    void update(MealWithExceed mealWithExceed);
    List<MealWithExceed> getList();
}
