package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RequestMapping
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String header(HttpServletRequest request,
                         HttpServletResponse response,
                         HttpMethod httpMethod,
                         Locale locale, @RequestHeader MultiValueMap<String, String> headerMap,
                         @RequestHeader("host") String host,
                         @CookieValue(value = "myCookie", required = true) String cookie) {


        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);
        return "ok";
    }
}


/**
 *
 * MultiValueMap
 * MAP과 유사한데, 하나의 키에 여러 값을 받을 수 있다.
 * HTTP header, HTTP 쿼리 파라미터와 같이 하나의 키에 여러 값을 받을 때 사용한다.
 * keyA=value1&keyA=value2
 * MultiValueMap<String, String> map = new LinkedMultiValueMap();
 * map.add("keyA", "value1");
 * map.add("keyA", "value2");
 * //[value1,value2]
 * List<String> values = map.get("keyA");
 *
 */
