package ru.javawebinar.topjava.web.meal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealWithExceed;

@RestController
@RequestMapping(MealRestController.REST_URL)
public class MealRestController extends AbstractMealController {

  static final String REST_URL = "/rest/meals";

  @Override
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<MealWithExceed> getAll() {
    return super.getAll();
  }

  @Override
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Meal get(@PathVariable("id") int id) {
    return super.get(id);
  }

  @Override
  @DeleteMapping(value = "/{id}")
  public void delete(int id) {
    super.delete(id);
  }

  @Override
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Meal create(@RequestBody Meal meal) {
    return super.create(meal);
  }

  @Override
  public void update(Meal meal, int id) {
    super.update(meal, id);
  }

  @Override
  public List<MealWithExceed> getBetween(LocalDate startDate, LocalTime startTime,
      LocalDate endDate, LocalTime endTime) {
    return super.getBetween(startDate, startTime, endDate, endTime);
  }
}