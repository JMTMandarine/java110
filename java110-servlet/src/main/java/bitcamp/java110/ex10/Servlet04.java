/* 쿠키(cookie) - 같은 경로의 서블릿이 쿠키를 받는 예
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

@WebServlet("/ex1xx/servlet04")
public class Servlet04 extends  HttpServlet{
    private static final long serialVersionUID = 1L;
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        
        Cookie[] cookies = req.getCookies();
        
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>ex10!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>쿠기 받기2</h1>");
        
        if(cookies !=null) {
            for(Cookie cookie : cookies) {
                out.printf("<p>%s=%s</p>\n", cookie.getName(), cookie.getValue());
            }
        }
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