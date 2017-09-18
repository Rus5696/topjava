package ru.javawebinar.topjava.web.meal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import org.junit.Test;
import org.springframework.http.MediaType;
import ru.javawebinar.topjava.TestUtil;
import ru.javawebinar.topjava.web.AbstractControllerTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.javawebinar.topjava.UserTestData.ADMIN;
import static ru.javawebinar.topjava.UserTestData.MATCHER;
import static ru.javawebinar.topjava.UserTestData.USER;

public class MealRestControllerTest extends AbstractControllerTest {
  private static final String REST_URL = MealRestController.REST_URL + "/";

  @Test
  public void testGetAll() throws Exception{
    TestUtil.print(mockMvc.perform(get(REST_URL))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)));
  }

  @Test
  public void testGetBetween() throws Exception {
    String dateParams = "startDate=" + LocalDate.of(2015, Month.MAY, 29)
        + "&startTime=" + LocalTime.of(9, 0)
        + "&endDate=" + LocalDate.of(2015, Month.MAY, 30)
        + "&endTime="+  LocalTime.of(14, 0);
    mockMvc.perform(get(REST_URL + "getBetween?"+dateParams))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andDo(print());
  }

}
