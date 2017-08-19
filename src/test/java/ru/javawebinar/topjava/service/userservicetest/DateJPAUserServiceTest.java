package ru.javawebinar.topjava.service.userservicetest;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.UserTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ruslan on 16.08.2017.
 */
@ActiveProfiles(Profiles.DATAJPA)
public class DateJPAUserServiceTest extends UserServiceTest{
    @Test
    public void testUserWithMeal(){
        User user = service.get(UserTestData.ADMIN_ID);

        List<Meal> mealsExpected = Arrays.asList(MealTestData.ADMIN_MEAL1, MealTestData.ADMIN_MEAL2);
        List<Meal> actual = user.getMeals();
        MealTestData.MATCHER.assertCollectionEquals(mealsExpected, actual);
        
    }
}
