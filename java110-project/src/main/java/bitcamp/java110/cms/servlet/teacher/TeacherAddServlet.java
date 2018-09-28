package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@WebServlet("/teacher/add")
public class TeacherAddServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        TeacherDao teacherDao=
                (TeacherDao)this.getServletContext().getAttribute("teacherDao");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Teacher t=new Teacher();
        t.setName(request.getParameter("name"));
        t.setEmail(request.getParameter("email"));
        t.setPassword(request.getParameter("password"));
        t.setPay(Integer.parseInt(request.getParameter("pay")));
        t.setTel(request.getParameter("tel"));
        t.setSubjects(request.getParameter("subject"));
        
        try {
            teacherDao.insert(t);
            out.println("<p>저장하셨습니다.</p>");
        }catch(Exception e){
            out.println("<p>이메일 등록 중 오류 발생!</p>");
            e.printStackTrace();
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
