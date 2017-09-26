package ru.javawebinar.topjava.util;

import java.util.StringJoiner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class ControllerUtil {

  public static ResponseEntity<String> createResponseEntityByBindingResult(BindingResult result) {

    StringJoiner joiner = new StringJoiner("<br>");
    result.getFieldErrors().forEach(
        fe -> {
          String msg = fe.getDefaultMessage();
          if (!msg.startsWith(fe.getField())) {
            msg = fe.getField() + ' ' + msg;
          }
          joiner.add(msg);
        });
    return new ResponseEntity<>(joiner.toString(), HttpStatus.UNPROCESSABLE_ENTITY);


  }
}