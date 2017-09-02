package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by Ruslan on 02.09.2017.
 */
@Controller
public class MealController  {
    @Autowired
    MealRestController mealRestController;

    @GetMapping("meals?action=delete&id={id}")
    public String delete(@PathVariable("id") int id){
        mealRestController.delete(id);
        return "redirect:meals";
    }

    @GetMapping("meals?action=update&id=${id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("meal", mealRestController.get(id));
        return "/mealForm.jsp";
    }
    @GetMapping("meals?action=create")
    public String create(Model model){
        model.addAttribute("meal", new Meal(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), "", 1000));
        return "/mealForm.jsp";
    }

    @PostMapping("meals?action=filter")
    public String filter(@RequestParam("startDate") LocalDate startDate,
                         @RequestParam("endDate") LocalDate endDate,
                         @RequestParam("startTime")LocalTime startTime,
                         @RequestParam("endTime") LocalTime endTime,
                         Model model){
        model.addAttribute("meals", mealRestController.getBetween(startDate, startTime, endDate, endTime));
        return "/meals.jsp";
    }

    @PostMapping("meals")
    public String save(@RequestParam("dateTime") LocalDateTime dateTime,
                       @RequestParam("description") String description,
                       @RequestParam("calories") int calories,
                       @RequestParam(value = "id", required = false) int id,
                       Model model){
        Meal meal = new Meal(
                dateTime,
                description,
                calories);

        if (id==0) {
            mealRestController.create(meal);
        } else {
            mealRestController.update(meal, id);
        }
        return "redirect:meals";
    }

    @GetMapping(value = "meals")
    public String users(Model model) {
        model.addAttribute("meals", mealRestController.getAll());
        return "meals";
    }
}
