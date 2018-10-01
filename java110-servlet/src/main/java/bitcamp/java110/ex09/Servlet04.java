/* 인클루드(include)
 * => 다른 서블릿으로 작업을 포함하는 기술
 *    일종의 함수를 호출 하듯이 다른 서블릿을 실행 한 후.
 *    돌아온다.
*/    
package bitcamp.java110.ex09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex09/servlet04")
public class Servlet04 extends  HttpServlet{
    private static final long serialVersionUID = 1L;
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>ex09!</title>");
        out.println("</head>");
        out.println("<body>");
        
        // 다른 서블릿의 실행을 포함한다.
        // => 다른 서블릿으로 실행을 위임한 후 그 서블릿의 실행이 끝난 후 다시 리턴된다.
        // forward()를 하면 이전 서블릿에서 버퍼로 출력한 내용이 제거되지만,
        // include()를 하면 이전 서블릿의 출력 내용이 유지된다.
        // 그래서 여러 서블릿의 출력 내용이 합쳐진다.
        RequestDispatcher rd =req.getRequestDispatcher("servlet05");
        
        rd.include(req, res);
        
        out.println("<h1>Servlet04</h1>");
        
        rd =req.getRequestDispatcher("servlet06");
        rd.include(req, res);
        
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