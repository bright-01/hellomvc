package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequsetParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username = {}, age = {}", username, age);
        response.getWriter().write("OK");

    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username")String memberName, @RequestParam("age") int memberAge){
        log.info("username = {}, age = {}", memberName, memberAge);
        return "OK";
        // @Controller 면서 반환값이 String이면 OK라는 view를 찾게 된다.
        // String return 값을 바로 반환 하고 싶다면 @RestController로 바꿔도 되고 @ResponseBody를 추가하면 된다
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username, @RequestParam int age){
        // 변수명과 RequestParam명이 같으면 생략 가능
        log.info("username = {}, age = {}", username, age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4( String username, int age){ // 요청 파라미터와 변수의 이름이 같다면 @RequestParam도 생략 가능
        log.info("username = {}, age = {}", username, age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = true) String username,
                                       @RequestParam(required = false) int age){
        // username= << 이건 null 처리가 아니라 "" 처리라 required가 통과된다
        // int age 에 null이 들어 갈 수 없다.. 기본형이라 null을 넣으려면 Integer 자료형으로 사용해야함
        log.info("username = {}, age = {}", username, age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam( defaultValue = "guest") String username,
                                       @RequestParam( defaultValue = "-1") int age){
        // 빈문자열도 처리 해줌
        log.info("username = {}, age = {}", username, age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    /**
     *
     * 파라미터를 Map, MultiValueMap으로 조회할 수 있다.
     * @RequestParam Map ,
     * Map(key=value)
     * @RequestParam MultiValueMap
     * MultiValueMap(key=[value1, value2, ...] ex) (key=userIds, value=[id1, id2])
     * 파라미터의 값이 1개가 확실하다면 Map 을 사용해도 되지만, 그렇지 않다면 MultiValueMap 을 사용하자.
     * */
    public String requestParamMap(@RequestParam Map<String, Object> paramMap ){
        log.info("username = {}, age = {}", paramMap.get("username"), paramMap.get("age"));
        return "OK";
    }
}
