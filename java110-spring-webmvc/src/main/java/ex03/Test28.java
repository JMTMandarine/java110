// 세션 다루기 - @Modelttribute 애노테이션과 @SessionStatus
package ex03;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/ex03/test28")
@SessionAttributes({"name2","gender2"})  // 어떤 값을 session에 저장할지 선언해줌!
public class Test28 {
    // 테스트:
    // http://localhost:8888/app/ex03/test27/m1
    
    @GetMapping(value="m1",produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(Model model, HttpSession session) throws Exception {
        
        // 프론트 컨트롤러가 ServletRequest에 값 보관  + 세션에 보관,
        // => @SessionAttributes에 지정된 이름이기 때문이다.
        model.addAttribute("name2","만다린"); 
        model.addAttribute("gender2", "여자");
        
        // 프론트 컨트롤러가 ServletRequest에 값보관
        // 
        model.addAttribute("tel2", "1111-1111");
        session.setAttribute("age2", "20"); // 페이지 컨트롤러가 직접 세션에 보관 
        
        return "ex03.Test28.m1()";
    }
    
    @GetMapping(value="m2",produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(
            // @SessionAttributes에 지정된 값을 받고 싶을 때
            // 파라미터 변수에 @ModelAttribute(이름) 애노테이션을 붙여라.
            //
            // => @SessionAttributes에 나열된 이름일 경우,
            //    - 세션에 값이 있을 경우, 그 값을 파라미터에 주입해준다. 
            //    - 세션에 값이 없을 경우, 예외 발생!
            @ModelAttribute("name2") String name2,
            @ModelAttribute("gender2") String gender2,
            // => @SessionAtrributes에 나열된 이름이 아닐 경우,
            //    해당 파라미터에 빈 문자열이 주입된다.
            //    - 세션에 값이 있을 경우, 빈문자열을 주입해준다.
            
            @ModelAttribute("tel2") String tel2,
            //    - 세션에 값이 없을 경우, 빈문자열을 주입해준다.
            @ModelAttribute("age2") String age2
            //
            // !!! @SessionAttributes로 지정한 것은 꼭! @ModelAttribute로 받아야한다
            ) throws Exception {
        return String.format("%s, %s, %s, %s\n",name2,tel2,gender2, age2 );
    }

    @GetMapping(value="m3",produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m3(HttpSession session) throws Exception {
        
        String name2=(String)session.getAttribute("name2");
        String tel2=(String)session.getAttribute("tel2");
        String gender2=(String)session.getAttribute("gender2");
        String age2=(String)session.getAttribute("age2");
        
        return String.format("%s, %s, %s, %s\n",name2,tel2,gender2,age2 );
    }
    
    @GetMapping(value="m4",produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m4(
            // 다른 페이지 컨트롤러의 @SessionAttributes에서
            // 지정된 값을 받고 싶을 때?
            // 안된다. 현재 페이지 컨트롤러에서 지정한 이름의 값만 받을 수 있다.
            // 현재 페이지에서 지정한 값만 꺼내줌.
            @ModelAttribute("name") String name,
            @ModelAttribute("tel") String tel,
            @ModelAttribute("gender") String gender
            ) throws Exception {
        
        
        return String.format("%s, %s, %s\n",name,tel,gender );
    }
    
    @GetMapping(value="m5",produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m5(HttpSession session) throws Exception {
        // 다른 페이지 컨트롤러의 @SessionAttributes에서
        // 지정한 값을 HttpSession 객체에서 직접 꺼낼 때?
        // => 꺼낼 수 있다.
        String name=(String)session.getAttribute("name");
        String tel=(String)session.getAttribute("tel");
        String gender=(String)session.getAttribute("gender");
        
        return String.format("%s, %s, ,%s\n",name,tel,gender );
    }
    
    @GetMapping(value="m6",produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m6(Model model) throws Exception {
        return "ex03.Test28.m6()";
    }
    
    @GetMapping(value="logout1",produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String logout1(HttpSession session) throws Exception {
        
        session.invalidate();         // 다날림!
        return String.format("세션을 무효화시켰다!\n");
    }
    
    @GetMapping(value="logout2",produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String logout2(SessionStatus status) throws Exception {
        
        // 현재 이 request handler가 소속되어 있는 페이지 컨트롤러에서
        // @SessionAttributes에 지정된 값만 HttpSession에서 제거한다.
        // => 즉 name2, gender2만 제거된다.
        // => Test27 페이지 컨트롤러에서 관리되는 name,gender는 아니다.
        // => 기존의 HttpSession 객체는 계속 유효하다.
        // => HttpSession 객체에 직접 저장한 값도 계속 유효하다.
        status.setComplete();         // 이페이지에서 session값만 지운다. 다른페이지껀 지우지 않음.              
        return String.format("@SessionAttributes 관리 대상을 제거했다.\n");
    }
}

// HttpSession vs @SessionAttributes
// => 세션에 값을 저장할 때,
//    모든 페이지 컨트롤러에서 사용할 값이라면 HttpSession 객체에 직접 저장하라! 
//    특정 페이지 컨트롤러에서만 사용하고 관리될 값이라면 @SessionAttributes로 등록하라.
// => 값 제거
//    HttpSession.invalidate()는 세션을 완전히 무효화시킨다.
//    SessionStatus.setComplete()은 해당 페이지 컨트롤러의 
//    @SessionAttributes에 지정된 값만 세션 객체에서 제거한다.
//    setComplete은 세션을 무효화시키지 않는다.
//    "페이지 컨트롤러가 작업을 수행하기 위해 잠시 세션을 이용했는데,
//    작업이 완료되어서 세션에 잠시 보관된 값들을 제거하고 싶다!"
//    라는 의미이다.
//
// 회원가입정보?들을 받을때! setComplete()를 사용
// 로그아웃할때, session.invalidate()를 사용
//











