package bitcamp.java110.cms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request
            , HttpServletResponse response) 
            throws ServletException, IOException {
        
        
/*        //이거하면 뭐가 들어옵니까? 현재 어플리케이션의 경로를 알려줌. 
        // 질문) 그럼 어디서 쓰든 /java110-project를 가르키는지?
        String webAppRoot =request.getContextPath(); // 예) /java110-project
        */
        PrintWriter out = response.getWriter();
        
        out.println("<header>");
        out.println("<h1>비트 캠프</h1>");
        out.println("<ul>");
        out.printf("<li><a href='/student/list'>학생관리</a></li>\n");
        out.printf("<li><a href='/teacher/list'>강사관리</a></li>\n");
        out.printf("<li><a href='/manager/list'>매니저관리</a></li>\n");
        out.println("</ul>");
        out.println("</header>");
    }
    
}
