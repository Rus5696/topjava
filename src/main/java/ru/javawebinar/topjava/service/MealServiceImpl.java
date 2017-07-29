package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.DateTimeUtil;
import ru.javawebinar.topjava.util.ValidationUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;
@Service
public class MealServiceImpl implements MealService {
    @Autowired
    private MealRepository repository;


    @Override
    public Meal get(int id) {
        System.out.println(repository.get(id));
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<Meal> getAll() {
        return new ArrayList<>(repository.getAll());
    }

    @Override
    public List<Meal> getFilteredByDate(LocalDate start, LocalDate end) {
        return getAll().stream()
                .filter(meal -> DateTimeUtil.isBetween(meal.getDate(), start, end))
                .collect(Collectors.toList());
    }

    @Override
    public Meal save(Meal meal) {
        return repository.save(meal);
    }

    @Override
    public void update(Meal meal) {
        repository.save(meal);
    }

    @Override
    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }
}