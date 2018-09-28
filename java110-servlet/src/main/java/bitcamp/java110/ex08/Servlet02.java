/* 리프래시 방법
 * => 리프래시?
 *    - 클라이언트에서 자동으로 서버에 요청하게 만드는 기술
 * 
*/    
package bitcamp.java110.ex08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex08/servlet02")
public class Servlet02 extends  HttpServlet{
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
        
        
        out.println("<title>ex08!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet02 실행</h1>");
        out.println("</body>");
        out.println("</html>");
    }

}



