/* HttpSession 보관소의 데이터 꺼내기
 *    
*/    
package bitcamp.java110.ex07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex07/servlet04")
public class Servlet04 extends  HttpServlet{
    private static final long serialVersionUID = 1L;
    
    public Servlet04() {
        System.out.println("ex07.Servlet02... 생성자 호출");
    }
    
    @Override
    public void init() throws ServletException {
        System.out.println("ex07.Servlet02.init()... init()호출");
    }
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("/ex07/servlet04 실행");
        
        // ServletContext의 저장된 값 꺼내기
        // => 먼저 ServletContext의 객체를 알아낸다.
        ServletContext sc= this.getServletContext();
        out.printf("ServletContext : aaa=%s\n", sc.getAttribute("aaa"));
        
        // HttpSession의 값 꺼내기
        HttpSession session = req.getSession();
        out.printf("ServletRequrest : ccc=%s\n", session.getAttribute("ccc"));
    }

}



