package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 서블릿 자동 등록
@SpringBootApplication
public class ServletApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServletApplication.class, args);
  }

  // application.properties에 설정정보만 등록하면 자동등록됨
  //  @Bean
  //  ViewResolver internalResourceViewResolver() {
  //    return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp"); // JSP를 처리할 수 있는 뷰를 반환한다.
  //  }

  // 컴포넌트 스캔 대신 빈으로 직접 등록해도 됨.
  //  @Bean
  //  SpringMemberFormControllerV1 springMemberFormControllerV1() {
  //    return new SpringMemberFormControllerV1();
  //  }
}
