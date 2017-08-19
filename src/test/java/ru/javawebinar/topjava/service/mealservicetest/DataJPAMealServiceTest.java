package ru.javawebinar.topjava.service.mealservicetest;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.UserTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;

/**
 * Created by Ruslan on 16.08.2017.
 */
@ActiveProfiles(Profiles.DATAJPA)
public class DataJPAMealServiceTest extends MealServiceTest {

    @Test
    public void testGetMealWithUser(){
        Meal meal = service.get(MealTestData.ADMIN_MEAL1.getId(), UserTestData.ADMIN_ID);
        User actual = meal.getUser();
        UserTestData.MATCHER.assertEquals(UserTestData.ADMIN, actual);
    }
}
