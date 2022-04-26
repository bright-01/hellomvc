package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-1")
    public ModelAndView responseView1(){
        return new ModelAndView("response/hello").addObject("data", "hello!");
    }

    // @ResponseBody 를 사용하면 바로 응답이 string으로 반환된다.
    @RequestMapping("/response-view-2")
    public String responseView2(Model model){
        model.addAttribute("data", "hello!");
        return "response/hello";
    }

    @RequestMapping("/response/hello") // Controller의 이름과 view의 논리적인 이름이 동일하면 void로 반환 할 수 있다.. 권장하지 않음.
    public void responseView3(Model model){
        model.addAttribute("data", "hello!");
    }
}
