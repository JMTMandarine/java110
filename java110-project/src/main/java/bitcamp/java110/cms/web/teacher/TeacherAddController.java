package bitcamp.java110.cms.web.teacher;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.service.TeacherService;
import bitcamp.java110.cms.web.PageController;

@Component("/teacher/add")
public class TeacherAddController implements PageController {
    @Autowired
    TeacherService teacherService;

    @Override
    public String Service(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws Exception {

        if(request.getMethod().equals("GET")) {
            return "/teacher/form.jsp";
        }


        request.setCharacterEncoding("UTF-8");

        Teacher t = new Teacher();
        t.setName(request.getParameter("name"));
        t.setEmail(request.getParameter("email"));
        t.setPassword(request.getParameter("password"));
        t.setTel(request.getParameter("tel"));
        t.setPay(Integer.parseInt(request.getParameter("pay")));
        t.setSubjects(request.getParameter("subjects"));


        Part part = request.getPart("file1");
        if (part.getSize() > 0) {
            String filename = UUID.randomUUID().toString(); //고유파일명을 가짐.
            part.write(request.getServletContext()
                    .getRealPath("/upload/" + filename));
            t.setPhoto(filename);
        }
        teacherService.add(t);
        return "redirect:list";


    }

}