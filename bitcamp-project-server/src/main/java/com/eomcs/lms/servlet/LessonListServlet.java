package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.RequestMapping;

@Component
public class LessonListServlet {

  LessonService lessonService;

  public LessonListServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @RequestMapping("/lesson/list")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    out.printf("<!DOCTYPE html>");
    out.printf("<html>");
    out.printf("<head>");
    out.printf("<meta charset='UTF-8'>");
    out.printf("<title>강의 리스트</title>");
    out.printf("</head>");
    out.printf("<body>");
    out.printf("<h1>강의 리스트</h1>");
    out.println("<a href='/lesson/addForm'>새 수업 등록하기</a>");
    out.printf("<table border='5'>");
    out.printf("<tr><th>번호</th><th>수업명</th><th>시작일 ~ 종료일</th><th>총강의시간</th></tr>");
    List<Lesson> lessons = lessonService.list();
    for (Lesson l : lessons) {
      out.printf("<tr><td>%d</td> "//
          + "<td><a href='/lesson/detail?no=%1$d'>%s</td> "//
          + "<td>%s ~ %s</td> "//
          + "<td>%d</td></tr>\n", //
          l.getNo(), l.getTitle(), l.getStartDate(), l.getEndDate(), l.getTotalHours());
    }
    out.printf("</table>");
    out.printf("</body>");
    out.printf("</html>");
  }
}
