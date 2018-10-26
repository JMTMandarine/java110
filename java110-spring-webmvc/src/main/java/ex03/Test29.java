// 인터셉터 다루기 - 프론트 컨트롤러와 "페이지 컨트롤러/JSP" 사이의 필터링 방법
package ex03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/ex03/test29")
@SessionAttributes({"name2","gender2"})  // 어떤 값을 session에 저장할지 선언해줌!
public class Test29 {
    
    // 인터셉터를 스프링에 등록하기
    // => XML 설정
    //    - /WEB-INF/app-servlet.xml 참고!
    // => Java Config 설정
    //    - 문서 참고!
    
    @GetMapping("m1")
    public void m1() throws Exception {
        System.out.println("Test29.m1()....");
    }
    
    @GetMapping("m2")
    public void m2() throws Exception {
        System.out.println("Test29.m2()....");
    }
    
    @GetMapping("ok/m3")
    public void m3() throws Exception {
        System.out.println("Test29.m3()....");
    }
    
    @GetMapping("no/m4")
    public void m4() throws Exception {
        System.out.println("Test29.m4()....");
    }
}




