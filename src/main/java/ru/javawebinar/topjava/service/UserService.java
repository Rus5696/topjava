package ru.javawebinar.topjava.service;


import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;
@Service
public interface UserService {

    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    void update(User user);

    List<User> getAll();
}