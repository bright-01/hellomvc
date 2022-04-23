package hello.springmvc.basic.requestmapping;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

// @Controller 는 반환값이 'String' 이면 뷰 이름으로 인식 된다. 그래서 뷰를 찾고 렌더링이 된다.
// @RestController는 반환값으로 뷰를 찾는 것이 아니라 HTTP 메시지 바디에 바로 입력!!
@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    // RequestMapping은 메서드와 상관없이 호출됨
    @RequestMapping(value = {"/hello-basic", "/hello-basic"}, method = RequestMethod.GET) // 두개씩 넣을 수 있음 배열로
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }

    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mapping-get-V2");
        return "ok";
    }


    /**
     * PathVariable 사용
     * 변수명이 같으면 생략가능
     * @PathVariable("userId") String userId --> @PathVariable userId
     * /mapping/userA
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("UserId") String data){
        log.info("mapping userId = {}", data);
        return "data";
    }
    // 위에꺼 변수명이랑 패스명이랑 같으면 생략가능 아래와 같이
    @GetMapping("/mapping/{userId}")
    public String mappingPath2(@PathVariable String userId){
        log.info("mapping userId = {}", userId);
        return "data";
    }


    /**
     * PathVariable 사용
     * @param userId
     * @param orderId
     * @return
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId){
        log.info("mappingPath userId = {}, orderId = ", userId, orderId);
        return "ok";
    }

    /**
     * 파라미터 추가 맵핑
     * params = "mode"
     * params = "!mode"
     * params = "mode=debug"
     * params = "mode != debug"
     * params = {"mode=debug", "data=good"}
     * @return
     */
    @GetMapping(value ="/mapping-param",  params = "mode=debug") // 파라미터에 모드라는 값이 디버그라고 들어와야 호출된다.
    public String mappingParam(){
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 파라미터 추가 맵핑
     * params = "mode"
     * params = "!mode"
     * params = "mode=debug"
     * params = "mode != debug"
     * params = {"mode=debug", "data=good"}
     * @return
     */
    @GetMapping(value ="/mapping-header",  params = "mode=debug") // 헤더에 mode 값이 debug라는 값이 있어야만 호출
    public String mappingHeader(){
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * HTTP 요청 Accept, produce
     * Accept 헤더 기반 Media Type
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = "text/html") // MediaType.APPLICATION_ 로 표시 가능
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }


}
