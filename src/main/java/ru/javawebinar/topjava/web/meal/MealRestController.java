package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;

import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.util.MealsUtil;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.checkIdConsistent;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNew;

@Controller
public class MealRestController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;



    public List<MealWithExceed> getFilteredByTime(List<Meal> meals, LocalTime startTime, LocalTime endTime) {
        log.info("getFilteredByTimeWithExceed");
        return MealsUtil.getFilteredWithExceeded(meals, startTime, endTime, MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }

    public List<MealWithExceed> getAll() {
        log.info("getAll");
        return MealsUtil.getWithExceeded(service.getAll(), MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }

    public List<MealWithExceed> getFilteredByDate(LocalDate start, LocalDate end) {
        log.info("getFilteredByTime");
        return MealsUtil.getWithExceeded(service.getFilteredByDate(start, end), MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }
    public List<MealWithExceed> getFilteredByDateTime(LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime) {
        log.info("getFilteredByTime");
        return MealsUtil.getFilteredWithExceededInOneReturn(service.getFilteredByDate(startDate, endDate),
                startTime,
                endTime,
                MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }

    public Meal get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public Meal create(Meal meal) {
        log.info("create {}", meal);
        checkNew(meal);
        return service.save(meal);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(Meal meal, int id) {
        log.info("update {} with id={}", meal, id);
        checkIdConsistent(meal, id);
        service.update(meal);
    }

    public void setAuthorizedUserId(int id){
        AuthorizedUser.id();
    }


}