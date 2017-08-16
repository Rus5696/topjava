package ru.javawebinar.topjava.service.userservicetest;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.Profiles;

/**
 * Created by Ruslan on 16.08.2017.
 */
@ActiveProfiles(Profiles.JDBC)
public class JDBCUserServiceTest extends UserServiceTest {
}
