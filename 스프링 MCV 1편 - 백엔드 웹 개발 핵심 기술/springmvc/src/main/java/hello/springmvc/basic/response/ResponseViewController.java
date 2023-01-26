package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

  @RequestMapping("/response-view-v1")
  public ModelAndView responseViewV1() {

    ModelAndView mav = new ModelAndView("response/hello").addObject("data", "hello!");
    return mav;
  }

  @RequestMapping("/response-view-v2")
  public String responseViewV2(Model model) {
    model.addAttribute("data", "hello!!");
    return "response/hello";
  }

  @RequestMapping("/response/hello") // 경로이름이랑 뷰 경로가 같다면 뷰 경로 생략가능하나 권장하진 않음
  public void responseViewV3(Model model) {
    model.addAttribute("data", "hello!!");
  }
}
