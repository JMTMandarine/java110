package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.TeacherDao;

@WebServlet("/teacher/delete")
public class TeacherDeleteServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        TeacherDao teacherDao=
                (TeacherDao)this.getServletContext().getAttribute("teacherDao");
        int no = Integer.parseInt(request.getParameter("no"));
        
        
        try{
            teacherDao.delete(no); 
            response.sendRedirect("list");
        } catch(Exception e) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out=response.getWriter();
            
            response.setHeader("Refresh", "1;url=list");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>강사 관리</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>강사 삭제 오류</h1>");
            out.printf("<p>%s</p>",e.getMessage());
            out.println("<p>잠시 후 목록페이지로 자동이동됩니다.</p>");
            out.println("</body>");
            out.println("</html>");
        }
       
        
    }
    
}
