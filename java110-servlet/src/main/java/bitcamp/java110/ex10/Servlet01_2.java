/* 쿠키(cookie) - 사용 범위 지정하기
 * => 쿠키의 사용 범위를 지정하면 해당 범위에 있는 URL을 요청할 때는
 *    웹브라우저가 쿠키를 보낸다.
*/    
package bitcamp.java110.ex10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex10/servlet01_2")
public class Servlet01_2 extends  HttpServlet{
    private static final long serialVersionUID = 1L;
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        
        // 1) 현재 경로에 한정
        //    "이 쿠키는 같은 경로(/ex10/**)의 서블릿을 요청할 때 보내 달라" 라고
        //    웹브라우저에게 지시하는 것이다.
        Cookie c1 = new Cookie("name","Mandarine");
        
        // 2) 웹 애플리케이션 전체 범위로 확장
        //    "이 쿠키는 전체 서블릿(/**)의 대해 무조건 보내 달라" 라고
        //    웹브라우저에게 지시하는 것이다.
        Cookie c2 = new Cookie("age","12");
        c2.setPath("/"); //ROOT범위로 지정's
        
        // 3) 현재 경로보다 더 좁히기
        //    "이 쿠키는 /ex10/a/b/**경로의 서블릿을 요청할 때만 보내 달라" 라고
        //    웹브라우저에게 지시하는 것이다.
        Cookie c3 = new Cookie("working","true");
        c3.setPath("/ex10/a/b");
        
        // 4) 응답 헤더에 쿠키를 포함하기
        res.addCookie(c1);
        res.addCookie(c2);
        res.addCookie(c3);
        
        /*HTTP/1.1 200
        Set-Cookie: name=Mandarine
        Set-Cookie: age=12; Path=/                       <== 경로정보가 추가
        Set-Cookie: working=true; Path=/ex10/a/b
        Content-Type: text/html;charset=UTF-8
        Content-Length: 138
        Date: Mon, 01 Oct 2018 03:17:47 GMT*/
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>ex10!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Cookie Result</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}


// 주의!
// => '+' 문자를 서버에 보낼 때 주의해야 한다.
// => URL에서 '+' 문자는 공백을 의미한다.
//    따라서 서버에서 값을 꺼내면(getParameter() 호출) 공백이 리턴된다.
// => '+' 문자를 서버에 보내려면 URL 인코딩 값을 보내야 한다.
//    즉 '%2B'를 보내야 한다.
// => 따라서 + 연산을 이 서블릿에 보내려면
//    http://localhost:8888/ex09/servlet01?a=100&b=80&op=%2b
//    위와 같이 URL을 보내야한다 + = %2b(ASCII코드)