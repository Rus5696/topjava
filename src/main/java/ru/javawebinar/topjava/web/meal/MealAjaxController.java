package ru.javawebinar.topjava.web.meal;

import java.util.StringJoiner;
import javax.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.to.MealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import ru.javawebinar.topjava.util.ControllerUtil;
import ru.javawebinar.topjava.util.MealsUtil;

@RestController
@RequestMapping(value = "/ajax/profile/meals")
public class MealAjaxController extends AbstractMealController {

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MealWithExceed> getAll() {
        return super.getAll();
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @PostMapping
    public ResponseEntity<String> createOrUpdate(@Valid MealTo mealTo, BindingResult result) {
        System.out.println("");
        System.out.println("");
        System.out.println("asasa");
        System.out.println("");
        System.out.println("asas");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("aasasas");
        if (result.hasErrors()) {
            return ControllerUtil.createResponseEntityByBindingResult(result);
        }
        if (mealTo.isNew()) {
            super.create(MealsUtil.createNewFromTo(mealTo));
        } else {
            Meal meal = super.get(mealTo.getId());
            MealsUtil.updateFromTo(meal, mealTo);
            super.update(meal, meal.getId());
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @Override
    @PostMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MealWithExceed> getBetween(
            @RequestParam(value = "startDate", required = false) LocalDate startDate,
            @RequestParam(value = "startTime", required = false) LocalTime startTime,
            @RequestParam(value = "endDate", required = false) LocalDate endDate,
            @RequestParam(value = "endTime", required = false) LocalTime endTime) {
        return super.getBetween(startDate, startTime, endDate, endTime);
    }
}
