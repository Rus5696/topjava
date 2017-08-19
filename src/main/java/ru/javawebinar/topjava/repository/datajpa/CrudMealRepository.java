package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Meal m WHERE m.id=:id AND m.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Transactional
    //@Modifying
    @Query("SELECT m FROM Meal m WHERE m.id=:id AND m.user.id=:userId")
    Meal get(@Param("id") int id, @Param("userId") int userId);

    //@Modifying
    @Query(name = Meal.ALL_SORTED)
    List<Meal> getAll(@Param("userId") int userId);

    //@Modifying
    @Query(name = Meal.GET_BETWEEN)
    List<Meal> getBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("userId") int userId);
}
