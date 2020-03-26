package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.RequestMapping;

@Component
public class LessonSearchServlet {

  LessonService lessonService;

  public LessonSearchServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @RequestMapping("/lesson/search")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    HashMap<String, Object> parameters = new HashMap<String, Object>();


    if (params.get("keyword") != "") {
      String keyword = params.get("keyword");
      parameters.put("title", keyword);
    }

    if (params.get("startDate") != "") {
      parameters.put("startDate", Date.valueOf(params.get("startDate")));
    }

    if (params.get("startDate") != "") {
      parameters.put("endDate", Date.valueOf(params.get("endDate")));
    }

    if (params.get("totalHours") != "") {
      parameters.put("totalHours", Integer.parseInt(params.get("totalHours")));
    }

    if (params.get("dayHours") != "") {
      parameters.put("dayHours", Integer.parseInt(params.get("dayHours")));
    }


    out.printf("<!DOCTYPE html>");
    out.printf("<html>");
    out.printf("<head>");
    out.printf("<meta charset='UTF-8'>");
    out.printf("<title>강의 검색 결과</title>");
    out.printf("</head>");
    out.printf("<body>");
    out.printf("<h1>강의 검색 결과</h1>");
    out.println("<a href='/lesson/list'>강의 리스트로 돌아가기</a>");
    out.printf("<table border='5'>");
    out.printf("<tr><th>번호</th><th>수업명</th><th>시작일 ~ 종료일</th><th>총강의시간</th><th>일강의시간</th></tr>");

    List<Lesson> lessons = lessonService.search(parameters);
    System.out.println(lessons.get(0));
    for (Lesson l : lessons) {
      out.printf("<tr><td>%d</td> "//
          + "<td><a href='/lesson/detail?no=%1$d'>%s</td> "//
          + "<td>%s ~ %s</td> "//
          + "<td>%d</td>"//
          + "<td>%d</td></tr>\n", //
          l.getNo(), l.getTitle(), l.getStartDate(), l.getEndDate(), l.getTotalHours(),
          l.getDayHours());
    }
    out.printf("</table>");
    out.printf("</body>");
    out.printf("</html>");
  }
}


