// 요청 핸들러의 아규먼트 - 프론트 컨트롤러로부터 받을 수 있는 파라미터 값
package bitcamp.app2;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error")
public class ErrorController {

  @RequestMapping
  public ModelAndView error(HttpServletRequest request) {
    ModelAndView mv = new ModelAndView();
    mv.addObject("status", request.getAttribute("javax.servlet.error.status_code"));
    mv.addObject("reason", request.getAttribute("javax.servlet.error.message"));
    mv.setViewName("error2");
    return mv;
  }
}


