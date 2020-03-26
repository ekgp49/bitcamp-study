package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.RequestMapping;


@Component
public class LessonAddServlet {

  LessonService lessonService;

  public LessonAddServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }


  @RequestMapping("/lesson/add")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    Lesson lesson = new Lesson();
    for (Field field : Lesson.class.getDeclaredFields()) {
      for (String key : params.keySet()) {
        if (field.getName().equals(key)) {
          for (Method method : Lesson.class.getDeclaredMethods()) {
            if (method.getName().startsWith("set")
                && method.getName().toLowerCase().endsWith(key.toLowerCase())) {
              if (field.getType() == String.class) {
                method.setAccessible(true);
                method.invoke(lesson, params.get(key));
              } else if (field.getType() == int.class) {
                method.setAccessible(true);
                method.invoke(lesson, Integer.parseInt(params.get(key)));
              } else if (field.getType() == java.sql.Date.class) {
                method.setAccessible(true);
                method.invoke(lesson, Date.valueOf(params.get(key)));
              }
            }
          }
        }
      }
    }

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='2;url=/lesson/list'>");
    out.println("<title>수업 등록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>수업 등록</h1>");
    if (lessonService.add(lesson) > 0) {
      out.println("강의를 저장했습니다.");
    } else {
      out.println("저장에 실패했습니다.");
    }
    out.println("</body>");
    out.println("</html>");

  }
}
