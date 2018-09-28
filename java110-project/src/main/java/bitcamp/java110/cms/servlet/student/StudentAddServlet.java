package bitcamp.java110.cms.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

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
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>학생 관리</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>학생 등록 결과</h1>");
        
        try{
            studentDao.insert(s);
            out.println("<p>저장하셨습니다.</p>");
        } catch(Exception e) {
            e.printStackTrace();
            out.println("<p>이메일 등록 중 오류 방생!</p>");
        }
        out.printf("<button type='button' onclick='main()'>메인으로</button>");
        
        out.println("<script>");
        out.println("function main() {");
        out.printf("location.href = 'list'");
        out.println("}");
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
        
    }
    
    
}
