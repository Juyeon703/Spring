package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

  @RequestMapping("headers")
  public String headers(HttpServletRequest request, HttpServletResponse response, HttpMethod httpMethod, Locale locale,
                        @RequestHeader MultiValueMap<String, String> headerMap, @RequestHeader("host") String host,
                        @CookieValue(value = "myCookie", required = false) String cookie) {
    log.info("request={}", request); // org.apache.catalina.connector.RequestFacade@14261297
    log.info("response={}", response); // org.apache.catalina.connector.ResponseFacade@262036b6
    log.info("httpMethod={}", httpMethod); // GET
    log.info("locale={}", locale); // ko_KR
    log.info("headerMap={}", headerMap); // {content-type=[application/json], user-agent=[PostmanRuntime/7.30.0],
    // accept=[*/*], postman-token=[42eeb739-6819-4715-8a44-46945a95fddd], host=[localhost:8080],
    // accept-encoding=[gzip, deflate, br], connection=[keep-alive], content-length=[33]}
    log.info("header host={}", host); // localhost:8080
    log.info("myCookie={}", cookie); // null
    return "ok";
  }
}
