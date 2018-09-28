package bitcamp.java110.cms.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.StudentDao;

@WebServlet("/student/delete")
public class StudentDeleteServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        StudentDao studentDao= 
                (StudentDao)this.getServletContext().getAttribute("studentDao");
        int no = Integer.parseInt(request.getParameter("no"));
        
        
        try {
            studentDao.delete(no); 
            response.sendRedirect("list");
        } catch(Exception e) {
            response.setHeader("Refresh", "1;url=list");
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out=response.getWriter();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>학생 관리</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>학생 삭제 오류</h1>");
            out.printf("<p>%s</p>",e.getMessage());
            out.println("<p>잠시 후 목록페이지로 자동이동됩니다.</p>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }
    
    
}
