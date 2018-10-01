package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@WebServlet("/teacher/detail")
public class TeacherDetailServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        TeacherDao teacherDao=
                (TeacherDao)this.getServletContext().getAttribute("teacherDao");
        int no = Integer.parseInt(request.getParameter("no"));
        Teacher t = teacherDao.findByNo(no);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>강사 관리</title>");
        out.println("<link rel='stylesheet' href='../css/common.css'>");
        out.println("<style>");
        out.println("table, th, td{");
        out.println("border: 1px solid silver");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
     // 페이지에 머리말 포함하기
        RequestDispatcher rd = request.getRequestDispatcher("/header");
        rd.include(request, response);
        out.println("<h1>강사 상세정보</h1>");
        
        if (t == null) {
            System.out.println("<p>해당 번호의 강사 정보가 없습니다!</p>");
        } else {
            out.println("<table>");
            out.println("<tbody>");
            out.printf("<tr> <th>번호</th> <td>%d</td> </tr>\n",t.getNo());
            out.printf("<tr> <th>이름</th> <td>%s</td> </tr>\n",t.getName());
            out.printf("<tr> <th>이메일</th> <td>%s</td> </tr>\n",t.getEmail());
            out.printf("<tr> <th>암호</th> <td>%s</td> </tr>\n",t.getPassword());
            out.printf("<tr> <th>전화</th> <td>%s</td> </tr>\n",t.getTel());
            out.printf("<tr> <th>급여</th> <td>%d</td> </tr>\n",t.getPay());
            out.printf("<tr> <th>과목</th> <td>%s</td> </tr>\n",t.getSubjects());
            out.println("</tbody>");
            out.println("</table>");
            
            out.printf("<button type='button' onclick='remove()'>삭제</button>");
            
        }
        out.println("<script>");
        out.println("function remove() {");
        out.printf("location.href = 'delete?no=%d'",t.getNo());
        out.println("}");
        out.println("</script>");
        //페이지 꼬릿말포함하기
        rd = request.getRequestDispatcher("/footer");
        rd.include(request, response);
        out.println("</body>");
        out.println("</html>");
        
    }
}
