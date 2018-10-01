/* 쿠키(cookie)
 * => 클라이언트에 보관하는 데이터이다.
 * => 문자열만 보관할 수 있다.
 *    다른 타입의 데이터를 보관하려면 문자열로 변환한 다음에 보관해야 한다.
 * => 서버로부터 쿠키를 받은 웹 브라우저는 
 *    다음에 서버에 요청할 때 그 쿠키를 다시 서버에 제시해야 한다.
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

@WebServlet("/ex10/servlet01_1")
public class Servlet01_1 extends  HttpServlet{
    private static final long serialVersionUID = 1L;
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        
        // 1) 쿠키 만들기
        Cookie c1 = new Cookie("name","Mandarine");
        Cookie c2 = new Cookie("age","12");
        Cookie c3 = new Cookie("working","true");
        // 2) 응답 헤더에 쿠키를 포함하기
        res.addCookie(c1);
        res.addCookie(c2);
        res.addCookie(c3);
        /* HTTP 응답 프로토콜 예)
         HTTP/1.1 200
Set-Cookie: name=Mandarine
Set-Cookie: age=12
Set-Cookie: working=true
Content-Type: text/html;charset=UTF-8
Content-Length: 138
Date: Mon, 01 Oct 2018 02:50:43 GMT
         */
        
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