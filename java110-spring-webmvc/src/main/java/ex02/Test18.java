// HTTP 요청 헤더 알아내기
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ex02/test18")
public class Test18 {

    // 테스트:
    //      http://localhost:8888/ex02/Test17.html
    //@RequestMapping(value="m1", method=RequestMethod.GET)
    // 위에 애노테이션 대신 다음 애노테이션을 사용해도 된다.
    @RequestMapping(value="m1", produces="text/plain")
    @ResponseBody
    public String m1(
            @RequestHeader("User-Agent") 
            String userAgent,
            
            @RequestHeader(value="Context-Type",required=false)
            String contentType,
            
            @RequestHeader("Accept")
            String accept){
            
                return String.format("%s\n %s\n %s\n",
                                    userAgent,
                                    contentType,
                                    accept);
            }

}
