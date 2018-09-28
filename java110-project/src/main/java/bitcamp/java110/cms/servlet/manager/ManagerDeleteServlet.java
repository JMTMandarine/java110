package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.ManagerDao;

@WebServlet("/manager/delete")
public class ManagerDeleteServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    
    
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        ManagerDao managerDao= 
                (ManagerDao)this.getServletContext().getAttribute("managerDao");
        int no = Integer.parseInt(request.getParameter("no"));
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>매니저 관리</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>매니저 삭제 결과</h1>");
        
        try{
            managerDao.delete(no); 
            out.println("<p>삭제하였습니다.</p>");
        } catch(Exception e) {
            e.printStackTrace();
            out.println("<p>해당 번호의 매니저가 없습니다!</p>");
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
    
    
    
    
    
    
    
    
    
