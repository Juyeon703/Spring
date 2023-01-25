package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


// @Controller 대신에 밑에 두개 써도됨
//@Component //컴포넌트 스캔을 통해 스프링 빈으로 등록
//@RequestMapping // RequestMappingHandlerMapping이 사용
@Controller // 내부에 @Component 애노테이션 있음, RequestMappingHandlerMapping이 사용
public class SpringMemberFormControllerV1 {

  @RequestMapping("/springmvc/v1/members/new-form")
  public ModelAndView process() {
    return new ModelAndView("new-form");
  }
}
