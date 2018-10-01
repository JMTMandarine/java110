package bitcamp.java110.cms.servlet.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Member;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) 
                    throws ServletException, IOException {
        String email="";
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for(Cookie cookie : cookies ) {
                if(cookie.getName().equals("email")) {
                    email = cookie.getValue();
                    break;
                }
            }
        }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("        <html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>로그인</title>");
        out.println("<style>");
        out.println("th{");
        out.println("text-align: right;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>로그인</h1>");
        out.println("<form action='login' method='post'>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th></th>");
        out.println("<td>");
        out.println("<input type='radio' name='type' value='student' checked>학생");
        out.println("        <input type='radio' name='type' value='teacher'>강사");
        out.println("<input type='radio' name='type' value='manager'>매니저");
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<th>이메일</th>");
        out.printf("<td><input type='email' name='email' value=%s></td>\n",email);
        out.println("</tr>");
        out.println("<tr>");
        out.println("<th>암호</th>");
        out.println("<td><input type='password' name='password'></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<th></th>");
        out.println("<td><input type='checkbox' name='save'>이메일 저장</td>"); // value 값을 주면 value 값에 해당하는 값이 넘어감 (기본on으로 설정)
        out.println("</tr>");
        out.println("<tr>");
        out.println("<th></th>");
        out.println("    <td><button>로그인</button></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        
    }
    
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        
        String type = request.getParameter("type");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String save = request.getParameter("save");
        
         
        if(save!=null) {// 이메일 저장하기를 체크했다면,
            Cookie cookie = new Cookie("email",email);
            cookie.setMaxAge(60*60*24*15);
            response.addCookie(cookie);
        }else {// 이메일 저장하기를 체크 하지않았다면,
            Cookie cookie = new Cookie("email","");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        
        Member loginUser=null;
        
        if(type.equals("manager")) {
            ManagerDao managerDao=(ManagerDao)this.getServletContext()
                                .getAttribute("managerDao");
            loginUser=managerDao.findByEmailPassword(email, password);
        }else if(type.equals("student") ){
            StudentDao studentDao=(StudentDao)this.getServletContext()
                    .getAttribute("studentDao");
            loginUser=studentDao.findByEmailPassword(email, password);
        }else if(type.equals("teacher")) {
            TeacherDao teacherDao=(TeacherDao)this.getServletContext()
                    .getAttribute("teacherDao");
            loginUser=teacherDao.findByEmailPassword(email, password);
        }
        
        if(loginUser!=null) {
            response.sendRedirect("../student/list");
        }else {
            response.sendRedirect("login");
        }
        
    }
    
}
