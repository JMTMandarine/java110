package bitcamp.java110.cms.control.teacher;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class TeacherAddController {
    
    TeacherDao teacherDao;
    
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @RequestMapping("teacher/add")
    public void add(Request request, Response response) {
        Teacher t=new Teacher();
        
        t.setName(request.getParameter("name"));
        t.setEmail(request.getParameter("email"));
        t.setPassword(request.getParameter("password"));
        t.setPay(Integer.parseInt(request.getParameter("pay")));
        t.setTel(request.getParameter("tel"));
        t.setSubjects(request.getParameter("subject"));
        
        teacherDao.insert(t);
        PrintWriter out = response.getWriter();
        out.println("성공적으로 등록하셨습니다.");
        
    }
}
