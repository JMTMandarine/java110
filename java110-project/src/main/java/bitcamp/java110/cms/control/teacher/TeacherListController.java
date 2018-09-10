package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.annotaion.RequestMapping;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherListController {
    
    @RequestMapping("teacher/list")
    public void list(Scanner keyIn) {
        int count = 0;
        for(int i=0; i<App.teachers.size();i++) {
            Teacher t=App.teachers.get(i);
            System.out.printf("%d, %s, %s, ,%s, %s, %d, [%s]\n"
                                , count ++  
                                , t.getName()
                                , t.getEmail()
                                , t.getPassword()
                                , t.getTel()
                                , t.getPay()
                                , t.getSubjects());
        }
    }
    
    
}
