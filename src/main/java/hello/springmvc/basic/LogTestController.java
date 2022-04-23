package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(LogTestController.class);
// Slf4j 어노테이션이 자동으로 잡아줌. 위에 따로 로그를 선언해줄 필요 없다.


    @RequestMapping("/log-test")
    public String logTest(){
        String name = "spring!";

        System.out.println("name = " + name);

        // 이렇게 사용하면 로그 레벨과 상관없이 리소스를 이용한 연산이 이루어짐... 이렇게 + 연산자를 사용하면 안된다.
        log.trace("trace log = {}"+ name);

        log.trace("trace log = {}", name);
        log.info("info log = {}", name);
        log.debug("debug log = {}", name);
        log.warn("warn log = {}", name);
        log.error("error log = {}", name);

        return "ok";
    }


}
