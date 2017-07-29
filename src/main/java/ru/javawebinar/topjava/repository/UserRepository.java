package ru.javawebinar.topjava.repository;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;

import java.util.List;
@Repository
public interface UserRepository {
    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User get(int id);

    // null if not found
    User getByEmail(String email);

    List<User> getAll();
}