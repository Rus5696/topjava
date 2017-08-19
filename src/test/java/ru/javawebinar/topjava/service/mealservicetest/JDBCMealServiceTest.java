package ru.javawebinar.topjava.service.mealservicetest;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.Profiles;

/**
 * Created by Ruslan on 16.08.2017.
 */
@ActiveProfiles({Profiles.JDBC, Profiles.JDBC_HSQLDB})
public class JDBCMealServiceTest extends MealServiceTest {
}
