package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.MealWithExceed;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Олег on 20.07.2017.
 */
public class MealsDaoMapImpl implements MealsDao {
    Map<Integer, MealWithExceed> db = new ConcurrentHashMap<>();

    public MealsDaoMapImpl() {

        db.put(1,new MealWithExceed(1, LocalDateTime.now(), "desc", 100, false) );
        db.put(2,new MealWithExceed(2, LocalDateTime.now(), "desc", 100, false) );
        db.put(3,new MealWithExceed(3, LocalDateTime.now(), "desc", 100, true) );
    }

    @Override
    public void add(MealWithExceed mealWithExceed) {
        db.put(mealWithExceed.getId(), mealWithExceed);
    }

    @Override
    public void delete(int id) {
        db.remove(id);
    }

    @Override
    public MealWithExceed getById(int id) {
        return db.get(id);
    }

    @Override
    public void update(MealWithExceed mealWithExceed) {
        db.put(mealWithExceed.getId(), mealWithExceed);
    }

    @Override
    public List<MealWithExceed> getList() {
        return new ArrayList<>(db.values());
    }
}
