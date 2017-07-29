package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.DateTimeUtil;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.web.meal.MealRestController;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Objects;

public class MealServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(MealServlet.class);
    ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
    private MealRestController mealRestController = appCtx.getBean(MealRestController.class);


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        if (request.getParameter("edit") != null) {
            String id = request.getParameter("id");

            Meal meal = new Meal(id.isEmpty() ? null : Integer.valueOf(id),
                    LocalDateTime.parse(request.getParameter("dateTime")),
                    request.getParameter("description"),
                    Integer.valueOf(request.getParameter("calories")));
            meal.setUserId(Integer.valueOf(request.getParameter("userId")));

            log.info(meal.isNew() ? "Create {}" : "Update {}", meal);
            if (meal.isNew())
                mealRestController.create(meal);
            else
                mealRestController.update(meal, meal.getId());
            response.sendRedirect("meals");
        } else if (request.getParameter("filter") != null) {
            log.info("filter");
            String startTimeStr = request.getParameter("startTime");
            LocalTime startTime = startTimeStr.isEmpty() ? LocalTime.MIN : LocalTime.parse(startTimeStr);


            String endTimeStr = request.getParameter("endTime");
            LocalTime endTime = endTimeStr.isEmpty() ? LocalTime.MAX : LocalTime.parse(endTimeStr);

            String startDateStr = request.getParameter("startDate");
            LocalDate startDate = startDateStr.isEmpty() ? LocalDate.MIN : LocalDate.parse(startDateStr);

            String endDateStr = request.getParameter("endDate");
            LocalDate endDate = endDateStr.isEmpty() ? LocalDate.MAX : LocalDate.parse(endDateStr);


            request.setAttribute("meals",
                    mealRestController.getFilteredByDateTime(startDate, endDate, startTime, endTime));
            request.getRequestDispatcher("/meals.jsp").forward(request, response);
        } else if (request.getParameter("resetFilter") != null){
            log.info("reset");
            request.setAttribute("meals", mealRestController.getAll());
            request.getRequestDispatcher("/meals.jsp").forward(request, response);
        } else if(request.getParameter("submitUserId") != null){
            AuthorizedUser.setId(Integer.valueOf(request.getParameter("userId")));
            response.sendRedirect("index.html");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action == null ? "all" : action) {
            case "delete":
                int id = getId(request);
                log.info("Delete {}", id);
                mealRestController.delete(id);
                response.sendRedirect("meals");
                break;
            case "create":
            case "update":
                final Meal meal = "create".equals(action) ?
                        new Meal(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), "", 1000) :
                        mealRestController.get(getId(request));
                request.setAttribute("meal", meal);
                request.getRequestDispatcher("/meal.jsp").forward(request, response);
                break;
            case "all":
            default:
                log.info("getAll");
                request.setAttribute("meals", mealRestController.getAll());
                request.getRequestDispatcher("/meals.jsp").forward(request, response);
                break;
        }
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}
