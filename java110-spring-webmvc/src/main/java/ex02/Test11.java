// @RequestMapping 다루기 : URL 다루기 4  
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ex02/test11")
public class Test11 {
    
    // 클래스에 URL을 지정 했으면, 메서드에도 @RequestMapping을 붙여야 한다.
    //
    // 테스트:
    //      http://localhost:8888/ex02/Test10.html
    
    @RequestMapping  //얘를 붙여야 메서드 호출이 가능
    @ResponseBody
    public String m1() {
        return "ex02.Test11.m1()";
    }
    
    
    
    
}
