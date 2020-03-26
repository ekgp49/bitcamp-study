package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.RequestMapping;


@Component
public class LessonUpdateFormServlet {

  LessonService lessonService;

  public LessonUpdateFormServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @RequestMapping("/lesson/updateForm")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    Lesson lesson = lessonService.get(Integer.parseInt(params.get("no")));
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>수업 수정</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>수업 수정</h1>");
    out.println("<form action='/lesson/update'>");
    out.printf("수업번호: <input name='no' readonly type='text' value='%d'><br>\n", lesson.getNo());
    out.println("수업명: <input name='title' type='text'><br>\n");
    out.println("설명: <textarea name='description' rows='5' cols='60'></textarea><br/>\n");
    out.println("시작일: <input name='startDate' type='text'><br>\n");
    out.println("종료일: <input name='endDate' type='text'><br>\n");
    out.println("총강의시간: <input name='totalHours' type='text'><br>\n");
    out.println("일강의시간: <input name='dayHours' type='text'><br>\n");
    out.println("<button>등록</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");

  }
}
