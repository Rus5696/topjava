package ru.javawebinar.topjava.to;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

public class MealTo extends BaseTo {

  @NotBlank
  private LocalDateTime dateTime;


  @NotBlank
  private String description;


  @Range(min = 10, max = 10000)
  @NotNull
  private int calories;

  public MealTo(Integer id, LocalDateTime dateTime, String description, int calories) {
    super(id);
    this.dateTime = dateTime;
    this.description = description;
    this.calories = calories;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getCalories() {
    return calories;
  }

  public void setCalories(int calories) {
    this.calories = calories;
  }
}
