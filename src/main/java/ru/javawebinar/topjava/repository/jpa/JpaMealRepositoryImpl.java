package ru.javawebinar.topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaMealRepositoryImpl implements MealRepository {


    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Meal save(Meal meal, int userId) {
        if (meal.isNew()){
            User user = em.getReference(User.class, userId);
            meal.setUser(user);
            em.persist(meal);
            return meal;
        }else {
            return em.createQuery("UPDATE Meal m SET m.description=:description, m.calories=:calories, m.dateTime=:dateTime " +
                    "WHERE m.id=:id and m.user.id=:userId")
                    .setParameter("description", meal.getDescription())
                    .setParameter("calories", meal.getCalories())
                    .setParameter("dateTime", meal.getDateTime())
                    .setParameter("id", meal.getId())
                    .setParameter("userId", userId).executeUpdate()==1? meal: null;

        }
    }

    @Override
    @Transactional
    public boolean delete(int id, int userId) {
        return em.createQuery("DELETE FROM Meal m WHERE m.id=:id and m.user.id=:user_id")
        .setParameter("id", id)
        .setParameter("user_id", userId).executeUpdate()!=0;

    }

    @Override
    public Meal get(int id, int userId) {
        Meal meal = em.find(Meal.class, id);
        if (meal.getUser().getId()==userId)
            return meal;
        else
            return null;
    }

    @Override
    public List<Meal> getAll(int userId) {
        return em.createQuery("SELECT m FROM Meal m WHERE m.user.id=:userId ORDER BY m.dateTime DESC")
        .setParameter("userId", userId).getResultList();
    }

    @Override
    public List<Meal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return em.createQuery("select m FROM Meal m " +
                "WHERE m.user.id=:userId AND m.dateTime BETWEEN :startDate AND :endDate ORDER BY m.dateTime DESC ")
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .setParameter("userId", userId).getResultList();
    }
}