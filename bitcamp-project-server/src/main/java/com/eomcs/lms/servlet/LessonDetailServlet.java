package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.RequestMapping;

@Component
public class LessonDetailServlet {

  LessonService lessonService;

  public LessonDetailServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @RequestMapping("/lesson/detail")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    int no = Integer.parseInt(params.get("no"));
    Lesson lesson = lessonService.get(no);
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>수업 정보</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>수업 정보</h1>");
    if (lesson != null) {
      out.printf("<p>번호: %d</p>\n", lesson.getNo());
      out.printf("<p>수업명: %s</p>\n", lesson.getTitle());
      out.printf("<p>설명: %s</p>\n", lesson.getDescription());
      out.printf("<p>시작일: %s</p>\n", lesson.getStartDate());
      out.printf("<p>종료일: %s</p>\n", lesson.getEndDate());
      out.printf("<p>총수업시간: %d</p>\n", lesson.getTotalHours());
      out.printf("<p>일수업시간: %d</p>\n", lesson.getDayHours());
      out.printf("<p><a href='/board/delete?no=%d'>삭제</a>\n", lesson.getNo());
      out.printf("<a href='/board/updateForm?no=%d'>변경</a>\n", lesson.getNo());
    } else {
      out.println("<p>해당 번호의 수업이 없습니다.</p>\n");
    }
    out.println("<p><a href='/lesson/list'>수업 리스트</p>");
    out.println("</body>");
    out.println("</html>");
  }
}
