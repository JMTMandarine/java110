package bitcamp.java110.cms.servlet.student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@WebServlet("/student/add")
public class StudentAddServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        Student s=new Student();
        StudentDao studentDao= 
                (StudentDao)this.getServletContext().getAttribute("studentDao");
        request.setCharacterEncoding("UTF-8");
        
        s.setName(request.getParameter("name"));
        s.setEmail(request.getParameter("email"));
        s.setPassword(request.getParameter("password"));
        s.setTel(request.getParameter("tel"));
        s.setSchool(request.getParameter("school"));
        s.setWorking(Boolean.parseBoolean(request.getParameter("working")));
        
        
        try{
            studentDao.insert(s);
            response.sendRedirect("list");
        } catch(Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("/error");
            
            request.setAttribute("error", e);
            request.setAttribute("message", "학생 등록오류!");
            request.setAttribute("refresh", "3;url=list");
            
            rd.forward(request, response);
        }
        
        
    }
    
    
}
