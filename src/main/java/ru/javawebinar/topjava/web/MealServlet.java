package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.dao.MealsDao;
import ru.javawebinar.topjava.dao.MealsDaoMapImpl;
import ru.javawebinar.topjava.model.MealWithExceed;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Олег on 18.07.2017.
 */
public class MealServlet extends HttpServlet {
    private static String INSERT_OR_EDIT = "/mealEdit.jsp";
    private static String LIST_MEAL = "/meals.jsp";

    private final MealsDao mealsDao = new MealsDaoMapImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int mealId = Integer.parseInt(request.getParameter("mealId"));
            mealsDao.delete(mealId);
            forward = LIST_MEAL;
            request.setAttribute("mealsList", mealsDao.getList());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int mealId = Integer.parseInt(request.getParameter("mealId"));
            MealWithExceed meal = mealsDao.getById(mealId);
            request.setAttribute("meal", meal);
        } else if (action.equalsIgnoreCase("meals")){
            forward = LIST_MEAL;
            request.setAttribute("mealsList", mealsDao.getList());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        MealWithExceed meal = new MealWithExceed(
//                request.getParameter("firstName")
//        );
        int id = Integer.valueOf(request.getParameter("id"));
        LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("dateTime"));
        String description = request.getParameter("description");
        int calories=  Integer.valueOf(request.getParameter("calories"));
        boolean exceed= Boolean.valueOf(request.getParameter("exceed"));

        MealWithExceed meal = new MealWithExceed(id, dateTime, description, calories, exceed);

        mealsDao.update(meal);
        request.setAttribute("users", mealsDao.getList());
        RequestDispatcher view = request.getRequestDispatcher(LIST_MEAL);
        view.forward(request, response);
    }
}
