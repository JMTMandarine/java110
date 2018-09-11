package bitcamp.java110.cms.control.student;

import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.annotaion.Autowired;
import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.annotaion.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentListController {
    
    StudentDao studentDao;
    
    @Autowired
    public void setStudentdao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
  
    @RequestMapping("student/list")
    public void list(Scanner keyIn) {
        List<Student> list = studentDao.findAll();
        for(Student s : list) {
            System.out.printf("%s, %s, ,%s, %s, %b, %s\n"
                                , s.getName()
                                , s.getEmail()
                                , s.getPassword()
                                , s.getSchool()
                                , s.isWorking()
                                , s.getTel());
        }
    }
    
    
}
