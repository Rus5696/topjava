package ru.javawebinar.topjava.util;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;
import org.springframework.format.Formatter;

public class LocalDateFormatter implements Formatter<LocalDate> {

  @Override
  public LocalDate parse(String text, Locale locale) throws ParseException {
    return LocalDate.parse(text);
  }

  @Override
  public String print(LocalDate object, Locale locale) {
    return object.toString();
  }
}
