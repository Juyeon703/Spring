package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 이제 각 컨트롤러는 복잡한 dispatcher.forward() 를 직접 생성해서 호출하지 않아도 된다.
 * 단순히 MyView 객체를 생성하고 거기에 뷰 이름만 넣고 반환하면 된다.
 * ControllerV1 을 구현한 클래스와 ControllerV2 를 구현한 클래스를 비교해보면, 이 부분의 중복이 확실하게 제거된 것을 확인할 수 있다.
 */

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

  private Map<String, ControllerV2> controllerMap = new HashMap<>();

  public FrontControllerServletV2() {
    controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
    controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
    controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("FrontControllerServletV1.service");

    // /front-controller/v1/members
    String requestURI = request.getRequestURI();

    ControllerV2 controller = controllerMap.get(requestURI); // MemberListControllerV1()
    if (controller == null) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
      return;
    }

    MyView view = controller.process(request, response);
    view.render(request, response);
  }
}
